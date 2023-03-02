import java.util.Scanner;
 
public class MaxDistance{
    
    public static void main(String[] args) throws NumberFormatException{
        
        Scanner input = new Scanner(System.in);
        
        int N = Integer.parseInt(input.nextLine());
        String[] xN = (input.nextLine()).split(" ");
        String[] yN = (input.nextLine()).split(" ");
        long maxDistance = 0;
        
        for (int p = 0; p < N; p++) {
            
            for (int q = p+1; q < N; q++) {

                int deltaX = Integer.parseInt(xN[p]) - Integer.parseInt(xN[q]);
                int deltaY = Integer.parseInt(yN[p]) - Integer.parseInt(yN[q]);
                long x = deltaX*deltaX + deltaY*deltaY;

                if (x > maxDistance) {
                    maxDistance = x;
                }
                
            }
            
        }

        input.close();
        System.out.println(maxDistance);
        
    }
}
