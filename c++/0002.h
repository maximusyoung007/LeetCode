
#ifndef C___0002_H
#define C___0002_H
#include<vector>
#include<string>
using namespace std;
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0),next(nullptr){}
    ListNode(int x) : val(x),next(nullptr) {}
    ListNode(int x,ListNode *next):val(x),next(next){}
};
class Solution0002 {
public:
    ListNode* addTwoNumbers(ListNode* l1,ListNode* l2);
};
#endif //C___0003_H
