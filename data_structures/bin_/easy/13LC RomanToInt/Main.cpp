#include <unordered_map>
#include <string>

class Solution
{
public:
    int romanToInt(std::string s)
    {
        std::unordered_map<std::string, int> mapping = {
            {"I", 1},
            {"V", 5},
            {"X", 10},
            {"L", 50},
            {"C", 100},
            {"D", 500},
            {"M", 1000}};
        s = replace(s, "IV", "IIII");
        s = replace(s, "IX", "VIIII");
        s = replace(s, "XL", "XXXX");
        s = replace(s, "XC", "LXXXX");
        s = replace(s, "CD", "CCCC");
        s = replace(s, "CM", "DCCCC");

        int sum = 0;

        for (char c : s)
        {
            sum += mapping[std::string(1, c)];
        }

        return sum;
    }

    std::string replace(std::string s, std::string ss, std::string r)
    {
        try
        {
            s = s.replace(s.find(ss), sizeof(s) - 1, r);
            return s;
        }
        catch (std::string exception)
        {
            return s;
        }
    }
};