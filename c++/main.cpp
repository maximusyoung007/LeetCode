#include <iostream>
// #include "0954.cpp"
// #include "0736.cpp"
//#include "0187.cpp"
using namespace std;
#include"1615.cpp"
int main() {
    //vector<vector<int>> v = {{0,1}, {0,3}, {1,2}, {1,3}};
    vector<vector<int>> v = {{0,1}, {0,3}, {1,2}, {1,3}, {2,3}, {2,4}};
    // vector<vector<int>> v = {{0,1}, {2,3}, {1,2}, {2,4}, {5,6}, {5,7}};
    //vector<vector<int>> v = {};
    //vector<vector<int>> v = {{0, 2}, {0, 1}};
    //vector<vector<int>> v = {{4,6},{5,2},{3,5},{7,5},{7,6}};
   // vector<vector<int>> v = {{1, 0}};
    cout << maximalNetworkRank(5, v) << endl;
}
