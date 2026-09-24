import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(candidates, target, 0, new ArrayList<>(), ans);

        return ans;
    }

    public void backtrack(int[] arr, int target, int start,
                          List<Integer> temp, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < arr.length; i++) {

            // Duplicate skip
            if (i > start && arr[i] == arr[i - 1]) {
                continue;
            }

            // Number target se bada hai
            if (arr[i] > target) {
                break;
            }

            temp.add(arr[i]);

            // i + 1 because same element dobara use nahi karna
            backtrack(arr, target - arr[i], i + 1, temp, ans);

            temp.remove(temp.size() - 1);
        }
    }
}