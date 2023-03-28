#include <vector>
using namespace std;


bool primeSubOperation(vector<int>& nums) {
    vector<int> prime;
    for(int i = 2; i <= 1000;i++){
        int j = 2;
        for (; j < i; j++) {
            if (i % j == 0)
            break;
        }
        if (j >= i) {
            prime.push_back(i);
        }
    }
    for (int i = nums.size() - 1; i > 0; i--) {
        if (nums[i - 1] >= nums[i]) {
            int k;
            int t = 0;
            for (k = 0; k < prime.size(); k++) {
                t = nums[i - 1] - prime[k];
                if (t < nums[i]) {
                    if (t <= 0) {
                        return false;
                    }
                    nums[i - 1] = t;
                    //t = 0;
                    break;
                }
            }
            if (k == prime.size() && t >= nums[i]) {
                return false;
            }
        }
    }
    return true;
}