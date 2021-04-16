#include<vector>
#include<map>
using namespace std;

class Solution0169 {
public:
    int majorityElement(vector<int>& nums) {
        map<int, int> m;
        for (int i = 0; i < nums.size(); i++) {
            if (m.count(nums[i]) != 0) {
                m[nums[i]]++;
            } else {
                m[nums[i]] = 1;
            }
        }
        int result, max = 0;
        map<int, int>:: iterator iterator;
        for (iterator = m.begin(); iterator != m.end(); iterator++) {
            if (iterator->second > max) {
                max = iterator->second;
                result = iterator->first;
            }
        }
        return result;
    }
};