class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
    	
    	int[][] positionSpeedPair = new int[position.length][2];
    	
    	Stack<Double> fleetStack = new Stack<Double>();
    	
    	for(int i=0;i<position.length;i++) {
    		positionSpeedPair[i][0] = position[i];
    		positionSpeedPair[i][1] = speed[i];
    	}
    	
    	Arrays.sort(positionSpeedPair, (a, b) -> Integer.compare(b[0], a[0]));
    	
    	for(int[] pair : positionSpeedPair) {
    		
    		double time =  ((double)(target-pair[0])/(double)pair[1]);
    		
    		fleetStack.push(time);
    		
    		if(fleetStack.size()>=2 &&
    				fleetStack.peek()<=fleetStack.get(fleetStack.size()-2)) {
    			fleetStack.pop();
    		}
    	}
    	
    	
		return fleetStack.size();
        
    
    }
}
