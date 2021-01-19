#include<vector>
#include<string>
#include<map>
#include<set>
using namespace std;

class Solution0030 {
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        int num = words.size();
        int wordLen = words[0].size();
        map<string,int> mapWords;
        map<string,int> mapS;
        vector<int> result;
        for(int i = 0;i < num;i++) {
            string word = words[i];
            if(mapWords.count(word) == 0) {
                mapWords[word] = 1;
            } else {
                mapWords[word] += 1;
            }
        }
        for(int i = 0;i < wordLen;i++) {
            int j = i,numT = 0;
            int firstIndex = i;
            string firstS = s.substr(firstIndex,wordLen);
            mapS.clear();
            while(numT < num) {
                if(firstIndex >= s.size() - wordLen * num + 1) {
                    break;
                }
                string tempS = s.substr(j,wordLen);
                //如果有不存在的单词，直接从这个单词后一个开始重新匹配
                if(mapWords.count(tempS) == 0) {
                    j = j + wordLen;
                    numT = 0;
                    mapS.clear();
                    firstIndex = j;
                    firstS = s.substr(firstIndex,wordLen);
                }
                else {
                    if(mapS.count(tempS) == 0) {
                        mapS[tempS] = 1;
                    } else {
                        mapS[tempS] += 1;
                    }
                    numT += 1;
                    //如果有重复的单词，持续删除单词直到不重复为止
                    if(mapS[tempS] > mapWords[tempS]) {
                        while(mapS[tempS] > mapWords[tempS]) {
                            string tempT = s.substr(firstIndex,wordLen);
                            mapS[tempT] -= 1;
                            firstIndex += wordLen;
                            firstS = s.substr(firstIndex,wordLen);
                        }
                        if(mapS[tempS] == mapWords[tempS]) {
                            j = firstIndex;
                            numT = 0;
                            mapS.clear();
                        }
                    }
                    else {
                        j += wordLen;
                        if(numT == num) {
                            int k;
                            for(k = 0;k < num;k++) {
                                string st = words[k];
                                if(mapS[st] == mapWords[st]) {
                                    continue;
                                } else {
                                    break;
                                }
                            }
                            //如果匹配，将去除第一个单词，加上后一个单词
                            if(k == num) {
                               result.push_back(firstIndex);
                               numT -= 1;
                               mapS[firstS] -= 1;
                               firstIndex = firstIndex + wordLen;
                               if(firstIndex + wordLen < s.size()) {
                                   firstS = s.substr(firstIndex, wordLen);
                               }
                            }
                        }
                    }
                }
            }
        }
        set<int> set(result.begin(), result.end());
        result.assign(set.begin(), set.end());
        return result;
    }
};