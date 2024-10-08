use std::collections::HashMap;

pub fn find_shortest_sub_array(nums: Vec<i32>) -> i32 {
    let (mut res, mut max_count) = (i32::MAX, 1);

    //key是当前遍历的数字
    //value 是当前数字的个数、第一个下标、最后一个小标组成的元组
    let mut counts_map: HashMap<i32, (i32, usize, usize)> = HashMap::new();

    for (i, &num) in nums.iter().enumerate()  {
        if !counts_map.contains_key(&num) {
            counts_map.insert(num, (1, i, i));
        } else {
            if let Some((count, _, end)) = counts_map.get_mut(&num) {
                *count += 1;
                if *count > max_count {
                    max_count = *count;
                }
                *end = i;
            }
        }
    }

    for (_, value) in &counts_map {
        //将一个元组value结构成三个值
        let (count, start, end) = *value;
        if count == max_count {
            if end - start + 1 < res as usize {
                res = (end - start + 1) as i32;
            }
        }
    }

    res
}