#include<vector>
#include<stack>
using namespace std;

class Solution0085 {
public:
    int maximalRectangle(vector<vector<char>>& matrix) {
        if(matrix.size() == 0) {
            return 0;
        }
        int row = 0,result = 0;
        vector<int> height;
        while (row < matrix.size()) {
            height.clear();
            for (int j = 0; j < matrix[0].size(); j++) {
                int temp = 0;
                for (int i = 0; i <= row; i++) {
                    if(matrix[i][j] == '1') {
                        temp += 1;
                    } else {
                        temp = 0;
                    }
                }
                height.push_back(temp);
            }
            row++;
            int t = largestRectangleArea(height);
            if (t > result) {
                result = t;
            }
        }
        return result;
    }

    int largestRectangleArea(vector<int>& heights) {
        vector<int> guard1;
        vector<int> guard2;
        stack<int> s;
        int maxArea = 0;
        int i = 0;
        //计算左边界
        while(i < heights.size()) {
            if(s.empty() || heights[s.top()] < heights[i]) {
                if(s.empty()) {
                    guard1.push_back(-1);
                }
                else {
                    guard1.push_back(s.top());
                }
            }
            else {
                while(!s.empty() && heights[s.top()] >= heights[i]) {
                    s.pop();
                }
                if(s.empty()) {
                    guard1.push_back(-1);
                }
                else {
                    guard1.push_back(s.top());
                }
            }
            s.push(i);
            i++;
        }

        s = stack<int>();
        //计算右边界
        int j = heights.size() - 1;
        while(j >= 0) {
            if(s.empty() || heights[s.top()] < heights[j]) {
                if(s.empty()) {
                    guard2.push_back(heights.size());
                }
                else {
                    guard2.push_back(s.top());
                }
            }
            else {
                while(!s.empty() && heights[s.top()] >= heights[j]) {
                    s.pop();
                }
                if(s.empty()) {
                    guard2.push_back(heights.size());
                }
                else {
                    guard2.push_back(s.top());
                }
            }
            s.push(j);
            j--;
        }
        reverse(guard2.begin(), guard2.end());
        int width;
        for(int k = 0; k < guard1.size(); k++) {
            width = guard2[k] - guard1[k] - 1;
            if(heights[k] * width > maxArea) {
                maxArea = heights[k] * width;
            }
        }
        return maxArea;
    }
};