#include <iostream>
#include<string>
#include<algorithm>
#include "1626.cpp"
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
    vector<int> scores = {1, 3, 7, 3,2,4,10,7,5};
    vector<int> ages = {4,5,2,1,1,2,4,1,4};
    cout << "res:" << beatTeamScore(scores, ages) << endl;
}
