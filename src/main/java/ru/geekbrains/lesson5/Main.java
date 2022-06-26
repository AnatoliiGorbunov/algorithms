package ru.geekbrains.lesson5;

public class Main {

    private static void iterPrint(int i) {//итеративная функция
        while (i >= 0) {
            System.out.print(i-- + " ");
        }
        System.out.print(i + " ");
    }

    private static void recPrint(int i) {//рекурсивная функция
        if (i >= 0) {
            System.out.print(i + " ");
            recPrint(--i);//после принта уменьшить
        }
        System.out.print(i + " ");
    }


    private static int operations = 0;
    private static void  put (int from, int to){
        System.out.printf("%d -> %d | ", from, to);
        if((++operations % 5) == 0) System.out.println();
    }

    private static void hanoi(int from, int to, int n){
        int temp = from ^ to; //01^10=11, 01^11=10, 10^11=01 (двоичная арифметика единица, двойка, тройка)
        if (n==1){
            put(from, to);
        }else {
            hanoi(from, temp, n - 1);
            put(from, to);
            hanoi(temp, to, n - 1);
        }
    }

    public static void main(String[] args) {

        hanoi(1,3,3);
        System.out.println();
        System.out.println(operations);

        iterPrint(5);
        System.out.println();

        recPrint(5);
        System.out.println();

    }

}
