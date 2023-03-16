#include<string.h>
/*
1、
奇数
k是子数组的中位数 <=> 子数组中小于 k 的数的个数 == 大于 k 的数的个数
左侧小于+右侧小于=左侧大于+右侧大于 <=> 左侧小于-左侧大于=右侧大于-右侧小于 <=> -(左侧大于-左侧小于)=右侧大于-右侧小于
偶数
左侧小于+右侧小于=左侧大于+右侧大于-1，即左侧小于-左侧大于=右侧大于-右侧小于-1，-（左侧小于-左侧大于）+ 1 = 右侧大于-右侧小于
cnt[],表示比k大的数和比k小的数的差值,先看右侧x在0，1之间的，再看左侧x在0，1之间的
看左侧时如果-x或者-x+1也在cnt中，表示存在跨越左右两侧的子数组，则res += cnt[-x] + cnt[-x+1]
所有存在数组中的x都+n,则cnt的范围从[-n,n]变成了[0,2n]
*/
int countSubarrays(int* nums, int numsSize, int k) {
    int centerI = 0, res = 1;
    for (int i = 0; i < numsSize; i++) {
        if (*(nums + i) == k) {
            centerI = i;
        }
    }
    int cnt[numsSize * 2 + 1];
    memset(cnt, 0, sizeof(cnt));
    
    int x = 0;
    for (int i = centerI + 1; i < numsSize; i++) {
        x += *(nums + i) > k ? 1 : -1;
        if (x <= 1 && x >= 0) {
            res++;
        }
        cnt[x+numsSize]++;
    }

    x = 0;
    for (int i = centerI - 1; i >= 0; i--) {
        x += *(nums + i) > k ? 1 : -1;
        if (x <= 1 && x >= 0) {
            res++;
        }
        //有就有，没有就是0
        res += cnt[-x+numsSize] + cnt[-x+1+numsSize];
    }
    return res;
}