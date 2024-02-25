from typing import List 

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        l, r = 0, len(matrix) - 1

        while l < r:
            
            m = (l + r)//2
            
            f_e = matrix[m][0]
            l_e = matrix[m][len(matrix[m]) - 1]
            
            if (f_e <= target <= l_e):
                break

            if f_e < target:
                l = m
            elif f_e > target: 
                r = m

        e_l, e_r = 0, len(matrix[m]) - 1
        
        while e_l <= e_r:

            e_m = (e_l + e_r)//2

            if matrix[m][e_m] < target: 
                e_l = e_m + 1
            elif matrix[m][e_m] > target: 
                e_r = e_m
            else: 
                return True
            
        return False


if __name__ == "__main__":
    s = Solution() 
    matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
    matrix2 = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
    target = 3
    target2 = 13
    print(s.searchMatrix(matrix, target))
    print("----")
    print(s.searchMatrix(matrix2, target2))
