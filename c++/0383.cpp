#include <string>
#include <map>
using namespace std;

class Solution0383 {
public:
    bool canConstruct(string ransomNote, string magazine) {
        int a[100] = {0};
        for(int i = 0;i < magazine.size();i++) {
            int t = magazine[i] - '0';
            a[t] += 1;
        }
        for(int j = 0;j < ransomNote.size();j++) {
            int t = ransomNote[j] - '0';
            a[t] -= 1;
            if(a[t] < 0) {
                return false;
            }
        }
        return true;
    }
};