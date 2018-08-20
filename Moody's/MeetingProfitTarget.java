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
  // Had to change the main function to Long data type from Integer to get the correct solution
  static int solve(List<List<Long>> profits) {
    long comparison = 0;
   for (int i = 0; i < profits.size() - 1; i++) {
     comparison = 0;

     long holder = (profits.get(i).get(1)).longValue();
     long holder2 = (profits.get(i).get(0)).longValue();
     comparison = holder - holder2;
     if (comparison > 0) {
       long holder3 = (profits.get(i + 1).get(1)).longValue();


     Long x = new Long(comparison + holder3);
       profits.get(i + 1).set(1, x);
     }

   }

   long holder4 = (profits.get(profits.size() - 1).get(1)).longValue();
   long holder5 = (profits.get(profits.size() - 1).get(0)).longValue();
   if ((holder4 - holder5) > 0) {
     return 1;
   } else {
     return 0;
   }

  }

  public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      long t = Long.parseLong(bufferedReader.readLine().trim());

      for (long tItr = 0; tItr < t; tItr++) {
          long n = Long.parseLong(bufferedReader.readLine().trim());

          List<List<Long>> profits = new ArrayList<>();

          for (int i = 0; i < n; i++) {
              String[] profitsRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

              List<Long> profitsRowItems = new ArrayList<>();

              for (int j = 0; j < 2; j++) {
                  long profitsItem = Long.parseLong(profitsRowTempItems[j]);
                  profitsRowItems.add(profitsItem);
              }

              profits.add(profitsRowItems);
          }

          int res = solve(profits);

          bufferedWriter.write(String.valueOf(res));
          bufferedWriter.newLine();
      }

      bufferedReader.close();
      bufferedWriter.close();
  }
}
