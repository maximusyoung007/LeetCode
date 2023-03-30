#include<string>
#include<vector>
#include<algorithm>
using namespace std;

static bool cmp(string a, string b) {
    string ab = a + b;
    string ba = b + a;
    return ab > ba;
}

string largestNumber(vector<int>& nums) {
    vector<string> numstring;
    for (int i = 0; i < nums.size(); i++) {
        numstring.push_back(to_string(nums[i]));
    }
    sort(numstring.begin(), numstring.end(), cmp);
    string res = "";
    for (int i = 0; i < numstring.size(); i++) {
        res.append(numstring[i]);
    }
    if (res.size() > 1 && res[0] == '0') {
        return "0";
    }
    return res;
}