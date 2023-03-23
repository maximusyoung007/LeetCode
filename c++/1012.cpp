

/**
 * dp含义
 * n=234,第一位（最高位）填的1，那么继续递归，后面就可以随便填，所以dp[1][2]就表示前面填了一个1（对应的mask=2),从第二位开始，随便填的方案数
 * dp数组的行表示从左到右第几位，dp的列表示这个位填的数字，n=234,dp[0][2]表示数字的百位填的数字是1，dp[0][2]的值表示以数字1开头的百位数对应的可行方案数
 * 前三位取值集合mask=1110,对应的集合是{1，2，3}，132XXX和123XXX的第4及之后的可能性是一样的都为dp[3][14]
*/