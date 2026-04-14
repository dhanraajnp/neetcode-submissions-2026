class Solution {
    public int maxArea(int[] height) {
        
        int low = 0;
        int high = height.length-1;
        int maxArea = 0;
        
        while(low < high){
            
            int minVal = Math.min(height[low], height[high]);
            
            int temp = (high-low) * minVal;
            maxArea = Math.max(temp, maxArea);
            
            
            if(height[low] < height[high]){
                low++;    
            }else{
                high--;
            }
            
        }
        
        return maxArea;
    }
}