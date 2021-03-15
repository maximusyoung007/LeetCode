#include<vector>
#include<string>
#include<map>
#include<queue>
using namespace std;

class Solution0126 {
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        map<string, int> wordId;
        vector<string> idWord;
        vector<vector<string>> result;

        int k;
        for (k = 0; k < wordList.size(); k++) {
            wordId[wordList[k]] = k;
            idWord.push_back(wordList[k]);
        }
        wordId[beginWord] = k;
        idWord.push_back(beginWord);

        if(wordId.count(endWord) == 0) {
            return result;
        }

        int dest = wordId[endWord];
        vector<vector<int>> edge(idWord.size());
        for (int i = 0; i < idWord.size(); i++) {
            for(int j = i + 1; j < idWord.size(); j++) {
                if (pathThrough(idWord[i], idWord[j])) {
                    edge[i].push_back(j);
                    edge[j].push_back(i);
                }
            }
        }

        vector<int> cost(idWord.size());
        for (int i = 0; i < idWord.size(); i++) {
            cost[i] = INT_MAX;
        }
        queue<vector<int>> q;
        vector<int> begin;
        begin.push_back(wordId[beginWord]);
        q.push(begin);
        cost[wordId[beginWord]] = 0;

        while(!q.empty()) {
            vector<int> now = q.front();
            q.pop();
            int recent = now[now.size() - 1];
            //是endword
            if (recent == dest) {
                vector<string> partResult;
                for (int i = 0; i < now.size(); i++) {
                    string word = idWord[now[i]];
                    partResult.push_back(word);
                }
                result.push_back(partResult);
            } else {
                for (int i = 0; i < edge[recent].size(); i++) {
                    int to = edge[recent][i];
                    if (cost[recent] + 1 <= cost[to]) {
                        cost[to] = cost[recent] + 1;
                        vector<int> temp = now;
                        temp.push_back(to);
                        q.push(temp);
                    }
                }
            }
        }
        return result;
    }

    bool pathThrough(const string& s1, const string& s2) {
        int diff = 0;
        if (s1.size() != s2.size()) {
            return false;
        }
        for (int i = 0; i < s1.size(); i++) {
            if (s1[i] != s2[i]) {
                diff++;
            }
        }
        return diff == 1;
    }
};