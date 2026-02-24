import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int answer = 0;
            int i = 0;

            while (i < n) {
                if (s.charAt(i) == '#') {
                    i++;
                    continue;
                }

                int j = i;
                while (j < n && s.charAt(j) == '.') {
                    j++;
                }

                int len = j - i;
                if (len == 1) {
                    answer += 1;
                } else if (len == 2) {
                    answer += 2;
                } else {
                    answer += 2;
                }

                i = j;
            }

            System.out.println(answer);
        }
        sc.close();
    }
}