package com.yuanfy.demo.struct.linklist;

/**
 * 节点类
 * @author maple.yuan
 * @date 2019-04-21 21:56
 */
public class Node<T> {
    public T data;
    public Node<T> next;

    public Node() {}

    public Node(T ele) {
        data = ele;
        next = null;
    }
}
