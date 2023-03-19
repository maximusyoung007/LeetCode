#include<string>
#include<queue>
#include<set>
using namespace std;

string findLexSmallestString(string s, int a, int b) {
    queue<string> numbers;
    numbers.push(s);
    set<string> ss;
    ss.insert(s);
    string minS = s;

    while (!numbers.empty()) {
        string st = numbers.front();
        numbers.pop();
        string s1 = st;
        for (int i = 1; i < s.length(); i += 2) {
            s1[i] = (s1[i] - '0' + a) % 10 + '0';
        }
        string s2 = st.substr(st.length() - b) + st.substr(0, st.length() - b);
        if (ss.count(s1) == 0) {
            if (s1 < minS) {
                minS = s1;
            }
            ss.insert(s1);
            numbers.push(s1);
        }
        if (ss.count(s2) == 0) {
            if (s2 < minS) {
                minS = s2;
            }
            ss.insert(s2);
            numbers.push(s2);
        }
    }
    return minS;
}

