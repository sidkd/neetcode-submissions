class Solution {
    public int lengthOfLongestSubstring(String s) {
            	int longestSubStringLength=0;
    	

        for (int i = 0; i < s.length(); i++) {
            Set<Character> nonRepeatSet = new HashSet<>();

            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);

                if (nonRepeatSet.contains(c)) {
                    break;
                }

                nonRepeatSet.add(c);
                longestSubStringLength = Math.max(longestSubStringLength, nonRepeatSet.size());
            }
        }
    	
		return longestSubStringLength;
    }
}
