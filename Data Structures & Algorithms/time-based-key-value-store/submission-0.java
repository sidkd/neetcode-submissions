class TimeMap {

	
	public class Entry{
		String value;
		int timestamp;
		
		public Entry(int timeStamp, String value) {
			this.value=value;
			this.timestamp = timeStamp;
		}
	}
	
	Map<String, List<Entry>> timeStore;

	
    public TimeMap() {
        this.timeStore =  new HashMap<String, List<Entry>>();
    }
    
    public void set(String key, String value, int timestamp) {
    	
    	Entry entry = new Entry(timestamp, value);
    	
    	List<Entry> entryList = new ArrayList<TimeMap.Entry>();
    	
    	if(this.timeStore.containsKey(key)) {
    		entryList = this.timeStore.get(key);
    		entryList.add(entry);
    		
    		this.timeStore.put(key,entryList);
    		
    	}else {
    		entryList.add(entry);
    		this.timeStore.put(key,entryList);
    	}
    	
    }
    
    public String get(String key, int timestamp) {
    	String value="";
    	
        if(!this.timeStore.containsKey(key)) {
        	return value;
        }else {
        	List<Entry> entryList = this.timeStore.get(key);
        	
        	
        	int high=entryList.size()-1, low=0;

        	while(low<=high) {
        		int mid = low+(high-low)/2;
        		
        		if(entryList.get(mid).timestamp==timestamp) {
            		value = entryList.get(mid).value;
        			 break;
        		}else if(entryList.get(mid).timestamp>=timestamp) {
        			high=mid-1;
        		}else {
            		value = entryList.get(mid).value;
        			low=mid+1;
        			
        		}
        	}
        	

        }
        
    	return value;
    }


}
