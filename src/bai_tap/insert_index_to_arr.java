package bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class insert_index_to_arr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int array[] = {1, 2, 3, 4, 5, 6, 0, 0, 0};
        String arrayString = Arrays.toString(array);
        System.out.println(arrayString);
        System.out.println("Nhập phần tử muốn chèn: ");
        int number = scanner.nextInt();
        System.out.println("Nhập vị trí muốn chèn:");
        int index = scanner.nextInt();


        if (index <= -1 || index >= array.length - 1) {
            System.out.println("Vị trí không hợp lệ!");
        }
        else {
            for (int i = index; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            array[index] = number;
            System.out.println(Arrays.toString(array));
        }

    }
}
