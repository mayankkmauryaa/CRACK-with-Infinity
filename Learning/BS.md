# binary search on `answer` functions

- applying B.S on array is same as function `monotoic` -> `increasing` & `decreasing`

  `y=f(x) = x^2+5x`

x = [1,2,3,4,5,6,7,8,9]

---

## CF-lvl - 3 : Q

sorted array -> n elements -> `l <= a[i] <= r`

a = [1,2,3, 5,6,7,8,10,11, 16,20]

in -> l=4 r=12

out -> 6

```java
public class Main {

    static int lowerBound(int[] a, int target) {
        int low = 0, high = a.length - 1, ans = a.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    static int upperBound(int[] a, int target) {
        int low = 0, high = a.length - 1, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] <= target) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3, 5,6,7,8,10,11, 16,20};
        int l = 4, r = 12;

        int left = lowerBound(a, l);
        int right = upperBound(a, r);

        int count = (left <= right) ? (right - left + 1) : 0;
        System.out.println(count);
    }
}

```

---

## Q Fair Workload

array of workloads; k workers;
max work that any worker has to do is minimised (workloads are in order)

edge case :
k=1; sum
k>n; false
k==n; max

min workload
max workload
all ele are equal

```java
public class Main{
    int maxi_work_mini(int [] arr, int k){
        int n = arr.length;
        if(k>n) return -1;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int val: arr){
            max = Math.max(max, val);
            sum+= val;
        }

        if(k==1) return sum;
        if(k==n) return max;


        int low = max;
        int high = sum;
        int ans = 0;


        while(low<=high){
            int mid = low+(high-low)/2;
            boolean check = distribution(arr, k, mid );
            if(check){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    boolean distribution(int [] arr, int k, int mid ){
        int worker = 1;
        int work = 0;
        for(int val : arr){
            work+=val;
            if(work>mid){
                work = val;
                worker++;
            }
        if(k<worker) return false;

        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        int k = 2;

        int ans = maxi_work_mini(arr,k);
        System.out.println(ans);
    }
}
```

---

## Q Fair Workload with a Twist

array of workloads; k workers;
max work that any worker has to do is minimised (workloads are in order can be changed)

```java
        public class Main{


            public static void main(String[] args) {

            }
        }
```
