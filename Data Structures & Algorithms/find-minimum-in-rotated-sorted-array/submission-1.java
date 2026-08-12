class Solution {
    public int findMin(int[] nums) {
        
    	int low =0; int high=nums.length-1;
    	
    	while(low<high) {
    		int middle = low+(high-low)/2;
    		
    		if(nums[middle]>nums[high]) {
    			low = middle+1;
    		}else {
    			high=middle;
    		}
    	}
    	
    	return nums[low];
    	
    

    }
}
