class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
		
		List<List<String>> anagramList = new ArrayList<List<String>>();
		
		if(strs.length==0) {
			return new ArrayList<List<String>>();
		}
		
		
		for(int i = 0;i<=strs.length-1;i++) {
			
			String word = strs[i];
			
			char[] charArr = word.toCharArray();
			Arrays.sort(charArr);
			
			String sortedWord = new String(charArr);
			
			if(anagramMap.containsKey(sortedWord)) {
				List<String> groupWords = anagramMap.get(sortedWord);
				groupWords.add(word);
			}else {
				List<String> groupWords = new ArrayList<String>();
				groupWords.add(word);
				anagramMap.put(sortedWord, groupWords);
			}
		
		}
		
		for(String key : anagramMap.keySet()) {
			anagramList.add(anagramMap.get(key));
		}
		
		return anagramList;
    }
}
