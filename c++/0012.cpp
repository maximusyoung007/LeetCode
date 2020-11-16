#include<string>
#include<map>
#include"0012.h"
using namespace std;
string Solution0012::intToRoman(int num) {
    string result = "";
    multimap<int,string,greater<int>> myMap{{1000,"M"},{900,"CM"},{500,"D"},{400,"CD"},{100,"C"},
            {90,"XC"},{50,"L"},{40,"XL"},{10,"X"},{9,"IX"},
                        {5,"V"},{4,"IV"},{1,"I"}
    };
    for(map<int,string>::iterator it = myMap.begin();it != myMap.end();it++) {
        while (num >= it->first) {
            num -= it->first;
            result += it->second;
        }
    }
    return result;
}