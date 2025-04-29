class Solution {
    public int reverse(int x) {
        Integer num = Math.abs(x);
        String rev = new StringBuilder(num.toString()).reverse().toString();
        if(x<0) rev = "-"+rev;
        try {
            return Integer.parseInt(rev);
        } catch (Exception e) {
            return 0;
        }
    }
}