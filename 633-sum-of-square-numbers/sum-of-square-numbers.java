class Solution {
    public boolean judgeSquareSum(int c) {
        long a = 0;
        long b = (long) Math.sqrt(c);

        while (a <= b) {
            long sum = a * a + b * b;

            if (sum == c) return true;       // ✅ mil gaya
            else if (sum < c) a++;           // sum chhota hai, a badhao
            else b--;                        // sum bada hai, b ghataao
        }

        return false;
    }
}