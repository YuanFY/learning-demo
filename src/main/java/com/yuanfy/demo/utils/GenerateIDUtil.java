package com.yuanfy.demo.utils;

/**
 * Twitter的分布式自增ID雪花算法snowflake
 * 拓展：数据机器位可以随意分配，比如
 * @author maple.yuan
 * @date 2019-12-21 16:41
 */
public class GenerateIDUtil {

    /**
     * 起始时间戳,(UTC 2019-01-01 00:00:00)
     */
    private final long START_TIME = 1546272000000L;

    /**
     * 毫秒内序列在id中所占的位数
     */
    private final long SEQUENCE_BITS = 12L;

    /**
     * 最大生成序列的掩码，这里为4095 (0b111111111111=0xfff=4095)
     */
    private final long MAX_SEQUENCE_CODE = ~(-1L << SEQUENCE_BITS);

    /**
     * 机器ID所占的位数
     */
    private final long WORKER_ID_BITS = 5L;

    /**
     * 数据标示ID所占的位数
     */
    private final long DATA_ID_BITS = 5L;

    /**
     * 支持的最大机器ID,结果是31 (-1向左移5位 = -32， 然后取反)
     */
    private final long MAX_WORKER_ID =  ~(-1L << WORKER_ID_BITS);

    /**
     * 支持的ID,结果是31 (-1向左移5位 = -32， 然后取反)
     */
    private final long MAX_DATA_ID =  ~(-1L << DATA_ID_BITS);

    /**
     * 机器ID向左移12位
     */
    private final long WORKER_ID_SHIFT_BITS = SEQUENCE_BITS;

    /**
     * 数据标识ID向左移17(12+5)位
     */
    private final long DATA_ID_SHIFT_BITS = SEQUENCE_BITS + WORKER_ID_BITS;

    /**
     * 时间戳向左移22(12+5+5)位
     */
    private final long TIMESTAMP_SHIFT_BITS = SEQUENCE_BITS + WORKER_ID_BITS + DATA_ID_BITS;

    /**
     * 最大时间偏移量
     */
    private final long MAX_TIMESTAMP_OFFSET = 5L;

    /**
     * 数据标识ID（0～31）
     */
    private long dataId;

    /**
     * 机器ID（0～31）
     */
    private long workerId;

    /**
     * 毫秒内序列（0～4095）
     */
    private long sequenceId;

    /**
     * 上次生成ID的时间戳
     */
    private long lastTimestamp = -1L;

    /**
     * 获得下一个ID (该方法是线程安全的)
     * @return snowflakeId
     */
    public synchronized long nextId() throws Exception {

        long timestamp = currentTimeMillis();

        // 如果当前时间小于上一次ID生成的时间戳,说明系统时钟发生了回拨
        if (timestamp < lastTimestamp) {

            long offset = lastTimestamp - timestamp;

            if (offset <= MAX_TIMESTAMP_OFFSET) {
                // 时间偏差大小小于5ms，则等待两倍时间
                try {
                    wait(offset << 1);

                    // 等完之后重新获取当前时间
                    timestamp = currentTimeMillis();

                    // 如果还小于则跑出异常
                    if (timestamp < lastTimestamp) {
                        throw new Exception("clock callback causes the time to be shorter than the last update time");
                    }
                } catch (Exception e) {
                    throw e;
                }
            } else {
                throw new Exception("clock callback causes the time to be shorter than the last update time");
            }
        }

        // 如果是同一时间生成的，则进行毫秒内序列
        if (timestamp == lastTimestamp) {
            sequenceId = (sequenceId + 1) & MAX_SEQUENCE_CODE;

            if (sequenceId >= 0) {
                // 毫秒内序列溢出, 阻塞到下一个毫秒获得新的时间戳
                timestamp = blockTillNextMillis(lastTimestamp);
            }
        } else {
            // 时间戳改变，毫秒内序列ID重置
            sequenceId = 0L;
        }

        // 赋值给最后时间戳标识
        lastTimestamp = timestamp;

        // 移位并通过按位或运算拼到一起组成64位的ID
        return ((timestamp - START_TIME) << TIMESTAMP_SHIFT_BITS)
                | (MAX_DATA_ID << DATA_ID_SHIFT_BITS)
                | (MAX_WORKER_ID << WORKER_ID_SHIFT_BITS)
                | sequenceId;
    }

    /**
     * 返回以毫秒为单位的当前时间
     * @return 当前时间(毫秒)
     */
    private long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    /**
     * 阻塞到下一个毫秒，直到获得新的时间戳
     * @param lastTimestamp 上次生成ID的时间截
     * @return 当前时间戳
     */
    private long blockTillNextMillis(long lastTimestamp) {
        long timestamp = currentTimeMillis();

        while (timestamp <= lastTimestamp) {
            timestamp = currentTimeMillis();
        }
        return timestamp;
    }
}
