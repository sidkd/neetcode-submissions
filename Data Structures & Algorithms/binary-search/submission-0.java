class Solution {
    public int search(int[] nums, int target) {
        
        int low =0, high = nums.length-1;

        while(low<=high){
            int middle = (low+high)/2;

            if(nums[middle]==target){
                return middle;
            }else if(nums[middle]>target){
                high=middle-1;
            }else{
                low = middle+1;
            }
        }

        return -1;

    }
}
