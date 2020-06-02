package lesson4;

import java.util.Arrays;
import java.util.List;

public class integer5 {

    public static void main(String args[]) {

        int[] arr = {3, -5, 1, -2, 9, -7};
        int[] position = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            position[i] = i;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                    int tem = position[i];
                    position[i] = position[j];
                    position[j] = tem;
                }
            }
        }
        System.out.println("Minimum number is = " + arr[0]);

        System.out.println("Position in array is = " + position[0]);

    }
}


