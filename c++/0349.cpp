#include<vector>
#include<set>
using namespace std;

class Solution0349 {
public:
	vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
		vector<int> result;
		set<int> mySet2(nums2.begin(), nums2.end());
		set<int> mySet1(nums1.begin(), nums1.end());
		for (set<int>::iterator it = mySet1.begin(); it != mySet1.end(); it++) {
			if (mySet2.find(*it) != mySet2.end()) {
				result.push_back(*it);
			}
		}
		return result;
	}
};