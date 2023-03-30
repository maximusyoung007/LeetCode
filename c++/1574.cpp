#include<vector>
using namespace std;

/**
 * 开区间（left, right）
 * 先找右边的非递减序列，确定right的位置
 * 这时可以删除right左边所有的值
 * 从left=0开始比较
 * 如果left大于前一个，则left可以向后枚举,否则就断了，left右边的都可以删
 * 如果arr[left] > arr[right], 那么right右移，直到right==n
 * 每次枚举left和right的时候，长度为right-left-1
*/
int findLengthOfShortestSubarray(vector<int>& arr) {
    int left = 0, right;
    int i;
    for (i = arr.size() - 1; i >= 1; i--) {
        if (arr[i - 1] > arr[i]) {
            right = i;
            break;
        }
    }
    if (i == 0) {
        return 0;
    }

    int res = right;
    while (left == 0 || arr[left-1] <= arr[left]) {
        while (left < right && right < arr.size()) {
            if (arr[left] > arr[right]) {
                right++;
            } else {
                break;
            }
        }
        res = min(res, right - left - 1);
        left++;
    }
    return res;
}