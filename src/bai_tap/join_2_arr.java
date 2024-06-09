package bai_tap;
import java.util.Scanner;
import java.util.Arrays;
public class join_2_arr {
    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4, 5, 6};
        int arr2[] = {7, 8, 9, 10, 11, 12};
        String arrayString = Arrays.toString(arr1);
        System.out.println(arrayString);
        String arrayString1 = Arrays.toString(arr2);
        System.out.println(arrayString);
        System.out.println("Mảng sao khi nối:");
        int arr3[] = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            arr3[i + arr1.length] = arr2[i];
        }
        System.out.println(Arrays.toString(arr3));
    }
}
