#include <vector>
#include <numeric>

using namespace std;

class Solution
{
public:
    int pivotIndex(vector<int> &nums)
    // Time Complexity = O(n)
    // Space Complexity
    {
        int numSize = nums.size();
        int maxSum = accumulate(nums.begin(), nums.end(), 0);
        int leftSum = 0;

        for (int i = 0; i < numSize; ++i)
        {
            int rightSum;

            if (i == 0)
            {
                rightSum = maxSum - nums[i];
            }
            else
            {
                leftSum += nums[i - 1];
                rightSum = maxSum - nums[i] - leftSum;
            }

            if (leftSum == rightSum)
            {
                return i;
            }
        }
        return -1;
    }
};