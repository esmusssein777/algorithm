package com.ligz.datastructure.array;

/**
 * 寻找数组的中心索引
 * @author ligz
 */
public class MidIndex {
	public static int pivotIndex(int[] nums) {
        if(nums.length == 0 || nums.length ==1){
            return -1;
        }
      
        for(int i = 1; i < nums.length; i++){
        	 int left = 0;
             int right = 0;
            for(int j = 0; j < i; j++){
                left += nums[j];
            }
            for(int j = i + 1; j < nums.length; j++){
                right += nums[j];
            }
            if(left == right){
                return i;
            }
        }
        return -1;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,7,3,6,5,6};
		int[] nums2 = {-1,-1,-1,0,1,1};
		System.out.println(MidIndex.pivotIndex(nums));
		System.out.println(MidIndex.pivotIndex(nums2));
	}
}
