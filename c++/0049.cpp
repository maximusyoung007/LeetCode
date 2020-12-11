#include "0049.h"
#include<algorithm>
#include<map>
vector<vector<string>> Solution0049::groupAnagrams(vector<string> &strs) {
    vector<vector<string>> v;
    map<string,string> map;
    for(int i = 0;i < strs.size();i++) {
        string s = strs[i];
        sort(s.begin(),s.end());
        vector<string> temp;
        if(v.size() == 0) {
            map[s] = 1;
            temp.push_back(strs[i]);
            v.push_back(temp);
        } else {
            if(map.count(s) == 0) {
                map[s] = 1;
                temp.push_back(strs[i]);
                v.push_back(temp);
                continue;
            }
            for(int j = 0;j < v.size();j++) {
                vector<string> v2 = v[j];
                sort(v2[0].begin(),v2[0].end());
                if(v2[0] == s) {
                    v[j].push_back(strs[i]);
                    break;
                }
            }
        }
    }

    return v;
}