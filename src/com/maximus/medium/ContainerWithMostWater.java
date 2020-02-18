package com.maximus.medium;

public class ContainerWithMostWater {
    /*public int maxArea(int[] height) {
        int max = 0,cap = 0;
        for(int i = 0;i < height.length;i++) {
            for(int j = i + 1;j < height.length;j++) {
                cap = (j - i) * Math.min(height[i],height[j]);
                if(cap > max) max = cap;
            }
        }
        return max;
    }*/
    public int maxArea(int[] height) {
        int max = 0,left = 0,right = height.length - 1;
        while(left < right) {
            if(max < (right - left) * Math.min(height[left],height[right]))
                max = (right - left) * Math.min(height[left],height[right]);
            if(height[left] <= height[right]) left++;
            else right--;
        }
        return max;
    }
}
