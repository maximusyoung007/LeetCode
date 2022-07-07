#include <string>
#include <unordered_map>
using namespace std;
class Solution {
public:
    int evaluate(string expression) {
        unordered_map<string, int> myMap;
        return help(expression, myMap);
    }
private:
    int help(string expression,unordered_map<string,int> myMap) {
        if ((expression[0] == '-') || (expression[0] >= '0' && expression[0] <= '9')) {
            return stoi(expression);
        }
        else if (expression[0] != '(') {
            return myMap[expression];
        }
        //to get rid of the first '(' and the last ')'
        string s = expression.substr(1, expression.size() - 2);
        int start = 0;
        string word = parse(s, start);
        if (word == "let") {
            while (true) {
                string variable = parse(s, start);
                //if there is no more expression, simply evaluate the variable
                if (start > s.size()) {
                    return help(variable, myMap);
                }
                string temp = parse(s, start);
                myMap[variable] = help(temp, myMap);
            }
        }
        else if (word == "add") {
            return help(parse(s, start), myMap) + help(parse(s, start), myMap);
        }
        else if (word == "mult") {
            return help(parse(s, start), myMap) * help(parse(s, start), myMap);
        }
        return 0;
    }
    string parse(string &s,int &start) {    //function to seperate each expression
        int end = start + 1, temp = start, count = 1;
        if (s[start] == '(') {
            while (count != 0) {
                if (s[end] == '(') {
                    ++count;
                }
                else if (s[end] == ')') {
                    --count;
                }
                ++end;
            }
        }
        else {
            while (end < s.size() && s[end] != ' ') {
                ++end;
            }
        }
        start = end + 1;
        return s.substr(temp, end - temp);
    }
};