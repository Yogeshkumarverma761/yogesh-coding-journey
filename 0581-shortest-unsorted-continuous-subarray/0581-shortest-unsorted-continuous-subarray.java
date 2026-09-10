class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[]arr=nums.clone();
        Arrays.sort(arr);
        int i=0;
        int j=nums.length-1;
        int ans=0;
        while(i<j){
            if(arr[i]==nums[i]&&arr[j]==nums[j]){
                i++;
                j--;
            }
            else if(arr[i]==nums[i]&&arr[j]!=nums[j]){
                i++;
                
            }
            else if(arr[i]!=nums[i]&&arr[j]==nums[j]){
                j--;
            }
            else {
                
                ans=(j-i+1);
                break;
            }
        }
        return ans;
    }
}