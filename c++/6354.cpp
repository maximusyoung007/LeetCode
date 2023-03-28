int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
    int res = 0;
    for (int i = 0; i < k; i++) {
        if (numOnes > 0) {
            res++;
            numOnes--;
        } else if (numZeros > 0) {
            numZeros--;
        } else if (numNegOnes > 0) {
            res--;
            numNegOnes--;
        }
    }        
    return res;
}