#include<string>
#include<map>
#include<algorithm>
using namespace std;

class Solution0168 {
public:
    map<int, string> m {
        {1, "A"}, {2, "B"}, {3, "C"}, {4, "D"}, {5, "E"},
        {6, "F"}, {7, "G"}, {8, "H"}, {9, "I"}, {10, "J"},
        {11, "K"}, {12, "L"}, {13, "M"}, {14, "N"}, {15, "O"},
        {16, "P"}, {17, "Q"}, {18, "R"}, {19, "S"}, {20, "T"},
        {21, "U"}, {22, "V"}, {23, "W"}, {24, "X"}, {25, "Y"},
        {26, "Z"}
        };
    string convertToTitle(int columnNumber) {
        string result = "";
        while (columnNumber > 26) {
            int t;
            if (columnNumber % 26 == 0) {
                t = 26;
                columnNumber = (columnNumber - 26) / 26;
            } else {
                t = columnNumber % 26;
                columnNumber = columnNumber / 26;
            }
            result = result + m[t];
        }
        result = result + m[columnNumber];
        reverse(result.begin(), result.end());
        return result;
    }
};