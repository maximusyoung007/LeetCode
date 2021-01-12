#include<vector>
using namespace std;

class Solution0004 {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int len1 = nums1.size(),len2 = nums2.size();
        if((len1 + len2) % 2 != 0) {
            int k = (len1 + len2) / 2;
            return findMinK(nums1,nums2,k + 1);
        } else if((len1 + len2) % 2 == 0) {
            int k = (len1 + len2) / 2;
            return (findMinK(nums1,nums2,k + 1) + findMinK(nums1,nums2,k)) / 2;
        }
        return 0;
    }

    double findMinK(vector<int>& nums1,vector<int>& nums2,int k) {
        int index1 = 0,index2 = 0;
        int len1 = nums1.size(),len2 = nums2.size();
        while(true) {
            if(index1 == len1) {
                return nums2[index2 + k - 1];
            }
            if(index2 == len2) {
                return nums1[index1 + k - 1];
            }
            if(k == 1) {
                return nums1[index1] > nums2[index2] ? nums2[index2] : nums1[index1];
            }

            int half = k / 2;
            int newIndex1 = ((index1 + half) > len1 ? len1 : index1 + half) - 1;
            int newIndex2 = ((index2 + half) > len2 ? len2 : index2 + half) - 1;

            if(nums1[newIndex1] <= nums2[newIndex2]) {
                k -= newIndex1 - index1 + 1;
                index1 = newIndex1 + 1;
            }
            if(nums2[newIndex2] < nums1[newIndex1]) {
                k -= newIndex2 - index2 + 1;
                index2 = newIndex2 + 1;
            }
        }
    }
};