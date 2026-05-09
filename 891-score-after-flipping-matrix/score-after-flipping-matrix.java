class Solution {
    public int matrixScore(int[][] arr) {

        int m = arr.length;
        int n = arr[0].length;

        // Step 1 : Make first column all 1
        for (int i = 0; i < m; i++) {

            if (arr[i][0] == 0) {

                for (int j = 0; j < n; j++) {

                    if (arr[i][j] == 0)
                        arr[i][j] = 1;
                    else
                        arr[i][j] = 0;
                }
            }
        }

        // Step 2 : Flip columns if zeros are more
        for (int j = 0; j < n; j++) {

            int noOfzeros = 0;
            int noOfones = 0;

            for (int i = 0; i < m; i++) {

                if (arr[i][j] == 0)
                    noOfzeros++;
                else
                    noOfones++;
            }

            // Flip the column
            if (noOfzeros > noOfones) {

                for (int i = 0; i < m; i++) {

                    if (arr[i][j] == 0)
                        arr[i][j] = 1;
                    else
                        arr[i][j] = 0;
                }
            }
        }

        // Step 3 : Calculate final score
        int ans = 0;

        for (int i = 0; i < m; i++) {

            int value = 0;

            for (int j = 0; j < n; j++) {

                value = value * 2 + arr[i][j];
            }

            ans += value;
        }

        return ans;
    }
}