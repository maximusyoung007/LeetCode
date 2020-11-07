#include<string>
#include<set>
#include<0028.h>
using namespace std;

int Solution0028::substr(string haystack, string needle) {
	if (haystack == "" && needle == "")
		return 0;
	for (int i = 0; i < haystack.size(); i++) {
		int j, k;
		for (j = i, k = 0; k < needle.size() && haystack[j] == needle[k]; j++, k++);
		if (k > 0 && k == needle.size()) {
			return j - k;
		}
	}
	return -1;
}
