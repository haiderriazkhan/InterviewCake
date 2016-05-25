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
  private final Integer minutePointer;
  private final Integer secondPointer;

  // Constant
  private static final Integer millisecInHour = 3600000;

  // Linked List containing requests in the last hour
  private final LinkedList<Long> requestsReceived;

  // Constructor
  public WebRequests() {
    requestsReceived = new LinkedList<>();
    minutePointer = 0;
    secondPointer = 0;
  }

  public void inc() {

    // Add the time stamp of latest request to the linked list
    requestsReceived.add(System.currentTimeMillis());
    updateList();

  }

  // Remove requests from more than an hour ago
  // Adjusts pointers
  private void updateList() {

    if (requestsReceived.size() == 0) {
      return;
    }

    while (System.currentTimeMillis() - requestsReceived.peek() > millisecInHour) {
      requestsReceived.remove();

      if (requestsReceived.size() == 0) {
        minutePointer = 0;
        secondPointer = 0;
        break;
      }
      minutePointer--;
      secondPointer--;

    }

  }


  public int getLastHourCount() {
    updateList();
    return requestsReceived.size();
  }

  public int getLastMinuteCount() {

    if (requestsReceived.size() == 0) {
      return 0;
    } else if (requestsReceived.size() == minutePointer) {
      return minutePointer;
    }

    while (System.currentTimeMillis() - requestsReceived.get(minutePointer) < millisecInMinute) {
      minutePointer++;
    }
    return minutePointer;
  }

  public int getLastSecondCount() {

    if (requestsReceived.size() == 0) {
      return 0;
    } else if (requestsReceived.size() == secondPointer) {
      return secondPointer;
    }

    while (System.currentTimeMillis() - requestsReceived.get(secondPointer) < millisecInSecond) {
      secondPointer++;
    }
    return secondPointer;
  }


}
