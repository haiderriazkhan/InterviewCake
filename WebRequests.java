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
    minutePointer = -1;
    secondPointer = -1;
  }

  public void inc() {

    // Add the time stamp of latest request to the linked list
    requestsReceived.add(System.currentTimeMillis());
    minutePointer++;
    secondPointer++;
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
      if (minutePointer > -1) minutePointer--;
      if (secondPointer > -1) secondPointer--;

    }

    // Updates the minute pointer
    if (minutePointer > -1) {

      while (System.currentTimeMillis() - requestsReceived.get(minutePointer) > millisecInMinute) {
        minutePointer--;
        if (minutePointer == -1) {
          secondPointer = -1;
          return;
        }
      }

    }
    // Updates the second pointer
    if (secondPointer > -1) {

      while (System.currentTimeMillis() - requestsReceived.get(secondPointer) > millisecInSecond) {
        secondPointer--;
        if (secondPointer == -1) {
          return;
        }
      }

    }

  }



  public int getLastHourCount() {
    updateList();
    return requestsReceived.size();
  }

  public int getLastMinuteCount() {
    updateList();
    return minutePointer + 1;
  }

  public int getLastSecondCount() {
    updateList();
    return secondPointer + 1;
  }


}
