
class Solution {
    public int myAtoi(String s) {

        int i = 0;
        int sign = 1;
        int num = 0;

        // Skip spaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // Check positive or negative sign
        if (i < s.length() && s.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        else if (i < s.length() && s.charAt(i) == '+') {
            i++;
        }

        // Convert string into number
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {

            int d = s.charAt(i) - '0';

            // Check overflow
            if (num > Integer.MAX_VALUE / 10 ||
                (num == Integer.MAX_VALUE / 10 && d > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            num = num * 10 + d;
            i++;
        }

        return num * sign;
    }
}
