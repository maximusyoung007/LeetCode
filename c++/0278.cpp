#include<vector>
using namespace std;

class Solution0278 {
public:
    int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        //left==right
        return left;
    }

    bool isBadVersion(int n);
};

