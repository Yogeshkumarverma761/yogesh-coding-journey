class Solution(object):
    def sumOfSquares(self, nums):
        sum =0
        
        for i  in range(0 , len(nums)):
            if len(nums) % (i+1) == 0:
                sum += nums[i] * nums[i]

        return sum