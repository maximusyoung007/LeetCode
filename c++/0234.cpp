#include"listnode.h"
#include<vector>
#include"0234.h"
using namespace std;
bool Solution234::isPalindrome(ListNode *head) {
    if(!head || !head->next)
        return true;
    vector<int> myVector;
    while(head) {
        int temp = head->val;
        myVector.push_back(temp);
        head = head->next;
    }
    int left = 0,right = myVector.size() - 1;
    while(left < right) {
        if(myVector[left] == myVector[right]) {
            left++;
            right--;
        } else {
            break;
        }
    }
    if(left < right) return false;
    else return true;
}