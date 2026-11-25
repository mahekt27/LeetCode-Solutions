class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {

            return result;

        }

        String[] letters = {

            "", "", "abc", "def", "ghi", "jkl",

            "mno", "pqrs", "tuv", "wxyz"

        };

        result.add("");

        for (int i = 0; i < digits.length(); i++) {

            String word = letters[digits.charAt(i) - '0'];

            List<String> list = new ArrayList<>();

            for (String s : result) {

                for (int j = 0; j < word.length(); j++) {

                    list.add(s + word.charAt(j));

                }

            }

            result = list;

        }

        return result;

    }

}