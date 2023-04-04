#include <iostream>
#include<string>
#include<algorithm>
#include "1630.cpp"
#include"0179.cpp"
#include"0318.cpp"
#include"1053.cpp"
#include"2611.cpp"
#include"0831.cpp"
#include"6364.cpp"
using namespace std;
int main() {
    //1616
    // string a = "abdef", b = "fecab";
    // string a = "ulacfd", b = "jizalu";
    // string a = "pvhmupgqeltozftlmfjjde", b = "yjgpzbezspnnpszebzmhvp";
    // cout << checkPalindromeFormation(a, b) << endl; 

    //  比较字符串
    // string s1 = "123";
    // string s2 = "234";
    // if (s1 < s2) {
    // cout << true << endl;
    // }

    //1625
    // string s = "5525";
    // cout << findLexSmallestString(s, 9, 2);
    // string s = "74";
    // cout << findLexSmallestString(s, 5, 1);
    // cout << findLexSmallestString("0011", 4, 2);
    // cout << findLexSmallestString("43987654", 7, 3);
    // vector<int> scores = {1, 3, 5, 10 ,15};
    // vector<int> ages = {1, 2, 3,4,5};
    // vector<int> scores = {4,5,6,5};
    // vector<int> ages = {2,1,2,1};
    // vector<int> scores = {1, 2, 3, 5};
    // vector<int> ages = {8, 9, 10, 1};
    // vector<int> scores = {1, 3, 7, 3,2,4,10,7,5};
    // vector<int> ages = {4,5,2,1,1,2,4,1,4};
    // cout << "res:" << beatTeamScore(scores, ages) << endl;

    //1630
    // vector<int> nums = {4,6,5,9,3,7};
    // vector<int> l = {0,0,2};
    // vector<int> r = {2,3,5};
    //nums = 
    //[-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10], l = [0,1,6,4,8,7], r = [4,4,9,7,9,10]
    // vector<int> nums = {-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10};
    // vector<int> l = {0,1,6,4,8,7};
    // vector<int> r = {4,4,9,7,9,10};
    // vector<bool> res = checkArithmeticSubarrays(nums, l, r);
    // for (int i = 0; i < res.size(); i++ ) {
    //     cout << res[i] << endl;
    // }
    // cout << kItemsWithMaximumSum(6, 6, 6, 13) << endl;
    // vector<int> nums;
    // nums.push_back(4);
    // nums.push_back(9);
    // nums.push_back(6);
    // nums.push_back(10);
    // cout << primeSubOperation(nums) << endl;
    // vector<int> arr = {1,2};
    // arr.push_back(1);
    // arr.push_back(2);
    // arr.push_back(3);
    // arr.push_back(10);
    // arr.push_back(4);
    // arr.push_back(2);
    // arr.push_back(3);
    // arr.push_back(5);
    // arr.push_back(5);
    // arr.push_back(4);
    // arr.push_back(3);
    // arr.push_back(2);
    // arr.push_back(1);
    // arr.push_back(1);
    // arr.push_back(2);
    // arr.push_back(3);
    // vector<int> arr = {1, 3, 2, 4};
    // vector<int> arr = {1,2,3,10,4,2,3,5};
    // cout << findLengthOfShortestSubarray(arr) << endl;
    // vector<int> nums = {10, 2};
    // vector<int> nums = {3,30 ,34,5,9};
    // vector<int> nums = {0, 0};
    // cout << largestNumber(nums) << endl;
    // vector<string> words = {"abcw","baz","foo","bar","xtfn","abcdef"};
    // cout << maxProduct(words) << endl;
    // vector<int> arr = {3, 1, 1, 3};
    // vector<int> arr = {3, 1, 2, 3};
    // vector<int> arr = {4, 1, 2, 3};
    //  vector<int> arr = {3, 2, 1};
    // vector<int> arr = {1, 1, 5};
    // vector<int> arr = {1, 9, 4, 6, 7};
    // vector<int> res = prevPermOpt1(arr);
    // for (int r : res) {
    //     cout << r << " ";
    // }
    // cout << endl;
    vector<int> r1 = {1,1,3,4};
    vector<int> r2 = {4,4,1,1};
    cout << miceAndCheese(r1, r2, 2) << endl;
    // vector<string> words = {"abcw","baz","foo","bar","xtfn","abcdef"};
    // cout << maxProduct(words) << endl;
    // string s = "122";
    // cout << (s.find('@') == string::npos) << endl;
    // string s = "LeetCode@LeetCode.com";
    // string s = "AB@qq.com";
    // string s = "1(234)567-890";
    // string s = "86-(10)12345678";
    // cout << maskPII(s) << endl;
    // string s = "01000111";
    // string s = "00111";
    // string s = "111";
    // string s = "001";
    // string s = "010101";
    // cout << findTheLongestBalancedSubstring(s) << endl;
    // vector<int> nums = {1,3,4,1,2,3,1};
    // vector<int> nums = {1,2,3,4};
    // vector<vector <int> > res = findMatrix(nums);
    // for (vector<int> t : res) {
    //     for (int i : t) {
    //         cout << i << " ";
    //     }
    //     cout << endl;
    // }
    // vector <int> reward1 = {1,1,3,4};
    // vector <int> reward2 = {4,4,1,1};
    vector <int> reward1 = {1,1};
    vector <int> reward2 = {1,1};
    int k = 2;
    cout << miceAndCheese(reward1, reward2, k) << endl;
}
