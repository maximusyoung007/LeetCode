#include<vector>
using namespace std;

vector<double> convertTemperature(double celsius) {
    return { celsius + 273.15, celsius * 1.80 + 32.00 };
}