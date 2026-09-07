import java.util.HashSet;
import java.util.Set;

class Solution {

    public int maxVowels(String s, int k) {

        Set<Character> vowels = new HashSet<>();

        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int count = 0;
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                count++;
            }
        }

        int maxCount = count;

        // Sliding window
        for (int right = k; right < s.length(); right++) {

            int left = right - k;

            // Add new character
            if (vowels.contains(s.charAt(right))) {
                count++;
            }

            // Remove old character
            if (vowels.contains(s.charAt(left))) {
                count--;
            }

            maxCount = Math.max(maxCount, count);

            // Cannot get better than k
            if (maxCount == k) {
                return k;
            }
        }

        return maxCount;
    }
}