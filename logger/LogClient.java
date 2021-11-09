package fakru.lld.logger;

public interface LogClient {

  void start(String processId);

  void end(String processId);

  String poll();
}