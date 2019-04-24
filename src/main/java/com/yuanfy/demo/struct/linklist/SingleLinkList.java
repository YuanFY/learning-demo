package com.yuanfy.demo.struct.linklist;

/**
 * 带头节点单链表的实现， 包括以下功能：
 *  1) 返回链表长度
 *  2）往头节点后插入元素
 *  3）往指定位置插入元素
 *  4）删除指定位置节点
 *  5）删除指定数据节点
 *  6）返回指定元素所在位置
 *  7）返回指定位置的节点数据
 *  8）链表反转
 *  9）有序插入
 *  10）判断链表中是否存在环状
 *  11）获取链表的中间节点
 * 注意：此类非线程安全, 且不能插入空元素
 * @author maple.yuan
 * @date 2019-04-04 23:00
 */
public class SingleLinkList<T> {

    private Node first;

    private int size;

    /**
     * 无参构造函数，同时初始化头节点
     */
    public SingleLinkList() {
        first = new Node<>();
        size = 0;
    }

    /**
     * 获取链表元素个数
     * @return int
     */
    public int getSize() {
        return size;
    }

    /**
     * 增加元素， 始终插入头节点后面
     * @param ele 待插入元素
     */
    public void addFirst(T ele) {
        checkEle(ele);
        Node node = new Node<>(ele);
        node.next = first.next;
        first.next = node;
        size ++;
    }

    /**
     * 将元素插入指定位置
     * @param idx 指定位置
     * @param ele 待插入元素
     */
    public void add(int idx, T ele) {
        // 判断非法参数
        checkIdx(idx);
        checkEle(ele);
        // 创建新节点
        Node newNode = new Node<>(ele);
        // 定义临时变量
        int i = 0;
        Node tmpNo = first;
        // 遍历链表，通过下标与idx进行对比
        while (null != tmpNo) {
            if (i == idx) {
                // 相等，则插入
                newNode.next = tmpNo.next;
                tmpNo.next = newNode;
                size ++;
                break;
            }
            // 否则继续遍历
            tmpNo = tmpNo.next;
            i ++;
        }
    }

    /**
     * 获取元素所在链表中的位置
     * @param ele 指定元素
     * @return 链表下标位置
     */
    public int getIndex(T ele) {
        if (size == 0) {
            throw new IllegalArgumentException("链表为空，不存在任何值");
        }
        checkEle(ele);
        int index = 0;
        Node tmpNo = first.next;
        // 遍历链表，通过下标与idx进行对比
        while (null != tmpNo) {
            if (ele.equals(tmpNo.data)) {
               return index;
            }
            // 否则继续遍历
            tmpNo = tmpNo.next;
            index ++;
        }
        throw new IllegalArgumentException("链表中不存在此值");
    }

    /**
     * 获取指定位置上的节点元素
     * @param idx 指定下标
     * @return 对应指定节点元素
     */
    public T get(int idx) {
        checkIdx(idx);
        int i = 0;
        Node tmpNo = first.next;
        // 遍历链表，通过下标与idx进行对比
        while (null != tmpNo) {
            if (i == idx) {
                return (T)tmpNo.data;
            }
            // 否则继续遍历
            tmpNo = tmpNo.next;
            i ++;
        }
        return null;
    }


    /**
     * 移除指定下标元素
     * @param idx 指定下标
     * @return 返回移除值
     */
    public T remove(int idx) {
        // 判断非法参数
        checkIdx(idx);
        // 定义临时变量
        int i = 0;
        Node tmpNo = first;
        Node tmpNextNo = first.next;
        // 遍历链表，通过下标与idx进行对比
        while (null != tmpNextNo) {
            if (i == idx) {
                T data = (T)tmpNextNo.data;
                tmpNo.next = tmpNextNo.next;
                size --;
                return data;
            }
            // 否则继续遍历
            tmpNo = tmpNextNo;
            tmpNextNo = tmpNextNo.next;
            i ++;
        }
        return null;
    }

