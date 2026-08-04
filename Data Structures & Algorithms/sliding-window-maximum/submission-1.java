class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
		
		int l=0,r=0;
		r=k-1;
		
		int[] result = new int[nums.length-k+1];
		
		while(r<nums.length) {
		int maxElementInWindow=Integer.MIN_VALUE;
			for(int i=l;i<=r;i++) {
				maxElementInWindow = Math.max(nums[i], maxElementInWindow);
			}
			result[l]=maxElementInWindow;
			
			l++;r++;
		}
		
		return result;
        
    
    }
}
