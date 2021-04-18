#include<string>
#include<map>
using namespace std;

class Solution0166 {
public:
    string fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        string result = "";
        if (numerator < 0 ^ denominator < 0) {
            result = result + "-";
        }
        long long dividend = abs((long long) numerator);
        long long divisor = abs((long long) denominator);
        long long prt = abs(dividend / divisor);
        string sprt = to_string(prt);
        result = result + sprt;
        long long remainder = dividend % divisor;
        if (remainder == 0) {
            return result;
        } else {
            result = result + ".";
        }
        map<long, int> m;
        while (remainder != 0) {
            if (m.count(remainder) != 0) {
                result.insert(m[remainder], "(");
                result.append(")");
                break;
            }
            m[remainder] = result.size();
            remainder *= 10;
            result.append(to_string(remainder / divisor));
            remainder = remainder % divisor;
        }
        return result;
    }
};