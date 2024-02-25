class Solution {
    public int reverse(int x) {
        int newDigit = 0;
        int sign = x > 0 ? 1 : -1;
        int remainder = Math.abs(x);
        while (remainder != 0) {   
            if (Integer.MAX_VALUE / 10 < newDigit || (Integer.MAX_VALUE - newDigit % 10) < newDigit * 10) {
                return 0;
            }
            newDigit *= 10;
            newDigit += remainder % 10;
            remainder /= 10;
        }
        return newDigit * sign ;
    }
}

