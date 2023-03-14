import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class MixingMilk {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(new File("mixmilk.in"));
        
        int c1 = input.nextInt();
        int m1 = input.nextInt();
        int c2 = input.nextInt();
        int m2 = input.nextInt();
        int c3 = input.nextInt();
        int m3 = input.nextInt();

        for (int i = 1; i <= 100; i++) {
            if (i == 1) {
                m2 += m1;
                m1 = 0;
            }
            if (i % 3 == 1 && i != 1) {
                if (m1 > c1) {
                    m3 = m1 - c1;
                    m1 = c1;
                }
                m2 += m1;
                m1 = 0;
                if (i == 100 && m2 > c2) {
                    m1 = m2 - c2;
                    m2 = c2;
                }
            }
            if (i % 3 == 2) {
                if (m2 > c2) {
                    m1 = m2 - c2;
                    m2 = c2;
                }
                m3 += m2;
                m2 = 0;
            }
            if (i % 3 == 0) {
                if (m3 > c3) {
                    m2 = m3 - c3;
                    m3 = c3;
                }
                m1 += m3;
                m3 = 0;
            }
        }

        input.close();

        BufferedWriter output = new BufferedWriter(new FileWriter("mixmilk.out"));
        output.write("" + m1);
        output.newLine();
        output.write("" + m2);
        output.newLine();
        output.write("" + m3);
        output.close();
    }
}
