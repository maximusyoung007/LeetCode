#include<vector>
#include<algorithm>
using namespace std;

vector<int> answerQueries(vector<int>& nums, vector<int>& queries) {
    vector<int> res;
    sort(nums.begin(), nums.end());
    for (int i = 0; i < queries.size(); i++) {
        int j = 0, sum = 0; 
        while (j < nums.size()) {
            if (sum + nums[j] <= queries[i]) {
                sum += nums[j];
                j++;
            } else {
                break;
            }
        }
        res.push_back(j);
    }    
    return res;    
}