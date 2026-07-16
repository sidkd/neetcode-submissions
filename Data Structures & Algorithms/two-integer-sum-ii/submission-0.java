class Solution {
    public int[] twoSum(int[] numbers, int target) {
        		for(int i=0;i<numbers.length-1;i++) {
			int remaingDiff = target - numbers[i];
			for(int j=numbers.length-1;j>i;j--) {
				if(numbers[j]==remaingDiff) {
					return new int[] {i+1,j+1};
				}
			}
		}
		
			return new int[] {};
    }
}
