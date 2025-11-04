#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int xsum(unordered_map<int,int> freq, int x) {
        vector<pair<int,int>> numsfreq;
        for (auto p : freq) {
            if (p.second > 0)  // ignore zero counts
                numsfreq.push_back({p.first, p.second});
        }

        sort(numsfreq.begin(), numsfreq.end(), [](pair<int,int> a, pair<int,int> b) {
            if (a.second != b.second) return a.second > b.second; // higher freq first
            return a.first > b.first; // if tie, larger number first
        });

        int ans = 0;
        for (int i = 0; i < min(x, (int)numsfreq.size()); i++) {
            ans += numsfreq[i].first * numsfreq[i].second;
        }
        return ans;
    }

    vector<int> findXSum(vector<int>& nums, int k, int x) {
        vector<int> ans;
        unordered_map<int,int> freq;

        // initialize first window
        for (int i = 0; i < k; i++) {
            freq[nums[i]]++;
        }
        ans.push_back(xsum(freq, x));

        // slide window
        for (int i = k; i < nums.size(); i++) {
            freq[nums[i]]++;
            freq[nums[i - k]]--;
            ans.push_back(xsum(freq, x));
        }

        return ans;
    }
};
