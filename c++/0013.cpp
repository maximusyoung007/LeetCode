#include"0013.h"
#include<string>
using namespace std;

int Solution0013::romainToInt(string s) {
    int temp = 0,result = 0;
    for(int i = 0;i < s.size();i++) {
        if(s[i] == 'I' && s[i+1] == 'V') {
            temp = 4;
            i++;
        } else if(s[i] == 'I' && s[i+1] == 'X') {
            temp = 9;
            i++;
        } else if(s[i] == 'X' && s[i+1] == 'L') {
            temp = 40;
            i++;
        } else if(s[i] == 'X' && s[i+1] == 'C') {
            temp = 90;
            i++;
        } else if(s[i] == 'C' && s[i+1] == 'D') {
            temp = 400;
            i++;
        } else if(s[i] == 'C' && s[i+1] == 'M') {
            temp = 900;
            i++;
        } else {
            switch (s[i]) {
                case 'I':
                    temp = 1;
                    break;
                case 'V':
                    temp = 5;
                    break;
                case 'X':
                    temp = 10;
                    break;
                case 'L':
                    temp = 50;
                    break;
                case 'C':
                    temp = 100;
                    break;
                case 'D':
                    temp = 500;
                    break;
                case 'M':
                    temp = 1000;
                    break;
            }
        }
        result += temp;
    }
    return result;
}