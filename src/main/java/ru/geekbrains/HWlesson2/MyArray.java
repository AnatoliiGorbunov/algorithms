package ru.geekbrains.HWlesson2;

public class MyArray {
    private int[] arr;
    private int capacity;

    public static void main(String[] args) {

    }


    public MyArray(int size) {
        this.capacity = 0;
        this.arr = new int[size];
    }


    public MyArray(int[] init) {
        this.capacity = init.length;
        this.arr = init;
    }

    boolean delete(int value) {
        for (int i = 0; i < this.capacity; i++) {
            if (this.arr[i] == value) {
                System.arraycopy(this.arr, i + 1, this.arr, i, this.capacity - i - 1);
                --capacity;
                return true;
            }
        }
        return false;
    }

    boolean deleteAll(int value) {
        boolean success = false;
        for (int i = 0; i < capacity; i++) {
            if (arr[i] == value) {
                delete(i--);
                success = true;
            }
        }
        return success;
    }

    void deleteAll() {
        capacity = 0;
    }

    void insert(int index, int value) {
        int[] temp = arr;
        if (capacity >= arr.length) {
            arr = new int[capacity * 2];
            System.arraycopy(temp, index, arr, index + 1, capacity);
            arr[index] = value;
            capacity++;
        }
    }

    private void swap(int a, int b) {
        int tmp = this.arr[a];
        this.arr[a] = this.arr[b];
        this.arr[b] = tmp;
    }

    public int sortDoubleBubble() {
        int c = 0;
        boolean flag = false;
        for (int i = 0; i < capacity; i++) {
            for (int j = 0; j < capacity - 1 - i; j++) {
                c++;
                if (arr[i] > arr[j + 1]) {
                    swap(j, j + 1);
                }
            }
            if (!flag) break;

        }
        return c;
    }

}
