public class Love {
	
	
	public class Love_Rectangle {
		
		// Coordinates of the lower left corner. 
		int x;
		int y;
		// Width and height of the rectangle. 
		int width;
		int height;
		
	}
	
	
	// This method has a lot of redundancy. Can be refactored to be much cleaner. 
	public Love_Rectangle strength_of_love(Love_Rectangle lover_one , Love_Rectangle lover_two) {
		
		Map.Entry<Integer, Integer> broader_rec;
		List<Integer> slimmer_rec;
		Map.Entry<Integer, Integer> longer_rec;
		List<Integer> shorter_rec;
		
		if (lover_one.width  > lover_two.width ) {
			
			broader_rec = new AbstractMap.SimpleEntry<Integer , Integer>(lover_one.x , lover_one.x + lover_one.width);
			slimmer_rec = Arrays.asList(lover_two.x ,  lover_two.x + lover_two.width);
						
		}
		else {
			
			slimmer_rec = Arrays.asList(lover_one.x , lover_one.x + lover_one.width);
			broader_rec = new AbstractMap.SimpleEntry<Integer , Integer>(lover_two.x , lover_two.x + lover_two.width);
			
		}
		
		if (lover_one.height > lover_two.height) {
			
			longer_rec = new AbstractMap.SimpleEntry<Integer , Integer>(lover_one.y , lover_one.y + lover_one.height);
			shorter_rec = Arrays.asList(lover_two.y , lover_two.y + lover_two.height);
		}
		else {
			
			shorter_rec = Arrays.asList(lover_one.y , lover_one.y + lover_one.height);
			longer_rec  = new AbstractMap.SimpleEntry<Integer , Integer>(lover_two.y , lover_two.y + lover_two.height);
			
		}
		
		
		
		Love_Rectangle love_strength = new Love_Rectangle();
		love_strength.width = 0;
		love_strength.height = 0;
		love_strength.x = -1;
		love_strength.y = -1;
		
		
		List<Integer> intersections = new ArrayList<Integer>();
		
		
		for (int x : slimmer_rec) {
			
			if (x >= broader_rec.getKey() && x <= broader_rec.getValue()) intersections.add(x);
			
		}
		
		if (intersections.size() == 2) { 
			
			love_strength.width = slimmer_rec.get(1) - slimmer_rec.get(0);
			love_strength.x = slimmer_rec.get(0);
		}
		else if (intersections.size() == 0) {
			
			return love_strength;
			
		}
		
		boolean marked = true;
		for (int y : shorter_rec) {
			
			marked = false;
			if (y >= longer_rec.getKey() && y <= longer_rec.getValue()) intersections.add(y);
			
		}
		
		if (intersections.size() == 4) {
			
			love_strength.height = shorter_rec.get(1) - shorter_rec.get(0);
			love_strength.y = shorter_rec.get(0);
			
			return love_strength;
			
		}
		else if (marked) {
			
			love_strength.width = 0;
			love_strength.x = -1;
			return love_strength;
			
		}
		
		
		if (love_strength.width == 0) {
			
			if (intersections.get(0) == slimmer_rec.get(0)) {
				
				love_strength.x = slimmer_rec.get(0);
				love_strength.width = broader_rec.getValue() - love_strength.x;
			}
			else {
				
				love_strength.x = broader_rec.getKey();
				love_strength.width = intersections.get(0) - love_strength.x;
				
			}
			
		}
		
		if (love_strength.height == 0) {
			
			if (intersections.get(1) == shorter_rec.get(0)) {
				
				love_strength.y = shorter_rec.get(0);
				love_strength.height = longer_rec.getValue() - love_strength.y;
				
			}
			else {
				
				love_strength.y = longer_rec.getKey();
				love_strength.height = intersections.get(1) - love_strength.y;
				
			}
			
			
		}
		
		return love_strength;
		
	}
	
	
	
}
