package leetcode;

public class Solution {


    public static void main(String[] args) {
        System.out.println(new Solution().is_palindrome(51));
        System.out.println(new Solution().is_palindrome(27));
        System.out.println(new Solution().is_palindrome(3));
        System.out.println(new Solution().is_palindrome(11));
    }

    public int is_palindrome(int num) {
        String binStr = genBinStr(num);
        System.out.println(binStr);
        if (isPalindrome(binStr)) {
            return 1;
        }
        return 0;
    }

    private boolean isPalindrome(String binStr) {

        int n = binStr.length();
        int left, right;
        if (n % 2 == 0) {
            right = n / 2;
            left = right - 1;
        } else {
            left = n / 2;
            right = left;
        }

        while (left >= 0 && right < n) {
            if (binStr.charAt(left) != binStr.charAt(right)){
                return false;
            }
            left --;
            right ++;
        }

        return true;

    }


    private String genBinStr(int num) {
        StringBuilder ret = new StringBuilder();

        while (num != 0) {
            ret.insert(0, num % 2);
            num /= 2;
        }
        return ret.toString();
    }
}
