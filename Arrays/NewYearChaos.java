import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {

      // for (int i = 0; i < q.length; i++) {
      //   int currentNum = q[i];
      //   if ((currentNum - 1) - i > 2) {
      //     System.out.println("Too chaotic");
      //     return;
      //   }
      //
      // if ((currentNum - 1) != i) {
      //   int temp = currentNum;
      //   q[i] = q[currentNum - 1];
      //   q[currentNum - 1] = temp;
      //   bribeCount ++;
      // // }
      //
      //
      // }
      // System.out.println(bribeCount);
      int ans = 0;
       for (int i = q.length - 1; i >= 0; i--) {
           if (q[i] - (i + 1) > 2) {
               System.out.println("Too chaotic");
               return;
           }
           for (int j = Math.max(0, q[i] - 2); j < i; j++)
               if (q[j] > q[i]) {
                   ans++;
               }
       }
       System.out.println(ans); 

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
