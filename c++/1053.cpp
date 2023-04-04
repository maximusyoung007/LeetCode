#include<vector>
using namespace std;

/**
 * 3 1 1 3 => 1 3 1 3
 * 3 1 2 3 => 2 1 3 3
 * 4 1 2 3 => 3 1 2 4
 * 
*/
/**
 * 从后往前遍历，找到首次出现的arr[i]>arr[i+1]
 * 从i+1向后遍历，找小于arr[i]最大的
*/
vector<int> prevPermOpt1(vector<int>& arr) {
    int index = 0, indexI = 0;
    for (int i = arr.size() - 2; i >= 0; i--) {
        if (arr[i] > arr[i+1]) {
            index = i;
            indexI = i + 1;
            break;
        }
    }
    for (int i = indexI + 1; i < arr.size(); i++) {
        if (arr[i] > arr[indexI] && arr[i] < arr[index]) {
            indexI = i;
        }
    }
    int t = arr[index];
    arr[index] = arr[indexI];
    arr[indexI] = t;
    return arr;
}