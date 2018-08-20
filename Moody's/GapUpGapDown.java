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

public class Solution {

    // Complete the solve function below.
    static void solve(List<Integer> low, List<Integer> high, List<Integer> close) {


      int lowCount = 0;
      int highCount = 0;

      for (int i = 1; i < low.size(); i++) {
        if (low.get(i) > close.get(i - 1)) {
          lowCount ++;
        }
        if (high.get(i) < close.get(i - 1)) {
          highCount++;
        }
      }
      System.out.print(lowCount);
      System.out.print(" ");
      System.out.print(highCount);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> low = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> high = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> close = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        solve(low, high, close);

        bufferedReader.close();
    }
}


// Gap up = given day's low price higher than previous close price
// Gap down = given day's high price lower than previous day's close price

//LOGIC: loop through all the days. do two comparisons. increment counters.
