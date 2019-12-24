package itog2.com;

import java.util.*;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int n = in.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Введите элемент arr[" + i + "]");
            arr[i] = in.nextInt();
        }

        System.out.println("Вы ввели массив со значениями: \n");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }


        shellSort(arr);
        
        System.out.println("\nОтсортированный массив: \n");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
    }


    public static void shellSort(int[] arr) {
        int inner, outer;
        int temp;
        int h = 1;
        // ищем начальное значение h
        while (h <= arr.length / 3) {
            h = h * 3 + 1; // (1, 4, 13, 40, 121, ...)
        }

        while (h > 0) {
            //сдвигаемся на 1 шаг, для h-сортировки следующей группы элементов
            for (outer = h; outer < arr.length; outer++) {
                temp = arr[outer];
                inner = outer;
                //сортируем массив с шагом h
                while (inner > h - 1 && arr[inner - h] >= temp) {
                    arr[inner] = arr[inner - h];
                    inner -= h;
                }
                arr[inner] = temp;
            }
            //на каждом шаге уменьшаем h
            h = (h - 1) / 3;
        }
    }
