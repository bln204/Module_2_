package thuc_hanh;

import java.util.Arrays;
public class Reverse {
    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Mảng trước khi đảo ngược:");
        System.out.println(Arrays.toString(array));
        int first = 0;
        int last = array.length - 1;
        while ( first < last){
            int temp = array[first];
            array[first] = array[last];
            array[last] = temp;
            first++;
            last--;
        }
        System.out.println();
        System.out.println("Mảng sau khi đảo ngược:");
        System.out.println(Arrays.toString(array));
    }
}
