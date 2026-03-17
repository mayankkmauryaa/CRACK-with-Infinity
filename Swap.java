public class Swap {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        System.out.println("Before swap: a = " + a + ", b = " + b);
        swap1(a,b);
        swap2(a,b);
        swap3(a,b);
        swap4(a,b);
        swap5(a,b);
    }

    private static void swap1(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("swap1: a = " + a + ", b = " + b);
    }
    private static void swap2(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("swap2: a = " + a + ", b = " + b);
    }
    private static void swap3(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("swap3: a = " + a + ", b = " + b);
    }
    private static void swap4(int a, int b) {
        a = (a * b) / (b = a);
        System.out.println("swap4: a = " + a + ", b = " + b);
    }
    private static void swap5(int a, int b) {
        a = (a + b) - (b = a);
        System.out.println("swap5: a = " + a + ", b = " + b);
    }

}