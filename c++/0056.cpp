#include "0056.h"

vector<vector<int>> Solution0056::merge(vector<vector<int>> &intervals) {
    if(intervals.size() == 1) {
        return intervals;
    }
    sort(intervals.begin(),intervals.end());
    vector<vector<int>> result;
    vector<int> nums1 = intervals[0];
    for(int i = 1;i < intervals.size();i++) {
        vector<int> nums2 = intervals[i];
        vector<vector<int>> partResult = mergeTwo(nums1,nums2);
        nums1 = partResult[partResult.size() - 1];
        if(partResult.size() == 1 && result.size() > 0) {
            result.pop_back();
        }
        result.insert(result.end(), partResult.begin(), partResult.end());
    }
    sort(result.begin(), result.end());
    result.erase(unique(result.begin(), result.end()), result.end());
    return result;
}

vector<vector<int>> Solution0056:: mergeTwo(vector<int> &nums1,vector<int> nums2){
    vector<vector<int>> result;
    vector<int> partResult;
    int left1 = nums1[0],right1 = nums1[nums1.size() - 1],left2= nums2[0],right2 = nums2[nums2.size() - 1];

    if(left2 >= left1 && left2 <= right1) {
        partResult.push_back(left1);
        if(right2 <= right1) {
            partResult.push_back(right1);
        } else {
            partResult.push_back(right2);
        }
        result.push_back(partResult);
    }
    else if(left1 >= left2 && left1 <= right2) {
        partResult.push_back(left2);
        if(right1 <= right2) {
            partResult.push_back(right2);
        } else {
            partResult.push_back(right1);
        }
        result.push_back(partResult);
    }

    if(left1 > right2 || left2 > right1) {
        result.push_back(nums1);
        result.push_back(nums2);
    }

    return result;
}
