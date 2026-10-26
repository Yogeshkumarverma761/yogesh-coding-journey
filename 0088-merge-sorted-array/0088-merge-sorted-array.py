
class Solution(object):
    def merge(self, nums1, m, nums2, n):
        l = []
        i = 0
        j = 0

        while i < m and j < n:
            if nums1[i] <= nums2[j]:
                l.append(nums1[i])
                i += 1
            else:
                l.append(nums2[j])
                j += 1

        while i < m:
            l.append(nums1[i])
            i += 1

        while j < n:
            l.append(nums2[j])
            j += 1

        nums1[:] = l
