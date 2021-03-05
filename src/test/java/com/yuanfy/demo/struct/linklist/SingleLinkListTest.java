package com.yuanfy.demo.struct.linklist;

import com.yuanfy.demo.struct.linklist.SingleLinkList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;

/**
 * @author maple.yuan
 * @date 2019-04-04 23:29
 */
public class SingleLinkListTest {

    /**
     * 测试链表的基本功能：插入和遍历输出
     */
    @Test
    public void test_base() {
        int size = 10;
        SingleLinkList<Integer> list = new SingleLinkList<>();
        for (int i = 0; i < size; i ++) {
            list.addFirst(i);
        }
        Assert.assertEquals(list.getSize(), size);
        list.printLinkList();
    }

    /**
     * 测试随机插入功能
     */
    @Test
    public void test_random_insert() {
        SingleLinkList<Integer> list = new SingleLinkList<>();
        list.add(0, 10);
        list.add(1, 11);
        list.add(0, 12);

        list.printLinkList();
    }

    @Test
    public void test_get() {
        int size = 10;
        SingleLinkList<Integer> list = new SingleLinkList<>();
        for (int i = 0; i < size; i ++) {
            list.addFirst(i+1);
        }
        Assert.assertEquals(list.getSize(), size);
        Assert.assertEquals(list.get(1).intValue(), size - 1);
        Integer ele = 1;
        Assert.assertEquals(list.getIndex(ele), size - 1);
    }

    @Test
    public void test_removeIdx() {
        int size = 10;
        SingleLinkList<Integer> list = new SingleLinkList<>();
        for (int i = 0; i < size; i ++) {
            list.addFirst(i*10);
        }
        Integer value = list.remove(5);
        Assert.assertEquals(value.intValue(), 40);
        Assert.assertEquals(list.getSize(), size-1);
        Assert.assertEquals(list.get(5).intValue(), 30);
        list.remove((Integer)90);
        Assert.assertEquals(list.getSize(), size-2);
        Assert.assertEquals(list.get(0).intValue(), 80);
        list.printLinkList();
    }

    @Test
    public void test_reverse() {
        int size = 10;
        SingleLinkList<Integer> list = new SingleLinkList<>();
        for (int i = 0; i < size; i ++) {
            list.addFirst(i+1);
        }
        list.printLinkList();
        Assert.assertEquals(list.get(0).intValue(), 10);
        Assert.assertEquals(list.get(size-1).intValue(), 1);

        list.reverse();
        list.printLinkList();
        Assert.assertEquals(list.get(0).intValue(), 1);
        Assert.assertEquals(list.get(size-1).intValue(), 10);
    }

    @Test
    public void test_ascSortInsert() {
        Integer[] arr = {10, 0, 2, 1, 3, 7, 4, 9, 8, 6, 5};
        SingleLinkList<Integer> list = new SingleLinkList<>();
        for (Integer integer : arr) {
            list.ascSortInsertByInteger(integer);
        }
        list.printLinkList();
        Assert.assertEquals(list.getSize(), arr.length);
        Assert.assertEquals(list.get(0).intValue(), 0);
    }

    @Test
    public void test_middleNode() {
        SingleLinkList<Integer> list = new SingleLinkList<>();
        list.addFirst(6);
        Node node = list.middleNode();
        Assert.assertEquals(node.data, 6);

        list.addFirst(5);
        node = list.middleNode();
        Assert.assertEquals(node.data, 6);

        list.addFirst(4);
        node = list.middleNode();
        Assert.assertEquals(node.data, 5);

        list.addFirst(3);
        node = list.middleNode();
        Assert.assertEquals(node.data, 5);

        list.addFirst(2);
        node = list.middleNode();
        Assert.assertEquals(node.data, 4);

        list.addFirst(1);
        node = list.middleNode();
        Assert.assertEquals(node.data, 4);
    }

    @Test
    public void test_removeNthFromEnd() {
        Integer[] arr = {10,9,8,7,6,5,4,3,2,1,0};
        SingleLinkList<Integer> list = new SingleLinkList<>();
        for (Integer integer : arr) {
            list.addFirst(integer);
        }
        Assert.assertEquals(list.get(6).intValue(), 6);
        //list.removeNthFromEnd(5);
       // Assert.assertEquals(list.get(6).intValue(), 1);

        list.removeNthFromEnd(5);
        list.printLinkList();
    }

    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        /*for (String item : list) {
            if (item.equals("4")) {
                System.out.println(item);
                list.remove(item);
            }
        }
        System.out.println(list);*/

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (item.equals("3")) {
                System.out.println(item);
                iterator.remove();
            }
        }
        System.out.println(list);

        Map<String, String> infoMap = new HashMap<>();
        infoMap.put("name", "Zebe");
        infoMap.put("site", "www.zebe.me");
        infoMap.put("email", "zebe@vip.qq.com");
        infoMap.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
    }

    @Test
    public void test_fail_fast() {
        Map<String, String> premiumPhone = new HashMap<>();
        premiumPhone.put("Apple", "iPhone");
        premiumPhone.put("HTC", "HTC one");
        premiumPhone.put("Samsung", "S5");


        Iterator iterator = premiumPhone.entrySet().iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            premiumPhone.put("Sony", "Xperia Z");
            //iterator.remove();
        }
    }

    @Test
    public void test_fail_safe() {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            list.add(4);
            //iterator.remove();
        }
    }
}
