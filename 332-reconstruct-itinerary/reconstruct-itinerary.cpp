class Solution {
public:
    vector<string> findItinerary(vector<vector<string>>& tickets) {
        unordered_map<string, priority_queue<string, vector<string>, greater<string>>> graph;

        for (auto& ticket : tickets) {
            graph[ticket[0]].push(ticket[1]);
        }

        vector<string> itinerary;

        function<void(const string&)> dfs = [&](const string& airport) {
            while (!graph[airport].empty()) {
                string next = graph[airport].top();
                graph[airport].pop();
                dfs(next);
            }
            itinerary.push_back(airport);
        };

        dfs("JFK");
        reverse(itinerary.begin(), itinerary.end());

        return itinerary;
    }
};
