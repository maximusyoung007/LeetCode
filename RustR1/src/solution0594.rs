//先排序，再使用左右指针，滑动窗口
pub fn find_lhs(nums: Vec<i32>) -> i32 {
    let mut res = 0;

    let mut ns = nums;
    ns.sort();

    let (mut begin, mut end) = (0, 0);

    for end in 0..ns.len() {
        while (ns[end] - ns[begin] > 1) {
            begin += 1;
        }

        //如果ns[end]-ns[begin]!=1,则表示区间内所有元素都相等
        if (ns[end] - ns[begin] == 1 && end - begin + 1 > res) {
            res = end - begin + 1;
        }
    }

    res as i32
}