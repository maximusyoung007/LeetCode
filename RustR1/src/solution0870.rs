
use std::collections::VecDeque;

pub fn advantage_count(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
    //用小根堆方法超时
    //用一个小根堆存nums1的值，优先将堆里比较小的数放到结果数组中
    //如果小根堆中最大值都小于nums2的值，则选取不大于nums2的值中最小的
    // use std::collections:: BinaryHeap;
    // //用reverse实现小根堆
    // use std::cmp::Reverse;
    // use std::collections::VecDeque;
    //
    // let mut res = Vec::new();
    // let mut heap = BinaryHeap::new();
    // let mut queue = VecDeque::new();
    // for num in &nums1 {
    //     heap.push(Reverse(*num));
    // }
    //
    // let mut peek_temp;
    // let mut is_large: bool = false;
    // for i in 0..nums2.len() {
    //     while !queue.is_empty() {
    //         peek_temp = queue.pop_back().unwrap();
    //         if (peek_temp > nums2[i]) {
    //             heap.push(Reverse(peek_temp));
    //         } else {
    //             queue.push_back(peek_temp);
    //             break;
    //         }
    //     }
    //
    //     while !heap.is_empty() {
    //         peek_temp = heap.pop().unwrap().0;
    //         if peek_temp > nums2[i] {
    //             res.push(peek_temp);
    //             is_large = true;
    //             break;
    //         } else {
    //             queue.push_back(peek_temp);
    //         }
    //     }
    //
    //     if (!is_large) {
    //         if !queue.is_empty() {
    //             peek_temp = queue.pop_front().unwrap();
    //             res.push(peek_temp);
    //         }
    //     } else {
    //         is_large = false;
    //     }
    //
    //
    // }
    //
    // res
}