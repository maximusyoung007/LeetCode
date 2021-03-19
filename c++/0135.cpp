#include<vector>
using namespace std;

class Solution0135 {
public:
    int candy(vector<int>& ratings) {
        int n = ratings.size();
        vector<int> result(n);
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result[i] = 1;
            } else {
                if (ratings[i-1] < ratings[i]) {
                    result[i] = result[i-1] + 1;
                } else {
                    result[i] = 1;
                }
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                result[i] = max(result[i],result[i+1] + 1);
            }
        }
        int sum = 0;
        for (int t : result) {
            sum += t;
        }
        return sum;
    }
};