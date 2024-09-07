pub fn is_isomorphic(s: String, t: String) -> bool {
    if s.len() != t.len() {
        return false;
    }

    use std::collections::HashMap;

    //key是s中的字符，value是t中对应的字符，s再次出现时，判断s对应的t是否等于value
    let mut map = HashMap::new();
    let mut map2 = HashMap::new();

    let mut tc;
    for (i, c) in s.bytes().enumerate() {
        tc = t.bytes().nth(i).unwrap();

        if !map.contains_key(&c) {
            map.insert(c, tc);
        } else {
            if *map.get(&c).unwrap() != tc {
                return false;
            }
        }

        if !map2.contains_key(&tc) {
            map2.insert(tc, c);
        } else {
            if *map2.get(&tc).unwrap() != c {
                return false;
            }
        }
    }

    true
}