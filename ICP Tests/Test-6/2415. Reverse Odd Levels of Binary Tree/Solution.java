import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {

    // Build tree from array (level order)
    public static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null)
            return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();

            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    // Reverse odd levels
    public static void reverseOddLevels(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left, root.right, 1);
    }

    private static void dfs(TreeNode left, TreeNode right, int level) {
        if (left == null || right == null)
            return;

        if (level % 2 == 1) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }

        dfs(left.left, right.right, level + 1);
        dfs(left.right, right.left, level + 1);
    }

    // Print tree level order
    public static void printLevelOrder(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");

            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input:
        // n
        // array elements (use -1 for null if needed)
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            if (val == -1)
                arr[i] = null;
            else
                arr[i] = val;
        }

        TreeNode root = buildTree(arr);

        reverseOddLevels(root);

        printLevelOrder(root);
    }
}
