class Solution {
    public int lengthOfLastWord(String s) {
        String str = s.trim();
        if(str.length()==0) return 0;
        String[] strarr = str.split(" ");
        str = strarr[strarr.length-1];
        return str.length();
    }
}