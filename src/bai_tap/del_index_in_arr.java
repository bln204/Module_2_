package bai_tap;

import java.util.Scanner;
import java.util.Arrays;
public class del_index_in_arr {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
        String arrayString = Arrays.toString(arr);
        System.out.println(arrayString);
        System.out.println("Nhập số cần xóa:");
        int index = scanner.nextInt();
        scanner.close();


        boolean check = false;
        for (int i = 0; i < arr.length; i++) {
            if(index == arr[i]){
                check = true;
                for (int j = i; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = 0;

            }
        }

        if (!check){
            System.out.println("Số không tồn tại trong mảng!");
        }
        else {
            String arrayString1 = Arrays.toString(arr);
            System.out.println(arrayString1);
        }
    }
}
