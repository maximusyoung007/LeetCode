#include<vector>
#include<stack>
#include<iostream>
using namespace std;

class Solution0084 {
public:
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