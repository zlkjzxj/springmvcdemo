package com.springjms;

public class BubbleSort {
    //两种思路，一种是把最大的往后放，一种是把最小的往前放。
    public static void main(String[] args) {
        int[] array = {10, 5, 8, 2, 4, 6};
        /*int[] array1 = new int[10];
        int[] array2 = new int[]{1, 5, 4};
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < array.length - 1; i++) {
                int temp = 0;
                for (int j = 0; j < array.length - i - 1; j++) {//要用第一个和后面的都去比较
                    if (array[j] > array[j + 1]) {
                        temp = array[j + 1];
                        array[j + 1] = array[j];
                        array[j] = temp;
                        flag=true;
                    }
                    //优化判断
                    if(!flag){// 若没有交换则排序完成，直接跳出
                        break;
                    }
                }

            }
            System.out.println(array);
        }*/
//倒序
        int temp = 0;
        for (int i = 0; i <array.length-1 ; i++) {
            for (int j = array.length-1; j >i ; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
        System.out.println(array);
    }

}
