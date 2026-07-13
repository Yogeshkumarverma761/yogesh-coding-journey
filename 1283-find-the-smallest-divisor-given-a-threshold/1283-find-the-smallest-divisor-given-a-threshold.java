class Solution {
    // helper function gives divisor is lesser or not
    public boolean findDiv(int nums[], int mid, int threshold){
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += Math.ceil((double)nums[i]/mid);
        }
        if(sum > threshold){
            return false;
        }
        return true;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = 0;
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            end = Math.max(nums[i], end);
        }

        while(start <= end){
            int mid = (start + end)/2;

            // discard right if helper function is true
            if(findDiv(nums, mid, threshold)){
                ans = mid;
                end = mid-1;
            }
            // discard left half 
            else{
                start = mid+1;
            }
        }
        return ans;
    }
}