package fakru.lld.logger;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MetaverseDemo {

  public static void main(String[] args) throws InterruptedException {
    MetaverseLog log = new MetaverseLog();
    Random random = new Random();
    Set<String> pidList = new HashSet<>();
    int n = 250000;
    for (int i = 0; i < n; ++i) {
      String randomPid = String.valueOf((random.nextInt() % n));
      while (!pidList.add(randomPid)) {
        randomPid = String.valueOf((random.nextInt() % n));
      }
      pidList.add(randomPid);
      log.start(randomPid);
      log.end(randomPid);
//      System.out.println(log.getProcessMap().size() + " => " + log.getProcessMap());
//      System.out.println(
//          log.getProcessIdVsStartTime().size() + " => " + log.getProcessIdVsStartTime());
      Thread.sleep(1);
    }
    while (!pidList.isEmpty()) {
      pidList.remove(log.poll());
    }
  }
}