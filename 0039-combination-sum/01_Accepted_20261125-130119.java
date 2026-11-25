import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        findCombination(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    public void findCombination(int[] candidates, int target, int index,
                                List<Integer> list, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (index == candidates.length || target < 0) {
            return;
        }

        // Choose the current number
        list.add(candidates[index]);

        findCombination(candidates, target - candidates[index], index, list, result);

        // Remove the number
        list.remove(list.size() - 1);

        // Skip the current number
        findCombination(candidates, target, index + 1, list, result);
    }
}
