#include<string>
#include"0067.h"
using namespace std;

string Solution0067::addBinary(string a, string b) {
    int i = 0,m,n,sum,carry = 0;
    string result = "";
    while(i < a.size() || i < b.size()) {
        m = i < a.size() ? a[a.size() - 1 - i] - '0' : 0;
        n = i < b.size() ? b[b.size() - 1 - i] - '0' : 0;
        sum = (m + n + carry) % 2;
        carry = (m + n + carry) / 2;
        result += to_string(sum);
        i++;
    }
    if(carry > 0) {
        result += "1";
    }
    reverse(result.begin(),result.end());
    return result;
}
