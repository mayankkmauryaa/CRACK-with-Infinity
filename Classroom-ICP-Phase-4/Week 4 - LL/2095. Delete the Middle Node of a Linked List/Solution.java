import java.util.Scanner;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of nodes
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println(0);
            return;
        }

        // Create linked list
        ListNode head = new ListNode(sc.nextInt());
        ListNode current = head;

        for (int i = 1; i < n; i++) {
            current.next = new ListNode(sc.nextInt());
            current = current.next;
        }

        // Call deleteMiddle
        Solution sol = new Solution();
        head = sol.deleteMiddle(head);

        // Print resulting list
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    // deleteMiddle logic unchanged
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = new ListNode(0);
        slow.next = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}
