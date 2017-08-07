package com.danijax.cache;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        if (T <= 1){
            System.out.println("Invalid Input");
            return;
        }

        int[][] arr = new int[T][4];

        for (int i = 0; i < T; i++){
            for (int j = 0; j < 4; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        compareRows(arr);

    }

    public static void compareRows(int[][] arr){
        int count = 0;
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            strings.add(Arrays.toString(arr[i]));
        }
        for (int i = 0; i < strings.size(); i++) {
            for (int j = i + 1; j < strings.size(); j++) {
                if (Objects.equals(strings.get(i), strings.get(j))) {
                    count++;
                    System.out.println((i + 1) + "-" + (j + 1));
                }
            }
        }
        if (count == 0) System.out.println("None");
    }
}
