#include<vector>
#include<algorithm>
using namespace std;
/*
经典贪心问题。先假设所有奶酪都是第二只老鼠吃掉的，那么得分为 sum(reward2)。

现在我们要把 kk 个奶酪改成第一只老鼠吃掉的。假设我们把第 ii 个奶酪改成第一只老鼠吃掉，
那么与第二只老鼠吃掉相比，得分的变化量为 reward1[i] - reward2[i]。

为了让得分尽量大，我们需要让得分的变化量总和尽量大。因此选择前 kk 大的变化量即可。
*/
/*
[1,1,3,4]
[4,4,1,1]
2
*/
int miceAndCheese(vector<int>& reward1, vector<int>& reward2, int k) {
    int sum = 0;
    vector<int> sub;
    for (int i = 0; i < reward2.size(); i++) {
        sum += reward2[i];
    }
    for (int i = 0; i < reward1.size(); i++) {
        sub.push_back(reward1[i] - reward2[i]);
    }
    sort(sub.begin(), sub.end());
    int is = sub.size() - 1;
    for (int i = 0; i < k; i++) {
        sum += sub[is];
        is--;
    }
    return sum;
}