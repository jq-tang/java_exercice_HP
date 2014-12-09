package LRU;

import java.util.*;
public class LRU {
    
	class DListNode{
        DListNode(int k, int v){
            val = v;
            key = k;
        }
        int val;
        int key;
        DListNode pre;
        DListNode next;
    }
    class DList{
        DListNode head;
        DListNode tail;
        int size;
        DList(){
            head = new DListNode(0,0);
            tail = new DListNode(0,0);
            head.next = tail;
            tail.pre = head;
            size = 0;
        }
        void insertFront(DListNode node){
            size++;
            head.next.pre = node;
            node.next = head.next;
            head.next = node;
            node.pre = head;
        }
        int getSize(){
            return size;
        }
        int removeTail(){
            size--;
            int key = tail.pre.key;
            tail.pre.next = tail;
            tail.pre = tail.pre.pre;
            return key;
        }
        void remove(DListNode node){
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }
    }
    private HashMap<Integer, DListNode> map;
    private DList list;
    private int capa;
    public LRU(int capacity){
        map = new HashMap<Integer, DListNode>();
        list = new DList();
        capa = capacity;
    }
    public int get(int key) {
        if(map.containsKey(key)){
            DListNode node = map.get(key);
            list.remove(node);
            list.insertFront(node);
            return node.val;
        }
        else{
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            DListNode node = map.get(key);
            list.remove(node);
            node.val = value;
            list.insertFront(node);
        }
        else{
            DListNode node = new DListNode(key, value);
            list.insertFront(node);
            map.put(key, node);
            if(capa < list.getSize()){
                int k = list.removeTail();
                map.remove(k);
            }
        }
    }
    public static void main(String[] args){
        System.out.println("hello");
        LRU lru = new LRU(3);
        lru.set(1,1);
        lru.set(2,2);
        lru.set(3,3);
        lru.set(4,4);
        lru.get(4);
        lru.get(3);
        lru.get(2);
        lru.get(1);
        lru.set(5,5);
        System.out.println(lru.get(1));
        System.out.println(lru.get(2));
    }
}