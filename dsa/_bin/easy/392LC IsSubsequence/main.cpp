#include <string>

class Solution
{
public:
    bool isSubsequence(std::string s, std::string t)
    {
        int pos = 0;
        int s_len = s.length();
        if (s == t)
        {
            return true;
        }
        for (int i = 0; i < t.length(); i++)
        {
            if (t[i] == s[pos])
            {
                pos++;
            }
            if (pos == s_len)
            {
                return true;
            }
        }
        return false;
    }
};