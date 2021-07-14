public class Solution0492 {
    public int[] constructRectangle(int area) {
        int l = (int)Math.sqrt(area), w = (int)Math.sqrt(area);
        while (l * w != area) {
            if (l * w > area) {
                if (w > 1) {
                    w--;
                }
            }
            if (l * w < area) {
                l++;
            }
        }
        return new int[] {l, w};
    }
}
