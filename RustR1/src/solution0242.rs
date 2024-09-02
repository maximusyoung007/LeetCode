pub fn is_anagram(s: String, t: String) -> bool {
    if s.len() != t.len() {
        return false;
    }

    let mut arr = [0; 26];
    let mut tc;
    // for (i, c) in s.chars().enumerate() {
    //     //先将字符转化为u32，计算ASCII码差值，再将ACSII码差值转为usize
    //     arr[(c as u32 - 'a' as u32) as usize] += 1;
    //
    //     tc = t.chars().nth(i).unwrap();
    //
    //     arr[(tc as u32 - 'a' as u32) as usize] -= 1;
    // }

    //用bytes更快
    for (i, c) in s.bytes().enumerate() {
        arr[(c - b'a') as usize] += 1;
        tc = t.bytes().nth(i).unwrap();
        arr[(tc - b'a') as usize] -= 1;
    }

    arr.iter().all(|&x| x == 0)
}