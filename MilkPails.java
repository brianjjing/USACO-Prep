import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class MilkPails {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(new File("pails.in"));
        String[] XYM = (input.nextLine()).split(" ");
        int X = Integer.parseInt(XYM[0]);
        int Y = Integer.parseInt(XYM[1]);
        int M = Integer.parseInt(XYM[2]);
        int a = M/X;
        int b = M/Y;
        int maxMilk = 0;

        for (int f = 0; f <= a; f++) {
            for (int i = 0; i <= b; i++) {
                int aX = (f)*(X);
                int bY = (i)*(Y);
                if (((aX) + (bY)) <= M) {
                    if (((aX) + (bY)) > maxMilk) {
                        maxMilk = aX + bY;
                    }
                }
            }
        }

        input.close();

        BufferedWriter output = new BufferedWriter(new FileWriter("pails.out"));
        output.write("" + maxMilk);
        output.close();
    }
}
