package thuc_hanh;

public class Print_shape {
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            String c = " ";
            for (int j = 0; j < i; j++) {
                c += "* ";
            }
            System.out.println(c);
        }
        System.out.println();

        for (int i = 0; i < 4; i++) {
            String b = " ";
            for (int j = 0; j < 6; j++) {
                b += "* ";
            }
            System.out.println(b);

        }

    }
}
