package com.yuanfy.demo.cache;

import com.yuanfy.demo.struct.linklist.Node;

/**
 * 用链表实现LRU缓存淘汰策略
 * @author maple.yuan
 * @date 2019-06-07 15:37
 */
public class LRUCache<T> {
    /**
     * 定义头节点, 方便测试定义成public
     */
    public Node<T> head;

    private int capaticy;

    private int size;

    public LRUCache(int capaticy) {
        // 头节点
        head = new Node<T>();
        this.capaticy = capaticy;
        size = 0;
    }

    public void set(T ele) {
        // 1、先判断是否存在，存在则将节点提前到头节点
        boolean existFlag = get(ele);
        if (existFlag) {
            return;
        }
        Node<T> node = new Node<T>(ele);
        // 2、判断是否还有容量
        if (size < capaticy) {
            // 还有容量则直接插入表头
            addFirstNode(node);
            size ++;
            return ;
        }
        // 3、没有容量则先移除尾节点
        removeLastNode();
        // 然后插入至头节点
        addFirstNode(node);
    }

    private void addFirstNode(Node<T> node) {
        node.next = head.next;
        head.next = node;
    }

    public boolean get(T ele) {
        Node<T> tmpHead = head.next;
        Node<T> nextNode = head.next;
        Node<T> existNode = null;
        while (null != nextNode) {
            if (nextNode.data == ele || nextNode.data.equals(ele)) {
                // 如果元素存在，则提取Node并删除
                tmpHead.next = nextNode.next;
                nextNode.next = null;
                existNode = nextNode;
                break;
            }
            // 利用快慢节点遍历
            tmpHead = nextNode;
            nextNode = nextNode.next;
        }
        if (null != existNode) {
            // 如果存在，
            addFirstNode(existNode);
            return true;
        }
        return false;
    }

    private boolean removeLastNode() {
        Node<T> tmpHead = head.next;
        Node<T> nextNode = head.next;
        if (null == nextNode) {
            return false;
        }
        while (null != nextNode.next) {
            tmpHead = nextNode;
            nextNode = nextNode.next;
        }
        // 利用快慢节点删除尾节点
        tmpHead.next = null;
        return false;
    }
}
