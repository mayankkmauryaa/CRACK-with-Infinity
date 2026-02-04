import java.util.*;

public class Solution {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Reverse linked list in groups of size M
    static Node reverseMSizeGroups(Node head, int M) {
        if (head == null || M == 1)
            return head;

        Node curr = head;
        Node prevGroupTail = null;
        Node newHead = null;

        while (curr != null) {
            Node prev = null;
            Node groupStart = curr;

            for (int i = 0; i < M; i++) {
                Node nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }

            if (newHead == null)
                newHead = prev;

            if (prevGroupTail != null)
                prevGroupTail.next = prev;

            prevGroupTail = groupStart;
        }

        return newHead;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            // Build linked list
            Node head = null, tail = null;
            for (int i = 0; i < N; i++) {
                int val = sc.nextInt();
                Node node = new Node(val);
                if (head == null) {
                    head = node;
                    tail = node;
                } else {
                    tail.next = node;
                    tail = node;
                }
            }

            // Reverse in groups
            head = reverseMSizeGroups(head, M);

            // Print result
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
            System.out.println();
        }
        sc.close();
    }
}
