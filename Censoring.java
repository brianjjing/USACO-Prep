import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Censoring {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(new File("censor.in"));

        String S = input.nextLine();
        String T = input.nextLine();
        int tLength = T.length();

        StringBuilder censoredWord = new StringBuilder(S.length());
        for (int i = 0; i < S.length(); i++) {
            censoredWord.append(S.charAt(i));
            int censoredWordLength = censoredWord.length();

            if (censoredWordLength - tLength >= 0) {
                if ((censoredWord.substring(censoredWordLength - tLength)).equals(T)) {
                    censoredWord.delete(censoredWordLength - tLength, censoredWordLength);
                }
            }
        }

        input.close();
        BufferedWriter output = new BufferedWriter(new FileWriter("censor.out"));
        output.write(censoredWord.toString());
        output.close();
    }
}
