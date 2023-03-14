#include <iostream>
// #include "0954.cpp"
// #include "0736.cpp"
//#include "0187.cpp"
using namespace std;
#include"1605.cpp"
int main() {
    vector<int> rowNum = {5,7,10};
    vector<int> colNum = {8,6,8};
    vector<vector<int>> res = restoreMatrix(rowNum, colNum);
    for (vector<int> v : res) {
        for (int i = 0; i < v.size(); i++) {
            cout << v[i] << " ";
        }
        cout << endl;
    }
}
