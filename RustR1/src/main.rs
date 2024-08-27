// use crate::solution0217::contains_duplicate;
// use crate::solution0697::find_shortest_sub_array;

// use crate::solution0594::find_lhs;

use crate::solution0313::nth_super_ugly_number;

// mod solution0697;
// mod solution0594;
mod solution0313;
// mod solution0217;

fn main() {
    println!("Hello, world!");

    let v = vec![2,7,13,19];
    println!("{}", nth_super_ugly_number(12, v));
    // let v = vec![1,2,3,4];
    // let v = vec![1,1,1,1];
    // println!("{}", find_lhs(v))
    // let v = vec![1,2,2,3,1];
    // let v = vec![0];
    // let v = vec![1,3,2,2,3,1];
    // println!("{}",find_shortest_sub_array(v));
    // println!("{}", contains_duplicate(v))
    // println!("{}", find_shortest_sub_array(v));
}
