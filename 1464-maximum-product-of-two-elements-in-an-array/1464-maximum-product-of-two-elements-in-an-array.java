class Solution {
    public int maxProduct(int[] nums) {
        // Arrays.sort(nums);
        // return (nums[nums.length-2]-1)*(nums[nums.length-1]-1);
        int n = 0, m = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        if (map.get(map.firstKey()) >= 2) {
            return (map.firstKey() - 1) * (map.firstKey() - 1);
        } else {

            n = map.firstKey() - 1;
            map.remove(map.firstKey());
            m = map.firstKey() - 1;
            return n * m;

        }

    }
}
