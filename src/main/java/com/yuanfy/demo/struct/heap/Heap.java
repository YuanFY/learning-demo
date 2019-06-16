package com.yuanfy.demo.struct.heap;

/**
 * 堆结构：底层用数组实现,以整型为例
 * @author maple.yuan
 * @date 2019-06-16 00:30
 */
public class Heap {
    private int[] table;
    private int size;
    private int capacity;

    public Heap(int capacity) {
        table = new int[capacity + 1];
        size = 0;
        this.capacity = capacity;
    }

    public Heap(int[] arr) {
        this(arr.length);
        for (int i = 0; i < arr.length; i ++) {
            table[i+1] = arr[i];
        }
    }

    /**
     * 默认自下而上建堆
     * @param ele
     * @return
     */
    public boolean insert(int ele) {
        if (size >= capacity) {
            return false;
        }
        ++ size;
        table[size] = ele;
        int i = size;
        // 子节点与父节点比较，父节点应大于子节点
        while(i/2 > 0 && table[i] > table[i/2]) {
            // 如果字节点大于父节点，则交换
            swap(i, i/2);
            i = i/2;
        }
        return true;
    }


    /**
     * 自上而下建堆
     * @param n
     */
    public void buildHeap(int n){
        for (int i = n/2; i > 0; i --) {
            heapify(n, i);
        }
    }

    private void heapify(int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && table[i] < table[i*2]) {
                maxPos = i * 2;
            }
            if ((i * 2 + 1) <= n && table[maxPos] < table[i*2+1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            // 取最大与之交换
            swap(i, maxPos);
            i = maxPos;
        }
    }

    public void sort(int n) {
        int k = n;
        while (k > 1) {
            // 取最后一个与第一个交换，然后重新建堆：其实就是取最大的放最后后面。
            swap(1, k);
            -- k;
            heapify(k, 1);
        }
    }

    public int[] get() {
        return table;
    }

    private void swap(int i, int j) {
        int tmp = table[i];
        table[i] = table[j];
        table[j] = tmp;
    }

}
