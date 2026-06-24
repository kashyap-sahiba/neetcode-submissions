class Solution {
    public int[] productExceptSelf(int[] nums) {
      int len = nums.length;
      int[] output = new int[len];

      output[0] = 1;

      for(int i = 1; i < len; i++){
            output[i] = output[i-1] * nums[i-1];
      }

      int right_product = 1;

      for(int i = len-1; i>=0; i--){
        output[i]= right_product * output[i];

        right_product = right_product * nums[i];
      }

      return output;  
    }
}  
