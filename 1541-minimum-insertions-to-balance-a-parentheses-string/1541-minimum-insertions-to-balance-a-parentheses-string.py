class Solution(object):
    def minInsertions(self, s):
        insertions = 0
        needed = 0

        for ch in s:
            if ch == '(':
                if needed % 2 == 1:
                    insertions += 1
                    needed -= 1

                needed += 2

            else:
                needed -= 1

                if needed < 0:
                    insertions += 1
                    needed = 1

        return insertions + needed