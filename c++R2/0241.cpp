#include<vector>
#include<string>
using namespace std;

vector<int> diffWaysToCompute(string expression) {
    int n = expression.size();
    if (expression.find("+") == string::npos && 
        expression.find("-") == string::npos && 
        expression.find("*") == string::npos
        ) {
        return vector<int> (1, stoi(expression));
    }
    vector<int> res;
    for (int i = 0; i < n; i++) {
        if (expression[i] == '+' || expression[i] == '-' || expression[i] == '*') {
            vector<int> left = diffWaysToCompute(expression.substr(0, i));
            vector<int> right = diffWaysToCompute(expression.substr(i+1));
            for (int j = 0; j < left.size(); j++) {
                for (int k = 0; k < right.size(); k++) {
                    if (expression[i] == '+') {
                        res.push_back(left[j] + right[k]);
                    } else if (expression[i] == '-') {
                        res.push_back(left[j] - right[k]);
                    } else if (expression[i] == '*') {
                        res.push_back(left[j] * right[k]);
                    }
                }
            }
        }
    }
    return res;
}
