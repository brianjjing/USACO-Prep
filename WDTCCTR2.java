import java.util.Scanner;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class WDTCCTR2 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(new File("circlecross.in")); 

        String list = input.nextLine();
        int crossingPairs = 0;

        for (int a = 0; a < 52; a++) {
            int x = list.charAt(a);
            for (int b = a+1; b < 52; b++) {
                int y = list.charAt(b);
                if (x != y) {
                    boolean found = false;
                    for (int c = b+1; c < 52 && !found; c++) {
                        if (list.charAt(c) == x) {
                            for (int d = c+1; d < 52 && !found; d++) {
                                if (list.charAt(d) == y) {
                                    crossingPairs++;
                                    found = true;
                                }
                            }
                        }
                    }
                }
            }
        }

        input.close();

        BufferedWriter output = new BufferedWriter(new FileWriter("circlecross.out"));
        output.write("" + crossingPairs);
        output.close();
    }
}
