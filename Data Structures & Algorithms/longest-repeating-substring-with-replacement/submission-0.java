class Solution {
    public int characterReplacement(String s, int k) {
        
    	
    	int l=0;
    	int maxf=0;
    	int res=0;
    	
    	HashMap<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
    	
    	for(int r=0;r<s.length();r++) {
    		
    		frequencyMap.put(s.charAt(r), frequencyMap.getOrDefault(s.charAt(r), 0)+1);
    		maxf = Math.max(maxf, frequencyMap.get(s.charAt(r)));
    		
    		while((r-l+1)-maxf>k) {
    			frequencyMap.put(s.charAt(l), frequencyMap.get(s.charAt(l))-1);
    			l++;
    		}
    		
    		res = Math.max(res, r-l+1);
    		
    	}
    	
		return res;
        
    
    }
}
