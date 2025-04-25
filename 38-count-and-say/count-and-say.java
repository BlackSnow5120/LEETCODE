class Solution {
    public String func1(String s) {
        int len = s.length();
        int i = 0;
        StringBuilder ans = new StringBuilder();
        Integer count = 0;
        char temp = s.charAt(0);
        while (i < len) {
            if (s.charAt(i) != temp) {
                ans.append(count);
                ans.append(temp);
                temp = s.charAt(i);
                count = 0;
            }
            count++;
            i++;
        }
        ans.append(count);
        ans.append(temp);
        return ans.toString();
    }

    public String countAndSay(int n) {
        String a = "1";

        for (int i = 0; i < n - 1; i++) {
            a = func1(a);
        }
        return a;
    }
}