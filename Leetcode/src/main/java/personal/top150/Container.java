package personal.top150;

public class Container {
    public static void main(String[] args) {
        Container c = new Container();
        System.out.println(c.maxArea(new int[]{1,2,4,3}));
    }
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int area = 0;
        int h;
        while(l < r) {
            h = Math.min(height[l], height[r]);
            if(h * (r - l) > area){
                area = h * (r - l);
            }
            if(height[l] < height[r]){
                l++;
            } else {
                r--;
            }
        }
        return area;
    }
}
