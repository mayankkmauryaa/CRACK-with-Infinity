import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if (n == 0) {
            System.out.println(0);
            return;
        }

        // Build ListNode linked list
        ListNode head = new ListNode(sc.nextInt());
        ListNode current = head;

        for (int i = 1; i < n; i++) {
            current.next = new ListNode(sc.nextInt());
            current = current.next;
        }

        Solution sol = new Solution();
        System.out.println(sol.getDecimalValue(head));
    }

    public int getDecimalValue(ListNode head) {
        ListNode temp = head;
        int ans = 0;
        int base = 1;
        while (temp != null) {
            temp = temp.next;
            base *= 2;
        }
        temp = head;
        while (temp != null) {
            int val = temp.val;
            base /= 2;
            ans += val * base;
            temp = temp.next;
        }
        return ans;
    }
}
