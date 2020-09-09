package leetcode.binarySearch;

public class FindKthNum {
    public int findKthNumber(int m, int n, int k) {

        int left = 1;
        int right = m * n;

        while(left < right) {
            int mid = left + (right - left) / 2;
            if(! check(mid, m, n, k)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private boolean check(int t, int m ,int n, int k) {
        int cnt = 0;

        for(int i = 1; i <= m; ++ i) {
            cnt += Math.min(t / i, n);
        }
        //此时不是第k个
        return cnt >= k;
    }

    public static void main(String[] args) {
        System.out.println(new FindKthNum().findKthNumber(3, 3, 5));
    }
}