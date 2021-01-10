#include <vector>
#include <string>
using namespace std;

class Solution0953 {
public:
    bool isAlienSorted(vector<string>& words,string order) {
        for(int i = 0;i < words.size() - 1;i++) {
            string s1 = words[i];
            string s2 = words[i+1];
            if(!judgeTwo(s1,s2,order)) {
                return judgeTwo(s1,s2,order);
            }
        }
        return true;
    }

    bool judgeTwo(string word1,string word2,string order) {
        int i = 0,j = 0;
        while (i < word1.size() || j < word2.size()) {
            int index1 = 0,index2 = 0;
            char c1 = i < word1.size() ? word1[i] : ' ';
            char c2 = j < word2.size() ? word2[j] : ' ';
            i++;
            j++;
            for(int k = 0;k < order.size();k++) {
                if(c1 == ' ') {
                    index1 = -1;
                }
                if(c1 == order[k]) {
                    index1 = k;
                }
                if(c2 == ' ') {
                    index2 = -1;
                }
                if(c2 == order[k]) {
                    index2 = k;
                }
                if(index1 == -1 && index2 == -1) break;
            }
            if(index1 > index2) {
                return false;
            } else if(index1 < index2) {
                return true;
            } else if(index1 == index2) {
                continue;
            }
        }
        return true;
    }
};