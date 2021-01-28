#include<string>
using namespace std;

class Solution0065 {
public:
    bool isNumber(string s) {
        int counts = 0;
        for(int i = 0; i < s.size(); i++) {
            if(s[i] == 'e' || s[i] == 'E') {
                counts++;
            }
            if(s[i] == 'E') {
                s[i] = s[i] + 32;
            }
        }
        if (counts == 0) {
            return isDecimal(s) || isInteger(s);
        } else if (counts == 1) {

            int index = s.find('e');
            string s1 = s.substr(0,index);
            string s2 = s.substr(index+1,s.size() - index - 1);
            return (isDecimal(s1) || isInteger(s1)) && isInteger(s2);
        } else {
            return false;
        }
    }

    bool isDecimal(string s) {
        if(s.size() < 2) {
            return false;
        } else {
            int count = 0;
            for(int i = 0; i < s.size(); i++) {
                if(i == 0) {
                    if(s[i] == '-' || s[i] == '+') {
                        continue;
                    }
                    else if(s[i] == '.') {
                        count++;
                        if(s[i + 1] <= '9' && s[i + 1] >= '0') {
                            continue;
                        } else {
                            return false;
                        }
                    } else if(s[i] <= '9' && s[i] >= '0') {
                        continue;
                    } else {
                        return false;
                    }
                } else if(i == 1) {
                    if(s[i] <= '9' && s[i] >= '0') {
                        if((s[i - 1] == '-' || s[i - 1] == '+' || (s[i-1] >= '0' && s[i-1] <= '9') || s[i - 1] == '.')) {
                            if(i + 1 < s.size()) {
                                if((s[i+1] >= '0' && s[i+1] <= '9') || s[i+1] == '.') {
                                    continue;
                                } else {
                                    return false;
                                }
                            }
                            continue;
                        } else {
                            return false;
                        }
                    } else if(s[i] == '.') {
                        count++;
                        if(s[i-1] == '+' || s[i-1] == '-') {
                            if(s[i+1] <= '9' && s[i + 1] >= '0') continue;
                            else return false;
                        }
                        else if(s[i-1] >= '0' && s[i-1] <= '9')continue;
                        else {
                            return false;
                        }
                    }
                    else {
                        return false;
                    }
                }
                else if(i + 1 < s.size()){
                    if (s[i] == '.') {
                        count++;
                        if (s[i + 1] <= '9' && s[i + 1] >= '0' && s[i - 1] <= '9' && s[i - 1] >= '0') {
                            continue;
                        } else {
                            return false;
                        }
                    } else if (s[i] <= '9' || s[i] >= '0') {
                        if (((s[i - 1] >= '0' && s[i - 1] <= '9') || s[i - 1] == '.') && ((s[i + 1] >= '0' && s[i + 1] <= '9') || s[i + 1] == '.'))  {
                            continue;
                        }
                        else {
                            return false;
                        }
                    }
                }
                else if(i == s.size() - 1) {
                    if(s[i] == '.') count++;
                    else if(s[i] <= '9' && s[i] >= '0');
                    else return false;
                }
            }
            if(count > 1) {
                return false;
            }
        }
        return true;
    }

    bool isInteger(string s) {
        if(s.size() < 1) {
            return false;
        }
        if(s.size() == 1) {
            if(s[0] >= '0' && s[0] <= '9') {
                return true;
            } else {
                return false;
            }
        }
        else if (s.size() > 1) {
            for(int i = 0; i < s.size(); i++) {
                if(i == 0) {
                    if (s[i] == '-' || s[i] == '+' || (s[i] <= '9' && s[i] >= '0')) {
                        continue;
                    }
                    else {
                        return false;
                    }
                }
                else {
                    if(s[i] <= '9' && s[i] >= '0') {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
};