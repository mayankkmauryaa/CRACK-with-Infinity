
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int arr[] = new int[n];

            int c = sc.nextInt();

            for (int j = 0; j < c; j++) {
                int type = sc.nextInt();

                if (type == 0) {
                    int l = sc.nextInt();
                    int r = sc.nextInt();
                    long val = sc.nextLong();
                    for (int k = l - 1; k < r; k++) {
                        arr[k] += val;
                    }
                } else if (type == 1) {
                    int l = sc.nextInt();
                    int r = sc.nextInt();
                    long sum = 0;
                    for (int k = l - 1; k < r; k++) {
                        sum += arr[k];
                    }
                    System.out.println(sum);
                }
                
            }
        }

        sc.close();
    }
}
