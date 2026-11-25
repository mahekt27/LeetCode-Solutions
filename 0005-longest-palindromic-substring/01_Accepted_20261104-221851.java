
class Solution {
    public String longestPalindrome(String s) {

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {

            int left = i;
            int right = i;

            // Odd length palindrome
            while (left >= 0 && right < s.length() &&
                   s.charAt(left) == s.charAt(right)) {

                left--;
                right++;
            }

            if (right - left - 1 > end - start) {
                start = left + 1;
                end = right - 1;
            }

            left = i;
            right = i + 1;

            // Even length palindrome
            while (left >= 0 && right < s.length() &&
                   s.charAt(left) == s.charAt(right)) {

                left--;
                right++;
            }

            if (right - left - 1 > end - start) {
                start = left + 1;
                end = right - 1;
            }
        }

        return s.substring(start, end + 1);
    }
}
