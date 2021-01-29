import java.util.ArrayList;
import java.util.List;

public class Solution0068 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> t = new ArrayList<>();
        List<String> tt = new ArrayList<>();
        List<String> result = new ArrayList<>();
        int i = 0, lenTT = 0;
        while (i < words.length) {
            tt.add(words[i]);
            lenTT += words[i].length() + 1;
            i++;
            if(lenTT - 1 > maxWidth) {
                tt.remove(tt.size() - 1);
                List<String> rt = new ArrayList<>();
                for(String ts : tt) {
                    rt.add(ts);
                }
                t.add(rt);
                i--;
                lenTT = 0;
                tt.clear();
            }
        }
        if(!tt.isEmpty()) {
            t.add(tt);
        }

        for (i = 0; i < t.size(); i++) {
            List<String> temp = t.get(i);
            String r = "";
            if(i == t.size() - 1) {
                for(int j = 0; j < temp.size(); j++) {
                    if(j != temp.size() - 1) {
                        r += temp.get(j) + " ";
                    } else {
                        r += temp.get(j);
                    }
                }
            }
            else {
                int len = 0;
                int size = temp.size();
                for (String s : temp) {
                    len += s.length();
                }
                int blank = 0, rest = 0;
                if(size != 1) {
                    blank = (maxWidth - len) / (size - 1);
                    rest = (maxWidth - len) % (size - 1);
                } else {
                    blank = (maxWidth - len) / size;
                }
                String blank2 = "";
                for(int j = 0; j < blank; j++) {
                    blank2 += " ";
                }
                for(int j = 0; j < temp.size(); j++) {
                    if(j != temp.size() - 1) {
                        r += temp.get(j) + blank2;
                        if(rest > 0) {
                            r += " ";
                            rest--;
                        }
                    }
                    else {
                        r += temp.get(j);
                    }
                }
            }
            if(maxWidth > r.length()) {
                int minus = maxWidth - r.length();
                for(int k = 0; k < minus; k++) {
                    r += " ";
                }
            }
            result.add(r);
        }
        return result;
    }
}
