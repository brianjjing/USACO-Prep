import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class ShellGame {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(new File("shell.in"));
        
        int N = input.nextInt();
        int[] shells = new int[3];
        shells[0] = 1;
        shells[1] = 2;
        shells[2] = 3;
        int[] guessList = new int[3];

        for (int i = 0; i < N; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            int g = input.nextInt();

            int temp = shells[a-1];
            shells[a-1] = shells[b-1];
            shells[b-1] = temp; 

            guessList[shells[g-1]-1]++;
        }

        input.close();

        BufferedWriter output = new BufferedWriter(new FileWriter("shell.out"));
        output.write("" + Math.max(guessList[0], Math.max(guessList[1], guessList[2])));
        output.close();
    }
}
