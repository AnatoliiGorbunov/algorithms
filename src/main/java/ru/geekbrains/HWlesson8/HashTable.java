package ru.geekbrains.HWlesson8;

import java.util.LinkedList;

public class HashTable {
    private static final int DOUBLE_HASH_CONST = 10;

    private LinkedList[] hashArray;
    private int currentSize;

    public HashTable(int maxSize) {
        this.hashArray = new LinkedList[maxSize];
        this.currentSize = 0;
    }

    public int hashFunc(int key) {
        return key % hashArray.length;
    }

    public int hashFunc(Item item) {
        return hashFuncDouble(item.getData());
    }

    public int hashFuncDouble(int key) {
        return DOUBLE_HASH_CONST - (key % DOUBLE_HASH_CONST);
    }

    public void insert(Item item) {
        int index = hashFunc(item);
        int count = 0;

        int stepSize = hashFuncDouble(item.getData());
        if (hashArray[index] == null) {
            LinkedList<Item> arrayItem = new LinkedList<>();
            hashArray[index] = arrayItem;
            arrayItem.addFirst(item);
        } else {
            hashArray[index].add(item);
        }
    }

    public boolean remove(Item item) {
        return remove(item.getData()) != null;
    }

    public Item remove(int key) {
        int index = hashFuncDouble(key);

        LinkedList<Item> list = hashArray[index];

        if (hashArray[index] != null) {
            for (Item item : list) {
                if (item.getData() == key) {
                    hashArray[index].remove(item);
                    return item;
                }
            }

        }
        return null;

    }

    public Item find(int key) {
        int index = hashFuncDouble(key);

        LinkedList<Item> list = hashArray[index];

        if (list != null) {
            for (Item item : list) {
                if (item.getData() == key) {
                    return item;
                }
            }

        }
        return null;

    }

    public void display() {
        for (int i = 0; i < hashArray.length; i++) {
            /*if(hashArray[i] != null){
            }*/
            System.out.println(hashArray[i]);
        }
    }
}
