import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int k = 0; k < t; k++) {
            String n = sc.next();

            String[] targets = { "00", "25", "50", "75" };
            int minRemovals = Integer.MAX_VALUE;

            for (String target : targets) {

                int pos2 = -1;
                for (int i = n.length() - 1; i >= 0; i--) {
                    if (n.charAt(i) == target.charAt(1)) {
                        pos2 = i;
                        break;
                    }
                }

                if (pos2 == -1)
                    continue;

                int pos1 = -1;
                for (int i = pos2 - 1; i >= 0; i--) {
                    if (n.charAt(i) == target.charAt(0)) {
                        pos1 = i;
                        break;
                    }
                }

                if (pos1 == -1)
                    continue;

                int removals = (n.length() - pos2 - 1) + (pos2 - pos1 - 1);
                minRemovals = Math.min(minRemovals, removals);
            }

            System.out.println(minRemovals);
        }

        sc.close();
    }
}