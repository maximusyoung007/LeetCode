#include <iostream>
using namespace std;
#include"2389.cpp"
int main() {
    vector<int> num;
    num.push_back(2);
    num.push_back(3);
    num.push_back(4);
    num.push_back(5);
    vector<int> query;
    query.push_back(1);
    // query.push_back(10);
    // query.push_back(21);
    vector<int> res = answerQueries(num, query);
    vector<int>::iterator start = res.begin();//指向容器的初始位置
    vector<int>::iterator end = res.end();
    while (start != end) {
        cout << *start << endl;
        start++;
    }
}
