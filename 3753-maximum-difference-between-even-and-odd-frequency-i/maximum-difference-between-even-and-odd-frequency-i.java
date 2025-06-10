class Solution {
    public int maxDifference(String s) {
        int[] finalFreqCounts = new int[26]; 
        int len = s.length();
        for (int i = 0; i < len; i++) {
            finalFreqCounts[s.charAt(i) - 'a']++;
        }
        int maxOddFreq = Integer.MIN_VALUE;
        int minEvenFreq = Integer.MAX_VALUE;

        for (int count : finalFreqCounts) {
            if (count == 0) {
                continue;
            }

            if (count % 2 == 0) { 
                if (count < minEvenFreq) {
                    minEvenFreq = count;
                }
            } else { 
                if (count > maxOddFreq) {
                    maxOddFreq = count;
                }
            }
        }


        return maxOddFreq - minEvenFreq;
    }
}