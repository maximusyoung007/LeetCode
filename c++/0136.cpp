#include <vector>
#include <iostream>
using namespace std;

class Solution0136 {
public:
    int singleNumber(vector<int>& nums) {
        int result = nums[0];
        for(int i = 1;i < nums.size();i++) {
            result = result ^ nums[i];
        }
        return result;
    }
};