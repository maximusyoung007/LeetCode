#include"0011.h"
#include<vector>
using namespace std;

int Solution0011::maxArea(vector<int> &height) {
    int left = 0,right = height.size() - 1;
    int max = 0;
    while(left < right) {
        int high = height[right] > height[left] ? height[left] : height[right];
        int width = right - left;
        if(high * width > max) {
            max = high * width;
        }
        if(height[left] <= height[right]) {
            left++;
        } else {
            right--;
        }
    }
    return max;
}