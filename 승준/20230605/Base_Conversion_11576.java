import java.io.*;
import java.util.*;
public class Base_Conversion_11576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int baseA = Integer.parseInt(input[0]);
        int baseB = Integer.parseInt(input[1]);

        int m = Integer.parseInt(br.readLine());
        String[] digits = br.readLine().split(" ");
        int number = 0;
        int power = m - 1;
        for (String digit : digits) {
            int value = Integer.parseInt(digit);
            number += value * Math.pow(baseA, power);
            power--;
        }

        ArrayList<Integer> convertedDigits = new ArrayList<>();
        while (number > 0) {
            convertedDigits.add(number % baseB);
            number /= baseB;
        }

        Collections.reverse(convertedDigits);
        for (int digit : convertedDigits) {
            System.out.print(digit + " ");
        }
    }
}
