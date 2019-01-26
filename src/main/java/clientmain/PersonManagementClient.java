package clientmain;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import proto_generated.PersonManagement;
import proto_generated.PersonManagement.SearchResponse;
import proto_generated.PersonManagementServiceGrpc;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class PersonManagementClient {

  private final ManagedChannel channel;
  private final PersonManagementServiceGrpc.PersonManagementServiceFutureStub futureStub;
  private final PersonManagementServiceGrpc.PersonManagementServiceBlockingStub blockingStub;

  public PersonManagementClient(final String host, final int port) {
    /* In the following statement, do NOT remove usePlaintext or set it to false. */
    channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext(true).build();
    futureStub = PersonManagementServiceGrpc.newFutureStub(channel);
    blockingStub = PersonManagementServiceGrpc.newBlockingStub(channel);
  }


  public static void main(final String[] args) throws InterruptedException {
    final PersonManagementClient client = new PersonManagementClient("localhost", 8888);
    try {
      client.createPerson(1, "Hans", "Wurst");
      client.createPerson(2, "Hans", "Wurst");
      client.createPerson(3, "Hans", "Wurst");

      client.createPerson(4, "Hans", "Wurst");
      client.createPerson(5, "Peter", "Leberwurst");
      client.createPerson(6, "Hans", "Wurst");

      client.createPerson(7, "Hans", "Blutwurst");
      client.createPerson(8, "Hans", "Wurst");
      client.createPerson(9, "Hans", "Wurst");

      System.out.println(
          "------------------------------------SEARCH Person-----------------------");
      client.searchPerson("Wurst");
      System.out.println(
          "------------------------------------LIST Persons-----------------------");
      client.listAll();
    } finally {
      client.shutdown();
    }
  }


  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  /**
   * Person erzeugen
   */
  public void createPerson(final Integer id, final String firstname, final String lastname) {
    final PersonManagement.Person Person = PersonManagement.Person.newBuilder()
        .setPersonId(id)
        .setFirstname(firstname)
        .setLastname(lastname)
        .build();

    try {
      final ListenableFuture<PersonManagement.CreateReply> response = futureStub.createPerson(Person);
      System.out.println(response.get().getPerson() + " created");
    } catch (final Exception e) {
      e.printStackTrace();
    }
  }

  public void searchPerson(String lastname) {
    final PersonManagement.SearchRequest request =
        PersonManagement.SearchRequest.newBuilder()
            .setLastname(lastname)
            .build();

    try {
      final PersonManagement.SearchResponse response = blockingStub.search(request);
      printResponse(response);
    } catch (final StatusRuntimeException e) {
      e.printStackTrace();
    }
  }

  public void listAll() {
    final PersonManagement.SearchRequest request =
        PersonManagement.SearchRequest.newBuilder()
            .setLastname( "" )
            .build();

    try {
      final Iterator<SearchResponse> response = blockingStub.listAll(request);
      response.forEachRemaining(this::printResponse);
      } catch (final StatusRuntimeException e) {
      e.printStackTrace();
    }
  }

  private void printResponse(final PersonManagement.SearchResponse response) {
      System.out.println(response.getPerson());
  }
}
