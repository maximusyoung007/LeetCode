#include<iostream>
#include<vector>
#include<algorithm>
#include<map>
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& numbers,int target) {
        map<int,int> nums_map;
        for(int i = 0; i < numbers.size(); i++) {
            if(nums_map.count(target - numbers[i]) == 1) {
                vector<int> result;
                result.push_back(i+1);
                result.push_back(nums_map[target-numbers[i]]+1);
                sort(result.begin(),result.end());
                return result;
            }
            nums_map.insert(pair<int,int>(numbers[i],i));
        }
        return {};
    }
};