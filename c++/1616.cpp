#include<string>
using namespace std;

/*
    a: adcdf
    b: edefa
    a从左开始，b从右边开始，首先都取得了字符'a'
    a[1]到a[3]是一个字符串，所以刚好可以组成一个字符串
    以此类推即可
*/
bool isPalindrome(string s) {
    int left = 0, right = s.length() - 1;
    while (left < right) {
        if (s[left] == s[right]) {
            left++;
            right--;
        } else {
            return false;
        }
    }
    return true;
}

bool checkPalindromeFormation(string a, string b) {
    if (isPalindrome(a) || isPalindrome(b)) {
        return true;
    }
    int aLeft = 0, bRight = b.length() - 1;
    while (aLeft < bRight) {
        if (a[aLeft] != b[bRight]) {
            string st1 = a.substr(aLeft, bRight - aLeft + 1);
            string st2 = b.substr(aLeft, bRight - aLeft + 1);
            if (isPalindrome(st1) || isPalindrome(st2)) {
                return true;
            } else {
                break;
            }
        }
        aLeft++;
        bRight--;
    }
    if (aLeft >= bRight) {
        return true;
    }

    int bLeft = 0, aRight = a.length() - 1;
    while (bLeft < aRight) {
        if (b[bLeft] != a[aRight]) {
            string st1 = b.substr(bLeft, aRight - bLeft + 1);
            string st2 = a.substr(bLeft, aRight - bLeft + 1);
            if (isPalindrome(st1) || isPalindrome(st2)) {
                return true;
            } else {
                break;
            }
        }
        bLeft++;
        aRight--;
    }
    if (bLeft >= aRight) {
        return true;
    }
    return false;
}
