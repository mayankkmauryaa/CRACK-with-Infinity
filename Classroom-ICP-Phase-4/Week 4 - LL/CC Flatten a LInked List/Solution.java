import java.util.*;

public class Solution {

    static class Node {
        int val;
        Node next;
        Node child;

        Node(int val) {
            this.val = val;
        }
    }

    // Flatten function
    static Node flatten(Node head) {
        if (head == null)
            return null;

        Stack<Node> stack = new Stack<>();
        Node cur = head;

        while (cur != null) {
            if (cur.child != null) {
                if (cur.next != null) {
                    stack.push(cur.next);
                }
                cur.next = cur.child;
                cur.child = null;
            }

            if (cur.next == null && !stack.isEmpty()) {
                cur.next = stack.pop();
            }

            cur = cur.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            Map<Integer, Node> map = new HashMap<>();
            Set<Integer> hasParent = new HashSet<>();

            for (int i = 0; i < n - 1; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int type = sc.nextInt();

                map.putIfAbsent(u, new Node(u));
                map.putIfAbsent(v, new Node(v));

                if (type == 0) { // next
                    map.get(u).next = map.get(v);
                } else { // child
                    map.get(u).child = map.get(v);
                }

                hasParent.add(v);
            }

            // Find head (node without parent)
            Node head = null;
            for (int key : map.keySet()) {
                if (!hasParent.contains(key)) {
                    head = map.get(key);
                    break;
                }
            }

            // Flatten
            head = flatten(head);

            // Print flattened list
            Node cur = head;
            while (cur != null) {
                System.out.print(cur.val + " ");
                cur = cur.next;
            }
            System.out.println();
        }
    }
}
