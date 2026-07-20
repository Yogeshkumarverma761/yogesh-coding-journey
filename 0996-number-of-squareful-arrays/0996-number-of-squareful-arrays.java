import java.util.*;

class Solution {

    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        return backtrack(nums, used, new ArrayList<>());
    }

    private int backtrack(int[] nums, boolean[] used, List<Integer> path) {
        if (path.size() == nums.length) {
            return 1;
        }

        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) continue;

            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            // Check squareful condition
            if (!path.isEmpty()) {
                int sum = path.get(path.size() - 1) + nums[i];
                if (!isPerfectSquare(sum)) {
                    continue;
                }
            }

            used[i] = true;
            path.add(nums[i]);

            count += backtrack(nums, used, path);

            path.remove(path.size() - 1);
            used[i] = false;
        }

        return count;
    }

    private boolean isPerfectSquare(int x) {
        int root = (int) Math.sqrt(x);
        return root * root == x;
    }
}