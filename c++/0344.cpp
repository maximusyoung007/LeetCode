#include <vector>
using namespace std;

class Solution0344 {
public:
    void reverseString(vector<char>& s) {
        int len = s.size();
        char t;
        for(int left = 0,right = len - 1;left < right;left++,right--) {
            t = s[left];
            s[left] = s[right];
            s[right] = t;
        }
    }
};