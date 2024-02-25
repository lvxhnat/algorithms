#include <iostream>
#include <vector>
#include <numeric>

using namespace std;

class Solution
{
public:
    vector<int> runningSum(vector<int> &nums)
    {
        vector<int> runningSum;
        int lastValue = 0;
        for (int i : nums)
        {
            runningSum.push_back(lastValue + i);
            lastValue += i;
        }
        return runningSum;
    }

    vector<int> secondTryRunningSum(vector<int> &nums)
    {
        for (int i = 1; i < nums.size(); ++i)
        {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    vector<int> optimizedRunningSum(vector<int> &nums)
    {
        int n = nums.size();
        for (int i = 0; i < n; i++)
        {
            if (i + 1 < n) // This is the speed up
            {
                nums[i + 1] += nums[i];
            }
        }
        return nums;
    }
};

int main()
{
    Solution solution = Solution();
    vector<int> vect(3, 10);
    vector<int> answer = solution.runningSum(vect);
    for (int i : answer)
    {
        cout << i;
    }
}