//计算和当前位不同的字符的个数,以及和当前位相同的个数，
// 若不同的个数大于等于相同的个数，则可以组成一个合法的字串
pub fn count_binary_substrings(s: String) -> i32 {
    let mut res = 0;
    //nums0记录0的个数，nums1记录1的个数
    let (mut nums0, mut nums1) = (0, 0);
    //存储上一个字符，不然会超时
    let mut last_char = ' ';

    for (i, c) in s.chars().enumerate() {
        if i == 0 {
            if c == '0' {
                nums0 += 1;
            } else {
                nums1 += 1;
            }
        } else {
            if c == '0' {
                if last_char == '1' {
                    nums0 = 1;
                } else if last_char == '0' {
                    nums0 += 1;
                }
                if nums1 >= nums0 {
                    res += 1;
                }
            } else if c == '1' {
                if last_char == '0' {
                    nums1 = 1;
                } else if last_char == '1' {
                    nums1 += 1;
                }
                if nums0 >= nums1 {
                    res += 1;
                }
            }
        }
        last_char = c;
    }

    res
}