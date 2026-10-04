import java.util.*;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        // Sort by end time
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);

        // dp[i] = max profit using the first i jobs (sorted by end time)
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int s = jobs[i][0], p = jobs[i][2];
            // count of jobs among [0, i) with end <= s
            int k = upperBound(jobs, s, i);
            dp[i + 1] = Math.max(dp[i], dp[k] + p);
        }
        return dp[n];
    }

    // First index in [0, hi) whose end time > target (equals the count of jobs with end <= target)
    private int upperBound(int[][] jobs, int target, int hi) {
        int lo = 0;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (jobs[mid][1] <= target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}