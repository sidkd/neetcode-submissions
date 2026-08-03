class Solution {
    public boolean checkInclusion(String s1, String s2) {
            	boolean stringPermutation = false;
    	
    	Map<Character, Integer> s1FreqMap = new HashMap<Character, Integer>();
    	
    	for(int i=0;i<s1.length();i++) {
    		s1FreqMap.put(s1.charAt(i), s1FreqMap.getOrDefault(s1.charAt(i), 0)+1);
    	}
    	
    	int l=0,r=0;
    	
    	for(int j=0;j <= s2.length() - s1.length();j++) {
    		if(s1FreqMap.containsKey(s2.charAt(j))) {
                Map<Character, Integer> s2FreqMap = new HashMap<Character, Integer>();
    			l=j;
    			r=l+s1.length();
    			for(int k=l;k<r;k++) {
    				s2FreqMap.put(s2.charAt(k), s2FreqMap.getOrDefault(s2.charAt(k), 0)+1);
    			}
    			
    			if(s1FreqMap.equals(s2FreqMap)) {
    				stringPermutation = true;
    				break;
    			}else {
    				continue;
    			}
    			
    		}
    	}
    	
    	return stringPermutation;
    }
}