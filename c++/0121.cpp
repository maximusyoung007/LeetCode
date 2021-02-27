#include<vector>
#include<map>
using namespace std;

class Solution0121 {
public:
    int maxProfit(vector<int>& prices) {
        //暴力法超时
//        int result = 0;
//        for (int i = 0; i < prices.size(); i++) {
//            for(int j = i + 1; j < prices.size(); j++) {
//                if (prices[j] - prices[i] > result) {
//                    result = prices[j] - prices[i];
//                }
//            }
//        }
//        return result;
        int result = 0;
        int min = prices[0];
        for (int i = 1; i < prices.size(); i++) {
            if (prices[i] > min) {
                if (prices[i] - min > result) {
                    result = prices[i] - min;
                }
            }
            else if (prices[i] < min) {
                min = prices[i];
            }
        }
        return result;
    }
};