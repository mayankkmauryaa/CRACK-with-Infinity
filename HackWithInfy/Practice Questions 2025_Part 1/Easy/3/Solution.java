
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int c = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = MinOilNeeded(arr, c);
        System.out.println(ans);
    }

    private static int MinOilNeeded(int[] arr, int c) {
        int disturbance = 0;
        int oil = 0;
        for (int i = 0; i < arr.length; i++) {
            oil += arr[i];
            if (oil < 0) {
                disturbance += (-oil);
                oil = 0;
            } else if (oil > c) {
                oil = c;
            }
        }
        return disturbance;
    }
}