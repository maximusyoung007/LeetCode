#include<vector>
using namespace std;

/*
    因为奇数+偶数一定不等于2*任意数，所以可以把数组分为奇数漂亮数组和偶数漂亮数组
    以n=7为例
    可以分为1，3，5，7， 2，4，6，其中，5+2 != 2*7
    因此针对一个数组，可以从最小的漂亮数组开始扩充，先扩充偶数的，再扩充奇数的
    例如：
    1
    1，2
    1，3，2，4 
    1，5，3，7，（先扩充奇数的漂亮数组） 2，6，4，(8) （再扩充偶数的漂亮数组），
    左边是奇数，右边是偶数，合起来也是漂亮数组
*/
vector<int> beautifulArray(int n) {
    vector<int> res = {1};
    while (res.size() < n) {
        vector<int> t;
        int tSize = res.size();
        for (int i = 0; i < tSize; i++) {
            if (2 * res[i] - 1 <= n) {
                t.push_back(2 * res[i] - 1);
            }
        }
        for (int i = 0; i < tSize; i++) {
            if (2 * res[i] <= n) {
                t.push_back(2 * res[i]);
            }
        }
        res = t;
    }
    return res;
}