package fakru.lld.logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

public class MetaverseLog implements LogClient {

  Map<String, Process> processMap;
  TreeMap<String, Long> processIdVsStartTime;
  Random random = new Random();
  private static int pollCount = 1;

  public MetaverseLog() {
    this.processMap = new HashMap<>();
    this.processIdVsStartTime = new TreeMap<>(
        (pid1, pid2) -> (int) (processMap.get(pid1).getStartTime() - processMap.get(pid2)
            .getStartTime()));
  }

  public Map<String, Process> getProcessMap() {
    return this.processMap;
  }

  public SortedMap<String, Long> getProcessIdVsStartTime() {
    return this.processIdVsStartTime;
  }

  @Override
  public void start(String processId) {
    processMap.put(processId, new Process(processId, System.currentTimeMillis()));
    processIdVsStartTime.put(processId, System.currentTimeMillis());
  }

  @Override
  public void end(String processId) {
    int randTime = random.nextInt() % 100;
    while (randTime < 0) {
      randTime = random.nextInt() % 100;
    }
    processMap.get(processId).setEndTime(System.currentTimeMillis() + randTime);
  }

  @Override
  public String poll() {
    String pid = processIdVsStartTime.firstEntry().getKey();
    Process process = processMap.get(pid);
    if (processMap.get(pid).getEndTime() != -1) {
      System.out.println(pollCount++ + " " +
          process.getProcessId() + " started at " + process.getStartTime() + " and ended at "
          + process.getEndTime());
      processIdVsStartTime.remove(pid);
      processMap.remove(pid);
      return pid;
    }
    return null;
  }
}