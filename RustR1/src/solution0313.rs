/***
    维护一个优先队列，默认存入1，遍历1-n，每次遍历取出优先队列中的最小值，乘primes中的每个数，
    遍历n轮，每一轮选一个当前最小的
    维护一个set去重
 */
pub fn nth_super_ugly_number(n: i32, primes: Vec<i32>) -> i32 {
    use std::collections::HashSet;
    use std::collections::BinaryHeap;
    //用reverse实现小根堆
    use std::cmp::Reverse;

    let mut s = HashSet::new();
    let mut heap = BinaryHeap::new();
    let (mut t, mut min_t) = (0, 0);
    s.insert(1);
    heap.push(Reverse(1));
    for _i in 0..n {
        min_t = heap.pop().unwrap().0;
        for prime in &primes {
            t = prime * min_t;
            if !s.contains(&t) {
                s.insert(t);
                heap.push(Reverse(t))
            }
        }
    }

    min_t
}