
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        if (words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int totalLength = wordLength * words.length;

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {

            int start = i;
            Map<String, Integer> count = new HashMap<>();

            for (int j = i; j + wordLength <= s.length(); j += wordLength) {

                String word = s.substring(j, j + wordLength);

                if (map.containsKey(word)) {
                    count.put(word, count.getOrDefault(word, 0) + 1);

                    while (count.get(word) > map.get(word)) {
                        String left = s.substring(start, start + wordLength);
                        count.put(left, count.get(left) - 1);
                        start += wordLength;
                    }

                    if (j + wordLength - start == totalLength) {
                        result.add(start);
                    }

                } else {
                    count.clear();
                    start = j + wordLength;
                }
            }
        }

        return result;
    }
}
