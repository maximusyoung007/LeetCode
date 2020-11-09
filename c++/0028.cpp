#include<string>
#include<set>
#include"0028.h"
using namespace std;

int Solution0028::substr(string haystack, string needle) {
    if (haystack == "" && needle == "")
        return 0;
    if (needle.size() > haystack.size())
        return -1;
    for (int i = 0; i <= haystack.size() - needle.size(); i++) {
        if (haystack.substr(i, needle.size()) == needle) {
            return i;
        }
    }
    return -1;
}
