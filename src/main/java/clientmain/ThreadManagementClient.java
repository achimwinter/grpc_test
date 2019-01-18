package clientmain;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import java.util.concurrent.TimeUnit;
import proto_generated.ThreadManagement;
import proto_generated.ThreadManagementServiceGrpc;
import proto_generated.ThreadManagementServiceGrpc.ThreadManagementServiceBlockingStub;


public class ThreadManagementClient {

  private final ManagedChannel channel;
  private final ThreadManagementServiceBlockingStub blockingStub;

  public ThreadManagementClient(final String host, final int port) {
    /* In the following statement, do NOT remove usePlaintext or set it to false. */
    channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext(true).build();
    blockingStub = ThreadManagementServiceGrpc.newBlockingStub(channel);
  }


  public static void main(final String[] args) throws InterruptedException {
    final ThreadManagementClient client = new ThreadManagementClient("localhost", 8888);
    try {
      client.createThread(1, "Hans", "Wurst");
      client.createThread(2, "Hans", "Wurst");
      client.createThread(3, "Hans", "Wurst");

      client.createThread(4, "Hans", "Wurst");
      client.createThread(5, "Peter", "Leberwurst");
      client.createThread(6, "Hans", "Wurst");

      client.createThread(7, "Hans", "Blutwurst");
      client.createThread(8, "Hans", "Wurst");
      client.createThread(9, "Hans", "Wurst");

      System.out.println(
          "------------------------------------SEARCH Thread by Id-----------------------");
      client.searchThreadById(5);
      System.out.println("------------------------------------LIST Threads-----------------------");
      client.listAll();
    } finally {
      client.shutdown();
    }
  }

  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  /**
   * Thread erzeugen
   */
  public void createThread(final Integer id, final String title, final String text) {
    final ThreadManagement.Thread Thread = ThreadManagement.Thread.newBuilder()
        .setId(id)
        .setTitle(title)
        .setText(text)
        .build();

    try {
      final ThreadManagement.CreateReply response = blockingStub.createThread(Thread);
      System.out.println(response.getThread() + " created");
    } catch (final StatusRuntimeException e) {
      e.printStackTrace();
    }
  }

  public void searchThreadById(int id) {
    final ThreadManagement.SearchRequestById request =
        ThreadManagement.SearchRequestById.newBuilder().setMessageId(id).build();

    try {
      final ThreadManagement.SearchResponse response = blockingStub.search(request);
      printResponse(response);
    } catch (final StatusRuntimeException e) {
      e.printStackTrace();
    }
  }

  public void listAll() {
    final ThreadManagement.SearchRequestById request =
        ThreadManagement.SearchRequestById.newBuilder().setMessageId( 0 ).build();

    try {
      final ThreadManagement.SearchResponse response = blockingStub.listAll(request);
      printResponse(response);
    } catch (final StatusRuntimeException e) {
      e.printStackTrace();
    }
  }

  private void printResponse(final ThreadManagement.SearchResponse response) {
    for (final ThreadManagement.Thread Thread : response.getThreadList()) {
      System.out.println(Thread);
    }
  }
}
