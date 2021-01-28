public class Solution0065 {
    public boolean isNumber(String s) {
        if(s.contains("e") || s.contains("E")) {
            int index = s.indexOf('e') == -1 ? s.indexOf('E') : s.indexOf('e');
            String s1 = s.substring(0,index);
            String s2 = s.substring(index + 1,s.length());
            return (isDecimal(s1) || isInteger(s1)) && isInteger(s2);
        } else {
            return (isDecimal(s) || isInteger(s));
        }
    }

    boolean isDecimal(String s) {
        if(s.length() < 2) {
            return false;
        } else {
            int count = 0;
            for(int i = 0; i < s.length(); i++) {
                if(i == 0) {
                    if(s.charAt(i) == '-' || s.charAt(i) == '+') {
                        continue;
                    }
                    else if(s.charAt(i) == '.') {
                        count++;
                        if(s.charAt(i+1) <= '9' && s.charAt(i+1) >= '0') {
                            continue;
                        } else {
                            return false;
                        }
                    } else if(s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                        continue;
                    } else {
                        return false;
                    }
                } else if(i == 1) {
                    if(s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                        if((s.charAt(i - 1) == '-' || s.charAt(i - 1) == '+' || (s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '9') || s.charAt(i - 1) == '.')) {
                            if(i + 1 < s.length()) {
                                if((s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') || s.charAt(i + 1) == '.') {
                                    continue;
                                } else {
                                    return false;
                                }
                            }
                            continue;
                        } else {
                            return false;
                        }
                    } else if(s.charAt(i) == '.') {
                        count++;
                        if(s.charAt(i - 1) == '+' || s.charAt(i - 1) == '-') {
                            if((i + 1) < s.length() && s.charAt(i + 1) <= '9' && s.charAt(i + 1) >= '0') continue;
                            else return false;
                        }
                        else if(s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '9')continue;
                        else {
                            return false;
                        }
                    }
                    else {
                        return false;
                    }
                }
                else if(i + 1 < s.length()){
                    if (s.charAt(i) == '.') {
                        count++;
                        if (s.charAt(i + 1) <= '9' && s.charAt(i + 1) >= '0' && s.charAt(i - 1) <= '9' && s.charAt(i - 1) >= '0') {
                            continue;
                        } else {
                            return false;
                        }
                    } else if (s.charAt(i) <= '9' || s.charAt(i) >= '0') {
                        if (((s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '9') || s.charAt(i - 1) == '.') && ((s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') || s.charAt(i + 1) == '.'))  {
                            continue;
                        }
                        else {
                            return false;
                        }
                    }
                }
                else if(i == s.length() - 1) {
                    if(s.charAt(i) == '.') count++;
                    else if(s.charAt(i) <= '9' && s.charAt(i) >= '0');
                    else return false;
                }
            }
            if(count > 1) {
                return false;
            }
        }
        return true;
    }

    boolean isInteger(String s) {
        if(s.length() < 1) {
            return false;
        }
        if(s.length() == 1) {
            if(s.charAt(0) >= '0' && s.charAt(0) <= '9') {
                return true;
            } else {
                return false;
            }
        }
        else if (s.length() > 1) {
            for(int i = 0; i < s.length(); i++) {
                if(i == 0) {
                    if (s.charAt(i) == '-' || s.charAt(i) == '+' || (s.charAt(i) <= '9' && s.charAt(i) >= '0')) {
                        continue;
                    }
                    else {
                        return false;
                    }
                }
                else {
                    if(s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
