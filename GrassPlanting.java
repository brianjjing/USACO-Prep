import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GrassPlanting {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(new File("planting.in"));

        int N = input.nextInt();
        int maxConnections = 0;
        ArrayList<Integer>[] adjacentFarms = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjacentFarms[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            adjacentFarms[a - 1].add(b - 1);
            adjacentFarms[b - 1].add(a - 1);
        }

        for (int i = 0; i < N - 1; i++) {
            int maybeMaxConnections = adjacentFarms[i].size();
            if (maybeMaxConnections > maxConnections) {
                maxConnections = maybeMaxConnections;
            }
        }

        int minTypes = maxConnections + 1;

        
        
        BufferedWriter output = new BufferedWriter(new FileWriter("planting.out"));
        input.close();
        output.write("" + minTypes);
        output.close();
    }
}
