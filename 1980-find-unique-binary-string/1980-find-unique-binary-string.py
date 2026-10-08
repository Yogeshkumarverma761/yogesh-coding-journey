class Solution(object):
    def findDifferentBinaryString(self, nums):

        def back(s, nums, l):
            if len(s) == l:
                if s not in nums:
                    return s
                return ""

            # Try 1
            result = back(s + "1", nums, l)
            if result != "":
                return result

            # Try 0
            result = back(s + "0", nums, l)
            if result != "":
                return result

            return ""

        l = len(nums[0])

        return back("", nums, l)