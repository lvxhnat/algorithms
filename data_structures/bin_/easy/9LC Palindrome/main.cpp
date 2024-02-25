#include <iostream>
#include <string>
using namespace std;

class Solution
{
public:
    bool isPalindrome(int x)
    {
        string x_string = to_string(x);
        int x_string_length = x_string.length();
        bool result = true;

        for (int i = 0; i < x_string_length / 2 + (x_string_length % 2 != 0); i++)
        {
            if (x_string[i] != x_string[x_string_length - (i + 1)])
            {
                result = false;
            }
        }

        return result;
    }

    bool optimalIsPalindrome(int x)
    {
        if (x < 0 || (x != 0 && x % 10 == 0)) // Edge Cases - If negative, not equal to 0 yet can be divided by 10 - obvious cases
            return false;
        int sum = 0;
        while (x > sum)
        {
            sum = sum * 10 + x % 10; // For example, given 12321, (1) 0 + 1 (2) 10 + 2 (3) 120 + 3
            x = x / 10;              // (1) 1232 (2) 123 (3) 12
        }
        return (x == sum) || (x == sum / 10); // 12 == 123 (false) || 12 == 12 (true)
    }
};

int main()
{
    Solution solution = Solution();
    cout << solution.isPalindrome(111111);
}
