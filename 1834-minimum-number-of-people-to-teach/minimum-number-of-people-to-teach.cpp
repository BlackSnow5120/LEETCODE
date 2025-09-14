class Solution {
public:
    int minimumTeachings(int n, vector<vector<int>>& languages, vector<vector<int>>& friendships) {
        int m = languages.size();
        
        // store languages for each user (1-indexed)
        vector<unordered_set<int>> knows(m + 1);
        for (int i = 0; i < m; i++) {
            for (int lang : languages[i]) {
                knows[i + 1].insert(lang);
            }
        }

        // find users in bad friendships (no common language)
        unordered_set<int> badUsers;
        for (auto& f : friendships) {
            int u = f[0], v = f[1];
            bool common = false;
            for (int lang : knows[u]) {
                if (knows[v].count(lang)) {
                    common = true;
                    break;
                }
            }
            if (!common) {
                badUsers.insert(u);
                badUsers.insert(v);
            }
        }

        if (badUsers.empty()) return 0; // no teaching needed

        // count how many of these bad users already know each language
        vector<int> count(n + 1, 0);
        for (int user : badUsers) {
            for (int lang : knows[user]) {
                count[lang]++;
            }
        }

        // minimize teaching
        int maxKnown = 0;
        for (int lang = 1; lang <= n; lang++) {
            maxKnown = max(maxKnown, count[lang]);
        }

        return (int)badUsers.size() - maxKnown;
    }
};
