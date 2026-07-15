class Solution {

     public String encode(List<String> strs) {
    	
    	String encodeString = strs.stream().map(s->s.length()+"#"+s).collect(Collectors.joining());
    	
		return encodeString;

    }

    public List<String> decode(String str) {
		
List<String> decodedStringsList = new ArrayList<String>();
    	
    	int i =0;
    	
    	while( i<str.length()) {
    		int j =i;
    		
    		while(str.charAt(j)!='#') {
    			j++;
    		}
    		
    		int wordLength = Integer.parseInt(str.substring(i,j));
    		
    		String word = str.substring(j+1,j+1+wordLength);
    		decodedStringsList.add(word);
            i = j + 1 + wordLength;
    	}
    	
    	return decodedStringsList;
    }
}
