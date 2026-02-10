import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public TreeNode buildTree(Integer[] values) {
        if (values.length == 0 || values[0] == null)
            return null;

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode curr = queue.poll();

            if (values[i] != null) {
                curr.left = new TreeNode(values[i]);
                queue.offer(curr.left);
            }
            i++;

            if (i < values.length && values[i] != null) {
                curr.right = new TreeNode(values[i]);
                queue.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    public void preorder(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;
        ans.add(root.val);
        preorder(root.left, ans);
        preorder(root.right, ans);
    }

    public void inorder(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }

    public void postorder(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;
        postorder(root.left, ans);
        postorder(root.right, ans);
        ans.add(root.val);
    }

    public void printTree(TreeNode root) {
        if (root == null)
            return;

        int height = getHeight(root);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int level = 0;

        while (level < height) {
            int size = q.size();
            int spaces = (int) Math.pow(2, height - level);

            // Print node values
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                printSpaces(spaces);
                if (node == null) {
                    System.out.print(" ");
                    q.offer(null);
                    q.offer(null);
                } else {
                    System.out.print(node.val);
                    q.offer(node.left);
                    q.offer(node.right);
                }
                printSpaces(spaces);
            }
            System.out.println();

            // Print slashes (except last level)
            if (level < height - 1) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.peek();

                    printSpaces(spaces);
                    if (node != null) {
                        System.out.print(node.left != null ? "/" : " ");
                        printSpaces(spaces * 2 - 1);
                        System.out.print(node.right != null ? "\\" : " ");
                    }
                    printSpaces(spaces);
                }
                System.out.println();
            }

            level++;
        }
    }

    private int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    private void printSpaces(int n) {
        for (int i = 0; i < n; i++)
            System.out.print(" ");
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // static means no need to create object to call functions
        // if no static functions create object of the class then call with
        // obj.functionName();

        Integer[] input = { 1, 2, 3, null, 4, 5, 6, 7, 8, null, 9, 10, 11 };
        TreeNode root = sol.buildTree(input);
        sol.printTree(root);

        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        sol.preorder(root, pre);
        sol.inorder(root, in);
        sol.postorder(root, post);

        System.out.println("Preorder: " + pre);
        System.out.println("Inorder: " + in);
        System.out.println("Postorder: " + post);
    }
}

// class Solution1 {

// public static TreeNode buildTree(Integer[] values) {
// if (values.length == 0 || values[0] == null)
// return null;

// TreeNode root = new TreeNode(values[0]);
// Queue<TreeNode> queue = new LinkedList<>();
// queue.offer(root);

// int i = 1;
// while (!queue.isEmpty() && i < values.length) {
// TreeNode curr = queue.poll();

// if (values[i] != null) {
// curr.left = new TreeNode(values[i]);
// queue.offer(curr.left);
// }
// i++;

// if (i < values.length && values[i] != null) {
// curr.right = new TreeNode(values[i]);
// queue.offer(curr.right);
// }
// i++;
// }
// return root;
// }

// public static void preorder(TreeNode root, List<Integer> ans) {
// if (root == null)
// return;
// ans.add(root.val);
// preorder(root.left, ans);
// preorder(root.right, ans);
// }

// public static void inorder(TreeNode root, List<Integer> ans) {
// if (root == null)
// return;
// inorder(root.left, ans);
// ans.add(root.val);
// inorder(root.right, ans);
// }

// public static void postorder(TreeNode root, List<Integer> ans) {
// if (root == null)
// return;
// postorder(root.left, ans);
// postorder(root.right, ans);
// ans.add(root.val);
// }

// public static void main(String[] args) {

// Integer[] input = { 1, 2, 3, null, 4, 5 };

// TreeNode root = Solution1.buildTree(input);
// List<Integer> pre = new ArrayList<>();
// List<Integer> in = new ArrayList<>();
// List<Integer> post = new ArrayList<>();
// Solution1.preorder(root, pre);
// Solution1.inorder(root, in);
// Solution1.postorder(root, post);

// }
// }
