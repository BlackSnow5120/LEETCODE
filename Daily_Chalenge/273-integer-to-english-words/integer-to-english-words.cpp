class Solution {
public:
    string numberToWords(int num) {
        string ones[10] = {"",      "One ", "Two ",   "Three ", "Four ",
                           "Five ", "Six ", "Seven ", "Eight ", "Nine "};
        string tens1[10] = {"Ten ",      "Eleven ",  "Twelve ",  "Thirteen ",
                            "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ",
                            "Eighteen ", "Nineteen "};
        string tens[10] = {"",        "",       "Twenty ", "Thirty ",
                           "Forty ",  "Fifty ", "Sixty ",  "Seventy ",
                           "Eighty ", "Ninety "};
        int pos = 1, tpos;
        int tnum, digit;
        if (num == 0) {
            return "Zero";
        }
        string ans;
        while (num) {
            tpos = pos % 3;
            if (tpos == 1) {
                tnum = num % 1000;
            }
            digit = tnum % 10;
            if (pos == 4 && tnum != 0) {
                ans = "Thousand " + ans;
            }
            if (pos == 7 && tnum != 0) {
                ans = "Million " + ans;
            }
            if (pos == 10 && tnum != 0) {
                ans = "Billion " + ans;
            }
            if (tpos == 0 && tnum != 0) {
                ans = ones[digit] + "Hundred " + ans;
            }
            if (tpos == 1 && ((tnum / 10) % 10) != 1) {

                ans = ones[digit] + ans;
            } else if (tpos == 1) {
                ans = tens1[digit] + ans;
            }

            if (tnum != 0 && tpos == 2 && digit != 1) {

                ans = tens[digit] + ans;
            }

            tnum /= 10;
            pos++;
            if (tpos == 0 && tnum == 0) {
                num /= 1000;
            }
        }
        return ans.substr(0, ans.size() - 1);
    }
};