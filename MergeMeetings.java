public class MergeMeetings {
	
	// Merge Meeting times that overlap. 
	public List<Map.Entry<Integer,Integer>> merge_times(List<Map.Entry<Integer, Integer>> calendar) {
		
		// We will use a TreeMap to sort the meeeting times by their start time. 			
		
		SortedMap<Integer, Integer> Sorted_Meetings = new TreeMap<Integer,Integer>();
		
		for (Map.Entry<Integer, Integer> x : calendar) {
			
			Sorted_Meetings.put(x.getKey() , x.getValue());
			
		}
		
		// Iterate through the TreeMap and merge meetings that overlap and put them in the output List. 
		
		List<Map.Entry<Integer, Integer>> Merged_Meetings = ArrayList<AbstractMap.SimpleEntry<Integer,Integer>>();
		
		Merged_Meetings.add(Sorted_Meetings.pollFirstEntry());
		
		int index = 0;
		
		for (Map.Entry<Integer, Integer> meeting : Sorted_Meetings.entrySet()) {
			
			Integer start_time = meeting.getKey();
  			Integer finish_time = meeting.getValue();
  			
  			Map.Entry<Integer, Integer> prev_meeting = Merged_Meetings.get(index);
  			
  			Integer prev_start_time = prev_meeting.getKey();
  			Integer prev_finish_time = prev_meeting.getValue();
  			
  			if (start_time <= prev_finish_time) {
  				
  				if (finish_time > prev_finish_time) {
  					
  					Merged_Meetings.set(index, new AbstractMap.SimpleEntry<Integer,Integer>(prev_start_time, finish_time));
  					
  				}
  				
  				continue;
  				
  			}
  			
			Merged_Meetings.add(++index, meeting);
			
		}
		
		return Merged_Meetings;
  	  
  	}



}
