#include "0088.h"
using namespace std;
void Solution0088 ::merge(vector<int> &nums1, int m, vector<int> &nums2, int n) {
    int i = 0,j = 0;
    vector<int> tempVector;
    while(i < m && j < n) {
        if(nums1[i] <= nums2[j]) {
            tempVector.push_back(nums1[i]);
            i++;
        } else if(nums1[i] > nums2[j]) {
            tempVector.push_back(nums2[j]);
            j++;
        }
    }
    if(i < m) {
        while(i < m) {
            tempVector.push_back(nums1[i]);
            i++;
        }
    }
    if(j < n) {
        while(j < n) {
            tempVector.push_back(nums2[j]);
            j++;
        }
    }
    nums1.clear();
    for(int i = 0;i < tempVector.size();i++) {
        nums1.push_back(tempVector[i]);
    }
}