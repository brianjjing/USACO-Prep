import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.HashSet;

public class BovineGenomics {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(new File("cownomics.in"));
        String[] NM = input.nextLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);


        String[] spottedSets = new String[N];
        String[] plainSets = new String[N];
        int setsOfPositions = 0;
        
        for (int a = 0; a < N; a++) {
            spottedSets[a] = input.nextLine();
        }

        for (int a = 0; a < N; a++) {
            plainSets[a] = input.nextLine();
        }



        for (int a = 0; a < M-2; a++) {
            for (int b = a+1; b < M-1; b++) {
                for (int c = b+1; c < M; c++) {
                    HashSet<String> spottedHashSets = new HashSet<String>();
                    setsOfPositions++;
                    for (int d = 0; d < N; d++) {
                        spottedHashSets.add(((spottedSets[d]).substring(a,a+1)) + ((spottedSets[d]).substring(b,b+1)) + ((spottedSets[d]).substring(c,c+1)));
                    }
                    for (int e = 0; e < N; e++) {
                        if (spottedHashSets.contains(((plainSets[e]).substring(a,a+1)) + ((plainSets[e]).substring(b,b+1)) + ((plainSets[e]).substring(c,c+1)))) {
                            setsOfPositions--;
                            break;
                        }
                    }
                }
            }
        }

        input.close();

        BufferedWriter output = new BufferedWriter(new FileWriter("cownomics.out"));
        output.write("" + setsOfPositions);
        output.close();
    }
}
