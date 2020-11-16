#include"0273.h"
#include<map>
#include<vector>
#include<string>
#include<algorithm>
using namespace std;
string Solution273 ::numberToWords(int num) {
    if(num == 0) return "Zero";
    vector<int> nums;
    vector<string> result_;
    int i = 0;
    string tem_s = "";
    if(num <= 999) {
        result_.push_back(numUnderOneThousand(num));
    } else {
        while (num >= 1000) {
            int tem = num % 1000;
            num = num / 1000;
            nums.push_back(tem);
        }
        if(num <= 999 && num > 0) {
            nums.push_back(num);
        }
        for(int i = nums.size() - 1;i >= 0;i--) {
            string s = numUnderOneThousand(nums[i]);
            result_.push_back(s);
        }
    }
    string result = "";
    if(result_.size() == 4) {
        result = (result_[0] != "" ? result_[0] + " Billion " : "") +
                 (result_[1] != "" ? result_[1]  + " Million " : "") +
                (result_[2] != "" ? result_[2] + " Thousand " : "") +
                (result_[3] != "" ? result_[3] : "");
    } else if (result_.size() == 3) {
        result = (result_[0] != "" ? result_[0]  + " Million " : "") +
                (result_[1] != "" ? result_[1] + " Thousand " : "") +
                (result_[2] != "" ? result_[2] : "");
    } else if(result_.size() == 2) {
        result = (result_[0] != "" ? result_[0] + " Thousand " : "") +
                (result_[1] != "" ? result_[1] : "");
    } else {
        result = result_[0] != "" ? result_[0] : "";
    }
    if(result[result.size() - 1] == ' ') {
        result = result.substr(0,result.size() - 1);
    }
    return result;
}
string Solution273 :: numUnderOneThousand(int num) {
    map<int,string> myMap = {{1,"One"},{2,"Two"},{3,"Three"},{4,"Four"},
                             {5,"Five"},{6,"Six"},{7,"Seven"},{8,"Eight"},
                             {9,"Nine"},{10,"Ten"},{11,"Eleven"},{12,"Twelve"},
                             {13,"Thirteen"},{14,"Fourteen"},{15,"Fifteen"},{16,"Sixteen"},
                             {17,"Seventeen"},{18,"Eighteen"},{19,"Nineteen"},{20,"Twenty"},
                             {30,"Thirty"},{40,"Forty"},{50,"Fifty"},{60,"Sixty"},
                             {70,"Seventy"},{80,"Eighty"},{90,"Ninety"}
                             };
    int hundredInt = num / 100;
    string hundredString = myMap[hundredInt];
    int ten = num % 100;
    string result = "";
    if(hundredInt > 0) {
        if (ten < 20) {
            result =  hundredString + " Hundred " + myMap[ten];
        } else {
            int digit = num % 10;
            result =  hundredString + " Hundred " + myMap[(ten / 10) * 10] + " " + myMap[digit];
        }
    } else {
        if (ten < 20) {
            result = myMap[ten];
        } else {
            int digit = num % 10;
            result = myMap[(ten / 10) * 10] + " " + myMap[digit];
        }
    }
    if(result[result.size() - 1] == ' ') {
        result = result.substr(0,result.size() - 1);
    }
    return result;
}