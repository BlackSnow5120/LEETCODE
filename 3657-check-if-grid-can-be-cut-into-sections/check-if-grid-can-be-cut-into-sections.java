import java.util.*;

class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        Arrays.sort(rectangles, (a, b) -> Integer.compare(a[1], b[1]));
        int cuts = 0;
        int prevEnd = -1;
        for (int[] rect : rectangles) {
            if (rect[1] >= prevEnd) {
                cuts++;
                prevEnd = rect[3]; 
            } else {
                prevEnd = Math.max(prevEnd, rect[3]);
            }
        }
        if (cuts >= 3) return true;
        Arrays.sort(rectangles, (a, b) -> Integer.compare(a[0], b[0]));

        cuts = 0;
        prevEnd = -1;
        for (int[] rect : rectangles) {
            if (rect[0] >= prevEnd) { 
                cuts++;
                prevEnd = rect[2];
            } else {
                prevEnd = Math.max(prevEnd, rect[2]);
            }
        }
        return cuts >= 3;
    }
}
