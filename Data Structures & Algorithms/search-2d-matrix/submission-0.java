class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
    	
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
    	    return false;
    	}
    	
    	int row=matrix.length;
    	int col = matrix[0].length;
    	
    	int low=0;
    	int high = (row*col)-1;
    	
    	while(low<=high) {
    		
    		int mid = low+(high-low)/2;
    		
    		int matRow = mid/col;
    		int matCol = mid%col;
    		
    		if(matrix[matRow][matCol]==target) {
    			return true;
    		}else if(matrix[matRow][matCol]>target) {
    			high = mid-1;
    		}else {
    			low = mid+1;
    		}
    		
    	}
    	
    	
    	return false;
        
    
    }
}
