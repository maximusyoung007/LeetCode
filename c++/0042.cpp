#include <vector>
using namespace std;

class Solution0042 {
public:
    int trap(vector<int>& height) {
        int maxLeft = 0,maxRight = 0;
        int left = 0,right = height.size() - 1;
        int sum = 0;
        while(left <= right) {
            if(maxLeft < maxRight) {
                if(maxLeft - height[left] > 0) {
                    sum += (maxLeft - height[left]);
                }
                maxLeft = maxLeft > height[left] ? maxLeft : height[left];
                left++;
            } else {
                if(maxRight - height[right] > 0) {
                    sum += (maxRight - height[right]);
                }
                maxRight = maxRight > height[right] ? maxRight : height[right];
                right--;
            }
        }
        return sum;
    }
};