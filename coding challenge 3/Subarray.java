import java.util.*;

public class Subarray {
    
    public static int Subarrays(int[] arr, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int maxOfMins = Integer.MIN_VALUE;


        for (int i = 0; i < arr.length; i++) {
            while (!deque.isEmpty() && arr[deque.peekLast()] >= arr[i]) {
                deque.pollLast();
            }

            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                maxOfMins = Math.max(maxOfMins, arr[deque.peekFirst()]);
            }
        }

        return maxOfMins;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int k = sc.nextInt();
        
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(Subarrays(arr, k));
        
        sc.close();
    }
}
