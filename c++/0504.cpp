#include <string>
using namespace std;

class Solution0504 {
public:
    string convertToBase7(int num) {
        string result = "";
        bool flag = true;
        if(num < 0) {
            num = -num;
            flag = false;
        }
        while(num >= 7) {
            int pr = num % 7;
            result += (pr + '0');
            num = num / 7;
        }
        result += (num + '0');
        if(!flag) {
            result += '-';
        }
        reverse(result.begin(),result.end());
        return result;
    }
};