import java.util.Scanner;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class CowGymnastics {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(new File("gymnastics.in"));
        String[] KN = (input.nextLine()).split(" ");
        int K = Integer.parseInt(KN[0]);
        int N = Integer.parseInt(KN[1]);
        int pairs = 0;
        int comparisons = ((N)*(N-1))/2;
        String[] setOfComparisons = new String[comparisons];
        String[] firstSessionRankings = (input.nextLine()).split(" ");
        for (int i = 0; i < (N - 1); i++) {
            for (int f = (i+1); f < N; f++) {
                setOfComparisons[pairs] = (firstSessionRankings[i] + " > " + firstSessionRankings[f]);
                pairs++;
            }
        }
        int consistentPairs = 0;

        if ((K-1) == 0) {
            BufferedWriter output = new BufferedWriter(new FileWriter("gymnastics.out"));
            output.write("" + comparisons);
            output.close();
            System.exit(0);
        }

            
        int rows = 0;
        String[][] setOfCompared = new String[(K-1)][comparisons];
        for (int practiceSessions = 2; practiceSessions <= K; practiceSessions++) {
            String[] sessionRankings = (input.nextLine()).split(" ");
            int columns = 0;
            for (int i = 0; i < (N - 1); i++) {
                for (int f = (i+1); f < N; f++) {
                    setOfCompared[rows][columns] = (sessionRankings[i] + " > " + sessionRankings[f]);
                    columns++;
                }
            }
            rows++;
        }

        int trueCounter = 0;
        for (int i = 0; i < comparisons; i++) {
            trueCounter = 0;
            for (int f = 0; f < (K-1); f++) {
                for (int g = 0; g < comparisons; g++) {
                    if ((setOfComparisons[i]).equals(setOfCompared[f][g])) {
                        trueCounter++;
                    }
                    if (trueCounter == (K-1)) {
                        consistentPairs++;
                        trueCounter = 0;
                    }
                }
            } 
        }

        System.out.println(consistentPairs);
        input.close();

        BufferedWriter output = new BufferedWriter(new FileWriter("gymnastics.out"));
        output.write("" + consistentPairs);
        output.close();
    }
}
