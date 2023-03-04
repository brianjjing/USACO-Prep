import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class MilkPails {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(new File("pails.in"));
        String[] XYM = input.nextLine().split(" ");
        int X = Integer.parseInt(XYM[0]);
        int Y = Integer.parseInt(XYM[1]);
        int M = Integer.parseInt(XYM[2]);
        int a = M/X;
        int aX = 0;
        int maxMilk = 0;

        for (int f = 0; f <= a && maxMilk < M; f++) {
            aX = f*X;
            int currentMaxMilk = aX + (Y)*((M - aX)/Y);
            if (currentMaxMilk > maxMilk) {
                maxMilk = currentMaxMilk;
            }
        }

        input.close();

        BufferedWriter output = new BufferedWriter(new FileWriter("pails.out"));
        output.write("" + maxMilk);
        output.close();
    }
}
