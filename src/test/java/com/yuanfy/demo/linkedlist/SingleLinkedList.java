package com.yuanfy.demo.linkedlist;

/**
 * @author maple.yuan
 * @date 2021-03-23 20:51
 */
public class SingleLinkedList {
    Node head;

    public SingleLinkedList() {
        // 空的头节点
        head = new Node();
    }

    public void add(int data) {
        // 头插法
        Node node = new Node(data);
        node.next = head.next;
        head.next = node;
    }

    // 1 2 3 4
    // 1 -> null  2 3 4
    //
    // 2 -> 1
    public void reserve() {
        Node reserveHead = new Node();
        Node tempNode = head;
        while (tempNode.next != null) {
            Node nextNode = tempNode.next;
            tempNode = tempNode.next;


            // 方法一， 缺点：增加了内存
            Node newNode = new Node(nextNode.data);
            newNode.next = reserveHead.next;
            reserveHead.next = newNode;
        }
        head = reserveHead;
    }

    public void reserve2() {
        Node reserveHead = new Node();
        Node tempNode = head.next;
        while (tempNode != null) {

            Node nextNode = tempNode;
            tempNode = tempNode.next;


            nextNode.next = reserveHead.next;
            reserveHead.next = nextNode;
        }
        head = reserveHead;
    }

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(1);
        singleLinkedList.add(2);
        singleLinkedList.add(3);
        singleLinkedList.add(4);

        Node head = singleLinkedList.head;
        while (head.next != null) {
            head = head.next;
            System.out.print(head.data + " ");
        }
        System.out.println();

        singleLinkedList.reserve2();

        head = singleLinkedList.head;
        while (head.next != null) {
            head = head.next;
            System.out.print(head.data + " ");
        }
    }
}

class Node{
    Node next;
    int data;

    public Node(){}

    public Node(int data) {
        this.data = data;
    }
}
