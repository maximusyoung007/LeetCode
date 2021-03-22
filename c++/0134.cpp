#include<vector>
using namespace std;

class Solution0134 {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int totalGas = 0, totalCost = 0, minCost = 0, earnCost = 0, minIndex = -1;
        for (int i = 0; i < gas.size(); i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            earnCost += (gas[i] - cost[i]);
            //找到花费汽油减去拥有汽油的最低点，这个点到最后再走,（先累积汽油再使用汽油）。所以从这个点的下一个点开始走
            if (earnCost < minCost) {
                minCost = earnCost;
                minIndex = i;
            }
        }
        return totalCost - totalGas > 0 ? -1 : minIndex + 1;
    }
};