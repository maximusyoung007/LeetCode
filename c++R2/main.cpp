#include<iostream>
#include<string>
#include<vector>
#include"0322.cpp"
#include"0072.cpp"
#include"0650.cpp"
// #include"0121.cpp"
#include"0309.cpp"
#include"0213.cpp"
#include"0053.cpp"
// #include"0343.cpp"
#include"0583.cpp"
#include"0646.cpp"
using namespace std;

int main() {
    cout << "leetcode c++ Round2" << endl;
    // string word1 = "sea", word2 = "eat";
    // string word1 = "leetcode", word2 = "etco";
    // string word1 = "a", word2 = "b";
    // cout << minDistance2(word1, word2) << endl;
    vector<vector<int> > pairs;
    // vector<int> pair1 = {1,2};
    // vector<int> pair2 = {2,3};
    // vector<int> pair3 = {3,4};
    vector<int> pair1 = {-6, 9};
    vector<int> pair2 = {1,6};
    vector<int> pair3 = {8, 10};
    vector<int> pair4 = {-1,4};
    vector<int> pair5 = {-6,-2};
    vector<int> pair6 = {-9,8};
    vector<int> pair7 = {-5,3};
    vector<int> pair8 = {0,3};
    pairs.push_back(pair1);
    pairs.push_back(pair2);
    pairs.push_back(pair3);
    pairs.push_back(pair4);
    pairs.push_back(pair5);
    pairs.push_back(pair6);
    pairs.push_back(pair7);
    pairs.push_back(pair8);
    cout << findLongestChain(pairs) << endl;
    // vector<int> v = {2, 3,2};
    // vector<int> v = {1,2,3,1};
    // vector<int> v = {1,2,3};
    // vector<int> v = {1,2};
    // vector<int> v = {-2,1,-3,4,-1,2,1,-5,4};
    // cout << maxSubArray(v) << endl;
    // cout << integerBreak(2) << endl;
    // cout << integerBreak(10) << endl;
    // vector<int> v = {7,1,5,3,6,4};
    // vector<int> v = {1,2,3,0,2};
    // cout << maxProfit(v) << endl;
    // vector<int> v = {1, 2, 5};
    // vector<int> v = {2};
    // vector<int> v = {1};
    // cout << coinChange(v, 0) << endl;
    
    // string word1 = "horse", word2 = "ros";
    // string word1 = "", word2 = "a";
    // cout << minDistance(word1, word2) << endl;

    // cout << minSteps(1) << endl;
    // cout << minSteps(2) << endl;
    // cout << minSteps(3) << endl;
    // cout << minSteps(4) << endl;

    return 0;
}

