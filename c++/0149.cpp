#include<vector>
#include<map>
using namespace std;

class Solution0149 {
public:
    int maxPoints(vector<vector<int>> &points) {
        if (points.size() < 3) {
            return points.size();
        }
        int result = 0;
        for (int i = 0; i < points.size(); i++) {
            map<pair<int, int>, int> m;
            int same = 0;
            for (int j = 0; j < points.size(); j++) {
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                if (x == 0 && y == 0) {
                    same++;
                } else {
                    int g = gcd(x, y);
                    x = x / g;
                    y = y / g;
                    m[make_pair(x, y)]++;
                }
            }
            int t = 0;
            map<pair<int, int>, int>::iterator it;
            it = m.begin();
            while (it != m.end()) {
                t = max(t, it->second);
                it++;
            }
            result = max(result, t + same);
        }
        return result;
    }

    int gcd(int x, int y) {
        while (x != 0) {
            int temp = y % x;
            y = x;
            x = temp;
        }
        return y;
    }
};