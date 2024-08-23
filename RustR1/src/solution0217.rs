use std::collections::HashSet;
pub fn contains_duplicate(nums: Vec<i32>) -> bool {
    let mut set: HashSet<i32> = HashSet::new();

    for i in &nums {
        set.insert(*i);
    }

    nums.len() == set.len()
}