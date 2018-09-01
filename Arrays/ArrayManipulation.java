import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {

      //this is a brute force solution, that times out on HackerRank's test cases. A more efficient solution would be to only traverse the array once, making note of the endpoints of each addition only.
      //for a proper solution, check out https://github.com/RodneyShag/HackerRank_solutions/blob/master/Data%20Structures/Arrays/Algorithmic%20Crush/Solution.java 
        long[] arr = new long[n];

        for (int j = 0; j < queries.length; j++) {
            addFunction(arr, queries[j][0] - 1, queries[j][1] - 1, queries[j][2]);
        }

        long max = arr[0];
        for (int k = 1; k < arr.length; k++) {
          if (arr[k] > max) {
            max = arr[k];
          }
        }
        return max;
    }

    static void addFunction(long[] arr, int index1, int index2, int addAmt) {
        for (int i = index1; i < index2 + 1; i++) {
          arr[i] += addAmt;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
