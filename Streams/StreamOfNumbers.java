package Streams;
import java.util.*;

public class StreamOfNumbers {

  public void median(Scanner in) throws NoSuchElementException {

    // Read in the length of the stream
    int streamLength = in.nextInt();

    if (streamLength == 0) return;

    int firstInt = in.nextInt();

    if (streamLength == 1) {
      System.out.printf("%.1f %n",  (float) firstInt );
      return;
    }

    int currInt = in.nextInt();

    System.out.printf("%.1f %n",  ((float) currInt+firstInt)/2 );

    // Initialize the heaps
    Queue<Integer> minHeap = new PriorityQueue<>(streamLength/2 +1);
    Queue<Integer> maxHeap = new PriorityQueue<>(streamLength/2 +1, Collections.reverseOrder());



    // For the first two elements : Add smaller one to the maxHeap and bigger one to the minHeap.
    if (firstInt > currInt) {
      minHeap.add(firstInt);
      maxHeap.add(currInt);
    } else {
      minHeap.add(currInt);
      maxHeap.add(firstInt);
    }

    int minCounter = 1;
    int maxCounter = 1;
    int totalNumbersRead = 2;

    while (streamLength > totalNumbersRead) {
      currInt = in.nextInt();
      streamLength++;

      // If the current integer is smaller than the maxHeap root add it to maxHeap,
      // else add it to minHeap
      if (currInt < maxHeap.peek()) {
        maxHeap.add(currInt);
        maxCounter++;
      } else {
        minHeap.add(currInt);
        minCounter++;
      }

      // Balance the heaps if required
      if (minCounter - maxCounter > 1) {
        maxHeap.add(minHeap.poll());
        maxCounter++;
        minCounter--;
      } else if (maxCounter - minCounter > 1) {
        minHeap.add(maxHeap.poll());
        minCounter++;
        maxCounter--;
      }

      // Print the median number

      if (minCounter == maxCounter) {
        System.out.printf("%.1f %n",  ((float) minHeap.peek()+maxHeap.peek())/2 );
      } else if (minCounter > maxCounter) {
        System.out.printf("%.1f %n",  (float) minHeap.peek() );
      } else {
        System.out.printf("%.1f %n",  (float) maxHeap.peek() );
      }

    }


  }

  public void mean(Scanner in) throws NoSuchElementException {

    // Read in the length of the stream
    int streamLength = in.nextInt();

    int sum  = 0;
    int numCounter = 0;

    while (streamLength > numCounter) {
      sum += in.nextInt();
      numCounter++;
      System.out.printf("%.1f %n",  (float) sum/numCounter );
    }

  }



}