    /**
     * 移除指定元素
     * @param ele 指定元素
     * @return 移除是否成功
     */
    public boolean remove(T ele) {
        if (0 == size) {
            return false;
        }
        checkEle(ele);
        // 定义临时变量
        Node tmpNo = first;
        Node tmpNextNo = first.next;
        // 遍历链表，通过下标与idx进行对比
        while (null != tmpNextNo) {
            if (ele.equals(tmpNextNo.data)) {
                tmpNo.next = tmpNextNo.next;
                size --;
                return true;
            }
            // 否则继续遍历
            tmpNo = tmpNextNo;
            tmpNextNo = tmpNextNo.next;
        }
        return false;
    }

    /**
     * 链表反转:遍历链表,将每个节点的next指向头节点， 然后再将头节点指向当前节点
     */
    public void reverse() {
        if (0 == size) {
            return;
        }
        Node newFirst = new Node();
        Node tmpNode = first.next;
        while (null != tmpNode) {
            Node node = tmpNode;
            tmpNode = tmpNode.next;
            node.next = newFirst.next;
            newFirst.next = node;
        }
        first = newFirst;
    }


    /**
     * 按升序的方式插入链表：
     * 弄个两个节点（当前节点和下一个节点）进行遍历， 以下一节点为维度进行判断，
     * 如果下一个节点为空则直接将当前节点指向新节点；不为空则判断节点值的大小进行对比。
     * @param ele 待插入的元素
     */
    public void ascSortInsertByInteger(T ele) {
        checkEle(ele);
        Integer value = null;
        if (ele instanceof Integer) {
            value = (Integer) ele;
        }
        if (null == value) {
            throw new IllegalArgumentException("ele is not Integer");
        }
        Node node = new Node<>(ele);
        Node currentNode = first;
        Node tmpNextNode = first.next;
        while (true) {
            // 下一节点为空，则将当前节点指向新节点
            if (null == tmpNextNode) {
                currentNode.next = node;
                size ++;
                return ;
            }
            // 比较值，如果小于新节点的值，则继续遍历
            Integer data = (Integer) tmpNextNode.data;
            if (data.compareTo(value) < 0) {
                currentNode = tmpNextNode;
                tmpNextNode = tmpNextNode.next;
                continue;
            }
            // 插入
            node.next = tmpNextNode;
            currentNode.next = node;
            size ++;
            return ;
        }
    }

    /**
     * 返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     * 思路：慢节点 -> 一个节点迭代， 快节点 -> 两个节点迭代
     */
    public Node middleNode() {
        Node slowNode = first.next;
        Node fastNode = first.next;
        while (null != fastNode && null != fastNode.next) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }

    /**
     * 判断链表中是否有环: 通过快慢节点，快节点必须是慢节点的两倍或者两倍以上，
     * 才能使快慢节点相遇。
     */
    public boolean hasCycle() {
        Node slowNode = first;
        Node fastNode = first;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                return true;
            }
        }
        return false;
    }

    /**
     * 移除倒数第N个节点
     * @param n
     * @return
     */
    public boolean removeNthFromEnd(int n) {
        Node preNode = null;
        Node tmpHead = first.next;
        Node nextHead = first.next;
        int count = 1;
        while (count < n) {
            nextHead = nextHead.next;
            count ++;
            if (null == nextHead) {
                return false;
            }
        }
        while (null != nextHead) {
            if (null == nextHead.next) {
                if (null == preNode) {
                    first = first.next;
                } else {
                    preNode.next = tmpHead.next;
                }
                break;
            }
            preNode = tmpHead;
            tmpHead = tmpHead.next;
            nextHead = nextHead.next;
        }
        size--;
        return true;
    }

    private void checkIdx(int idx) {
        if (idx > size) {
            throw new IllegalArgumentException("idx:" + idx + ",超过了链表的长度:" + size);
        }
        if (idx < 0) {
            throw new IllegalArgumentException("idx必须大于等于0");
        }
    }

    private void checkEle (T ele) {
        if (null == ele) {
            throw new IllegalArgumentException("元素不能为空");
        }
    }

    public void printLinkList() {
        Node tmpNode = first.next;
        int i = 0;
        while (null != tmpNode) {
            System.out.println("i = " + i + ", data = " + tmpNode.data);
            i ++;
            tmpNode = tmpNode.next;
        }
    }
}
