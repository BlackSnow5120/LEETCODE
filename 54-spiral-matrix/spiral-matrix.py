from typing import List

class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        if not matrix or not matrix[0]:
            return []
        
        m = len(matrix)
        n = len(matrix[0])
        total = m * n
        count = 0

        top, bottom = 0, m - 1
        left, right = 0, n - 1

        ans = []

        while count < total:
            for i in range(left, right + 1):
                if count < total:
                    ans.append(matrix[top][i])
                    count += 1
            top += 1

            for i in range(top, bottom + 1):
                if count < total:
                    ans.append(matrix[i][right])
                    count += 1
            right -= 1

            for i in range(right, left - 1, -1):
                if count < total:
                    ans.append(matrix[bottom][i])
                    count += 1
            bottom -= 1

            for i in range(bottom, top - 1, -1):
                if count < total:
                    ans.append(matrix[i][left])
                    count += 1
            left += 1

        return ans
