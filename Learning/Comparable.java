import java.util.Arrays;

class Tuples implements Comparable<Tuples> {

    int a, b;

    public Tuples(int a, int b) {

        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "Tuple [a=" + a + ",b=" + b + "]";
    }

    @Override
    public int compareTo(Tuples o) {
        return Integer.compare(o.a, this.a);

        // if (this.b != o.b) {
        // return this.b - o.b; // sort by b
        // } else {
        // return this.a - o.a; // sort by a if b is same
        // }
    }
}

public class ComprableDemo {

    public static void main(String[] args) {

        Tuples[] arr = new Tuples[4];
        arr[0] = new Tuples(10, 11);
        arr[1] = new Tuples(20, 11);
        arr[2] = new Tuples(100, 5);
        arr[3] = new Tuples(20, 11);
        // System.out.println(arr.toString());

        // Tuples.compareTo(arr) => a[1]!=b[1] ? a[1]-b[1] :a[0] -b[0] ;

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

}
