#include<string>
#include<vector>
#include<stdlib.h>
using namespace std;

class Solution0165 {
public:
    int compareVersion(string version1, string version2) {
        vector<int> v1, v2;
        getV(v1, version1);
        getV(v2, version2);
        int i = 0;
        int len = min(v1.size(), v2.size());
        while (i < len) {
            int t1, t2;
            if (i < v1.size()) {
                t1 = v1[i];
            }
            if (i < v2.size()) {
                t2 = v2[i];
            }
            if (t1 == t2) {
                i++;
            }
            else if (t1 < t2) {
                return -1;
            }
            else if (t1 > t2) {
                return 1;
            }
        }
        if (len < v1.size()) {
            while (i < v1.size()) {
                if (v1[i] != 0) {
                    return 1;
                }
                i++;
            }
        }
        if (len < v2.size()) {
            while (i < v2.size()) {
                if (v2[i] != 0) {
                    return -1;
                }
                i++;
            }
        }
        return 0;
    }

    void getV(vector<int>& v, string version) {
        for (int i = 0; i < version.size(); i++) {
            if (version[i] == '.') {
                int vt = atoi(version.substr(0, i).c_str());
                v.push_back(vt);
                version = version.substr(i + 1);
                getV(v, version);
                break;
            }
            if (i == version.size() - 1) {
                v.push_back(atoi(version.c_str()));
            }
        }
    }
};