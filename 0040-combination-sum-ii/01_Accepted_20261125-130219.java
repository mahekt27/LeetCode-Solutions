import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        findCombination(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    public void findCombination(int[] candidates, int target, int index,
                                List<Integer> list, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            // Skip duplicate numbers
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] > target) {
                break;
            }

            // Add number
            list.add(candidates[i]);

            // Move to next index
            findCombination(candidates, target - candidates[i], i + 1, list, result);

            // Backtracking
            list.remove(list.size() - 1);
        }
    }
}
