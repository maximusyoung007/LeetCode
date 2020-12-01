#include "0026.h"
using namespace std;

int Solution0026 :: removeDuplicates(vector<int> &nums) {
    if(nums.size() == 0) return 0;
    int i = 0,j;
    for(j = 1;j < nums.size();j++) {
        if(nums[i] != nums[j]) {
            i++;
            nums[i] = nums[j];
        }
    }
    return i + 1;
}