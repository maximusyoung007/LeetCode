#include<vector>
#include<algorithm>
#include"0989.h"
using namespace std;
vector<int> Solution0989::addToArrayForm(vector<int> &A, int K) {
    vector<int> b,result;
    while(K > 0) {
        b.push_back(K % 10);
        K = K / 10;
    }
    reverse(A.begin(),A.end());
    int i = 0,carry = 0,a,c,sum;
    while(i < A.size() || i < b.size()) {
        a = i < A.size() ? A[i] : 0;
        c = i < b.size() ? b[i] : 0;
        sum = (a + c + carry) % 10;
        result.push_back(sum);
        carry = (a + c + carry) / 10;
        i++;
    }
    if(carry > 0) {
        result.push_back(carry);
    }
    reverse(result.begin(),result.end());
    return result;
}