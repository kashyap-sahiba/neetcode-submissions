class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int maxWater = 0;

        while(left < right){
            int minHeight = Math.min(heights[left],heights[right]);
            int length = right - left;
            int currentWater = length * minHeight;
            maxWater = Math.max(maxWater,currentWater);

            if(heights[right]>heights[left]){
                left++;
            }else{
                right--;
            }
        }

        return maxWater;
        
    }
}
