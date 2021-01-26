#include <vector>
using namespace std;

class Solution0057 {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        vector<vector<int>> result;
        int first = 0;
        for(int i = 0; i < intervals.size(); i++) {
            if(intervals[i][1] < newInterval[0]) {
                result.push_back(intervals[i]);
            }
            else if(intervals[i][0] > newInterval[1]) {
                if(first == 0) {
                    first = 1;
                    result.push_back(newInterval);
                }
                result.push_back(intervals[i]);
            }
            else {
                newInterval[0] = intervals[i][0] <= newInterval[0] ? intervals[i][0] : newInterval[0];
                newInterval[1] = intervals[i][1] >= newInterval[1] ? intervals[i][1] : newInterval[1];
            }
        }
        if(first == 0) {
            result.push_back(newInterval);
        }

        return result;
    }
};