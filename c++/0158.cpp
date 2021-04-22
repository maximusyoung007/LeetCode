/**
 * 作者：SnowD
        链接：https://leetcode-cn.com/problems/read-n-characters-given-read4-ii-call-multiple-times/solution/cjian-ji-dai-ma-by-snowd-ud3e/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
//PS：我啪的一下就复制粘贴好了 =。=
class Solution0158 {
public:
    int read4(char * buf);
    char *buf4 = new char[4];
    int buf4Index = 0;
    int buf4Size = 0;
    int read(char *buf, int n) {
        int index = 0;
        while(index<n){
            while(buf4Index<buf4Size && index<n){
                buf[index++] = buf4[buf4Index++];
            }
            if(index<n){
                buf4Size = read4(buf4);
                buf4Index = 0;
                if(buf4Size==0) break;
            }
        }
        return index;
    }
};
