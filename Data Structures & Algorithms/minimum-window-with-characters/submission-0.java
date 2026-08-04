class Solution {
    public String minWindow(String s, String t) {
     
    	
    	String shortestString = "";
    	
    	int need=0, formed=0;
    	
    	if (t.length() > s.length()) {
    	    return "";
    	}
    	
    	Map<Character, Integer> tFreqMap = new HashMap<Character, Integer>();
    	
    	Map<Character, Integer> sFreqMap = new HashMap<Character, Integer>();
    	
    	for(int i=0;i<t.length();i++) {
    		if(!tFreqMap.containsKey(t.charAt(i))) {
    			need++;
    		}
    		tFreqMap.put(t.charAt(i), tFreqMap.getOrDefault(t.charAt(i),0)+1);
    	}
    	
    	int l=0,r=0;
    	
    	for( r=0;r<s.length();r++) {
    		sFreqMap.put(s.charAt(r), sFreqMap.getOrDefault(s.charAt(r), 0) + 1);

    		if(tFreqMap.containsKey(s.charAt(r)) && 
    				tFreqMap.get(s.charAt(r))==sFreqMap.get(s.charAt(r))) {
    			formed++;
    		}
    		
    		while(need==formed) {
    			
    			if(tFreqMap.containsKey(s.charAt(l)) && sFreqMap.get(s.charAt(l))>=tFreqMap.get(s.charAt(l))) {
    				int window = r-l+1;
    				
    				String extractString = s.substring(l,r+1);
    				
    				if(shortestString.isEmpty() || shortestString.length()>extractString.length()) {
    					shortestString = extractString;
    				}
    			}
    			
    			sFreqMap.put(s.charAt(l), sFreqMap.getOrDefault(s.charAt(l), 0) - 1);
    			
    			
    			
    			if(tFreqMap.containsKey(s.charAt(l)) && sFreqMap.get(s.charAt(l))<tFreqMap.get(s.charAt(l))) {
    				formed--;
    			}
    			l++;
    			
    		}
    				
    	}
    	
		return shortestString;
        
        
    }
}
