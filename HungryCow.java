import java.util.Scanner;

public class HungryCow {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        String firstLine = input.nextLine();
        String[] firstLineArray = firstLine.split(" ");
        long N = Long.parseLong(firstLineArray[0]);
        long T = Long.parseLong(firstLineArray[1]);
        long dI = 0;
        long bI = 0;
        long b = 0;
        long firstDayWithoutFood = 1;

        for (int x = 1; x <= N; x++) {
            String[] deliveries = (input.nextLine()).split(" ");
            dI = Long.parseLong(deliveries[0]);
            bI = Long.parseLong(deliveries[1]);
            if (dI > T || firstDayWithoutFood >= T) {
                break;
            }

            if (firstDayWithoutFood < dI) {
                firstDayWithoutFood = dI;
            }

            if (firstDayWithoutFood + bI - 1 > T) {
                bI = T - firstDayWithoutFood + 1;
            }

            b += bI;
            firstDayWithoutFood += bI;
        }
        
        input.close();
        System.out.println(b);
    }
}
