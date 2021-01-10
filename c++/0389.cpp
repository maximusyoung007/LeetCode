#include<string>
using namespace std;

class Solution0389 {
public:
    char findTheDifference(string s, string t) {
        string a = s + t;
        char result = a[0];
        for(int i = 1;i < a.size();i++) {
            result = result ^ a[i];
        }
        return result;
    }
};