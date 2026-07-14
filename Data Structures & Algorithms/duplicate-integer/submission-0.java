class Solution {
    public boolean hasDuplicate(int[] nums) {
        List<Integer> elementList = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(elementList.contains(nums[i])){
                return true;
            }else{
                elementList.add(nums[i]);
            }
        }
        return false;
    }
}