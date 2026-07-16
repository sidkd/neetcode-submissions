class Solution {
    public int longestConsecutive(int[] nums) {
		
		
		
		int longestSubString = 1;
		int maxStreak = 1;
		
		if(nums.length==0) {
			return 0;
		}
		
		List<Integer> sortedDistinctList = Arrays.stream(nums).distinct().sorted().boxed().collect(Collectors.toList());
		
		for(int i =0 ; i<sortedDistinctList.size()-1;i++) {
			if(sortedDistinctList.get(i+1)-sortedDistinctList.get(i)==1) {
				longestSubString+=1;
			}else {
				maxStreak = Math.max(maxStreak, longestSubString);
				longestSubString=1;
				
			}
		}
		

			return Math.max(maxStreak, longestSubString);

        
    
    }
}
