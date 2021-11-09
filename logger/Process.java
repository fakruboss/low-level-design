package fakru.lld.logger;

public class Process {

  private final String processId;
  private final long startTime;
  private long endTime;

  public Process(String processId, long startTime) {
    this.processId = processId;
    this.startTime = startTime;
    this.endTime = -1;
  }

  public String getProcessId() {
    return processId;
  }

  public long getStartTime() {
    return startTime;
  }

  public long getEndTime() {
    return endTime;
  }

  public void setEndTime(long endTime) {
    this.endTime = endTime;
  }

  @Override
  public String toString() {
    return "Process{" +
        "processId='" + processId + '\'' +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        '}';
  }
}