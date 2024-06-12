package bai_tap;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Count_char_in_arr {
//    Bước 1: Khai báo một chuỗi và gán cho nó một giá trị
//
//Bước 2: Khai báo một biến ký tự và gán hoặc nhập từ bàn phím một giá trị.
//
//Bước 3: Khai báo biến count và gán giá trị 0, để lưu số ký tự đếm được trong chuỗi
//
//Bước 4: Sử dụng vòng lặp duyệt từng ký tự trong chuỗi. Trong quá trình duyệt: so sánh nếu ký tự trong chuỗi bằng ký tự nhập vào thì tăng biến đếm lên 1
//
//Lưu ý:
//
//Hàm str.length() trả về tổng số ký tự trong một chuỗi str
//
//Hàm str.charAt(i) trả về ký tự ở vị trí thứ i trong chuỗi str
//
//Bước 5: In ra giá trị biến đếm.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập một chuỗi bất kỳ:");
        String str = scanner.nextLine();
        char c = 'b';
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }
        System.out.println("Số lần ký tự b xuất hiện là: "+count + " lần.");
    }
}
