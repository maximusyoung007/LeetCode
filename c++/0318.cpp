#include<vector>
#include<string>
#include<iostream>
using namespace std;

/**
 * 把word转化为int,int的每一位表示对应位的字母是否存在
*/
int maxProduct(vector<string>& words) {
    vector<int> nums;
    for (string s : words) {
        int t = 0;
        for (int i = 0; i < s.length(); i++) {
            t = t | (1 << (s[i] - 'a'));
        }
        nums.push_back(t);
    }
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i] << endl;
    }
    int res = 0;
    for (int i = 0; i < nums.size(); i++) {
        for (int j = 0; j < i; j++) {
            //nums[i] & nums[j] 一定要加括号
            if ((nums[i] & nums[j]) == 0) {
                int t = words[i].length() * words[j].length();
                if (t > res) {
                    res = t;
                }
            }
        }
    }
    return res;
}