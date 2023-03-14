import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class BlockGame {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(new File("blocks.in"));
        BufferedWriter output = new BufferedWriter(new FileWriter("blocks.out"));

        int N = input.nextInt();
        String[][] spellingBoards = new String[N][2];

        for (int i = 0; i < N; i++) {
            for (int h = 0; h < 2; h++) {
                spellingBoards[i][h] = input.next();
            }
        }

        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < 26; i++) {
            int amountNeeded = 0;
            for (int h = 0; h < N; h++) {
                int countInFirst = 0;
                for (int a = 0; a < spellingBoards[h][0].length(); a++) {
                    if ((spellingBoards[h][0].substring(a,a+1)).equals(alphabet.substring(i,i+1))) {
                        countInFirst++;
                    }
                }
                int countInSecond = 0;
                for (int a = 0; a < spellingBoards[h][1].length(); a++) {
                    if ((spellingBoards[h][1].substring(a,a+1)).equals(alphabet.substring(i,i+1))) {
                        countInSecond++;
                    }
                }
                if (countInFirst > countInSecond) {
                    amountNeeded += countInFirst;
                }
                else {
                    amountNeeded += countInSecond;
                }
            }


            output.write("" + amountNeeded);
            if (i != 25) {
                output.newLine();
            }
        }
        
        input.close();
        output.close();
    }
}
