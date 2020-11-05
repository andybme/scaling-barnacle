import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'getIndexWithClosestAverage' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int getIndexWithClosestAverage(List<Integer> arr) {
        
        if (arr.isEmpty()) return -1;
        double averageLeft, averageRight;
        int indexAnswer = 0;
        double differenceAnswer = 0;
        double left, right;
        for (int i = 0; i <= arr.size(); i++)
        {
            left = 0;
            right = 0;
            for (int j = 0; j < i; j++)
            {
                left += arr.get(j);
            }
            if (i != 0) left = left / i;
            System.out.println(left);
            for (int j = (arr.size() - 1); j > i; j--)
            {
                right += arr.get(j);
            }
            if (i != 0) right = right / i;
            System.out.println(right);
            if (i == 0) differenceAnswer = Math.abs(left - right);
            if (differenceAnswer > Math.abs(left-right))
            {
                differenceAnswer = Math.abs(left - right);
                indexAnswer = i;
                
                System.out.printf("Index Updated, %d", indexAnswer);
            }
            
        }
        System.out.printf("Index is %d", indexAnswer);
        return indexAnswer;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.getIndexWithClosestAverage(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
