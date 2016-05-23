public class StreamOfNumbers {

  public void median(Scanner in) {

    try {
      int streamLength = in.nextInt();
    } catch (NoSuchElementException e) {
      return;
    }


    if (streamLength == 0) return;

    int firstInt = in.nextInt();

    if (streamLength == 1) {
      System.out.printf("%.1f \n",  (float) currInt );
      return;
    }

    int currInt = in.nextInt();

    Queue<Integer> minHeap = new PriorityQueue<>(streamLength/2 +1);
    Queue<Integer> maxHeap = new PriorityQueue<>(streamLength/2 +1 , new Comparator<Integer>() {
      public int compare(int one , int two) {
        if (one == two) {
          return 0;
        } else {
          one > two ? -1 : 1;
        }
      }
    });

    // For the first two elements : Add smaller one to the maxHeap and bigger one to the minHeap.
    if (firstInt > currInt) {
      minHeap.add(firstInt);
      maxHeap.add(currInt);
    } else {
      minHeap.add(currInt);
      maxHeap.add(firstInt);
    }


  }





}
