/*

Interface Counter {
  void inc();

  int getLastHourCount();
  int getLastMinuteCount();
  int getLastSecondCount();

}

*/

public final class WebRequests implements Counter {

  // Pointers
  private Integer minutePointer;
  private Integer secondPointer;

  // Constants
  private static final Integer millisecInHour = 3600000;
  private static final Integer millisecInMinute = 6000;
  private static final Integer millisecInSecond = 1000;


  // Linked List containing requests in the last hour
  private final LinkedList<Long> requestsReceived;

  // Constructor
  public WebRequests() {

    requestsReceived = new LinkedList<>();

    // -1 denotes that the pointer does not point to any element in the array
    // Either there are no elements or all the elements are outside the time range of the pointer
    minutePointer = -1;
    secondPointer = -1;

  }

  public void inc() {

    // Add the time stamp of latest request to the linked list
    requestsReceived.add(System.currentTimeMillis());

    // Set the minute and second pointer to the first element in the list
    if (requestsReceived.size() == 1) {
      minutePointer = 0;
      secondPointer = 0;
      // Set the minute and second pointer to the last (most recent) element in the list
    } else if (minutePointer == -1) {
      minutePointer = requestsReceived.size() - 1;
      secondPointer = requestsReceived.size() - 1;
      // Set the second pointer to the last element (most recent) in the list
    } else if (secondPointer == -1) {
      secondPointer = requestsReceived.size() - 1;
    }

    updateList();

  }


  // Updates the Linked List and updates the pointers
  private void updateList() {

    if (requestsReceived.size() == 0) {
      return;
    }

    // Remove requests from more than an hour ago
    while (System.currentTimeMillis() - requestsReceived.peek() > millisecInHour) {

      requestsReceived.remove();

      if (requestsReceived.size() == 0) {
        minutePointer = -1;
        secondPointer = -1;
        return;
      }

       if (minutePointer > 0) minutePointer--;
       if (secondPointer > 0) secondPointer--;

    }

    // Updates the minute pointer
    while (System.currentTimeMillis() - requestsReceived.get(minutePointer) > millisecInMinute) {
      minutePointer++;
      if (minutePointer == requestsReceived.size()) {
        minutePointer = -1;
        secondPointer = -1;
        return;
      }
    }


    // Updates the second pointer
    while (System.currentTimeMillis() - requestsReceived.get(secondPointer) > millisecInSecond) {
      secondPointer++;
      if (secondPointer == requestsReceived.size()) {
        secondPointer = -1;
        return;
      }
    }



  }



  public int getLastHourCount() {
    updateList();
    return requestsReceived.size();
  }

  public int getLastMinuteCount() {
    updateList();

    if (minutePointer == -1) {
      return 0;
    } else {
      return requestsReceived.size() - minutePointer;
    }

  }

  public int getLastSecondCount() {
    updateList();

    if (secondPointer == -1) {
      return 0;
    } else {
      return requestsReceived.size() - secondPointer;
    }

  }


}
