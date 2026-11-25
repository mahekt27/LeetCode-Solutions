
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        solve("", 0, 0, n, ans);

        return ans;
    }

    public void solve(String s, int a, int b, int n, List<String> ans) {

        if (s.length() == 2 * n) {
            ans.add(s);
            return;
        }

        if (a < n) {
            solve(s + "(", a + 1, b, n, ans);
        }

        if (b < a) {
            solve(s + ")", a, b + 1, n, ans);
        }
    }
}
