class Solution {
    public int[] topKFrequent(int[] nums, int k) {
		
		Map<Integer, Long> frequncyMap = new HashMap<Integer, Long>();
		
		frequncyMap = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
		
		List<Map.Entry<Integer, Long>> entryList = new ArrayList<>(frequncyMap.entrySet());
		
		Collections.sort(entryList, Map.Entry.comparingByValue(Comparator.reverseOrder()));
		
		int[] frqEleArr = new int[k];
		
		for(int i = 0; i < k; i++) {
			frqEleArr[i] = entryList.get(i).getKey();
		}
		return frqEleArr;

    }
}