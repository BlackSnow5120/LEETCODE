class Solution {
public:
    void func(int n, int temp, vector<int> vec, string s,
              vector<string>& vec1) {
        if (temp < 0) {
            return;
        }
        if (s.size() == (n * 2)) {
            if (temp == 0) {
                vec1.push_back(s);
            }
            return;
        }
        for (int i = 0; i < 2; i++) {
            string s1 = "";
            if (vec[i] == 1) {
                s1 = "(";
            } else {
                s1 = ")";
            }
            func(n, temp + vec[i], vec, s + s1, vec1);
        }
    }

    vector<string> generateParenthesis(int n) {
        vector<int> vec;
        vec.push_back(1);
        vec.push_back(-1);
        vector<string> vec1;
        func(n, 0, vec, "", vec1);
        return vec1;
    }
};