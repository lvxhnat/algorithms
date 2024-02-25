from typing import List


class Solution:
    def equalPairs(self, grid: List[List[int]]) -> int:
        d = {}
        duplicates = 0
        # Since grid is always n x n, we will only really need to parse it once
        for i in range(len(grid)):
            s = f"{grid[i][0]}"
            for j in range(1, len(grid)):
                s += f"_{grid[i][j]}"
            if s in d:
                d[s] += 1
            else:
                d[s] = 1

        for j in range(len(grid)):
            s = f"{grid[0][j]}"
            for i in range(1, len(grid)):
                s += f"_{grid[i][j]}"
            if s in d:
                duplicates += d[s]
        return duplicates


if __name__ == "__main__":
    grid = [[3, 1, 2, 2], [1, 4, 4, 5], [2, 4, 2, 2], [2, 4, 2, 2]]
    print(Solution().equalPairs(grid))
