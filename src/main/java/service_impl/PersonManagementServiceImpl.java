package service_impl;

import io.grpc.stub.StreamObserver;
import java.util.HashMap;
import java.util.Map;
import proto_generated.PersonManagement;
import proto_generated.PersonManagement.Person;
import proto_generated.PersonManagement.SearchResponse;
import proto_generated.PersonManagementServiceGrpc.PersonManagementServiceImplBase;

public class PersonManagementServiceImpl extends PersonManagementServiceImplBase
{
  private Map<String, PersonManagement.Person> persons;

  public PersonManagementServiceImpl( )
  {
    super( );
    this.persons = new HashMap<>( );
  }

  @Override
  public void createPerson( Person request,
      StreamObserver<PersonManagement.CreateReply> responseObserver )
  {
    addPerson(request);

    PersonManagement.CreateReply reply =
        PersonManagement.CreateReply.newBuilder( ).setPerson( request ).build( );

    responseObserver.onNext( reply );
    responseObserver.onCompleted( );
  }

  private void addPerson(Person person) {

    if ( persons == null )
    {
      persons = new HashMap<>( );
    }

    persons.put( person.getLastname(), person );
  }


  public void search( PersonManagement.SearchRequest request,
      StreamObserver<PersonManagement.SearchResponse> responseObserver )
  {
    String pattern = request.getLastname( );

    Person person = persons.get( pattern );

    PersonManagement.SearchResponse reply;

    if ( person != null )
    {
      reply = PersonManagement.SearchResponse.newBuilder( ).setPerson(person).build( );
    }
    else
    {
      reply = PersonManagement.SearchResponse.newBuilder( ).build( );
    }

    responseObserver.onNext( reply );
    responseObserver.onCompleted( );
  }

  @Override
  public void listAll( PersonManagement.SearchRequest request,
      final StreamObserver<PersonManagement.SearchResponse> responseObserver )
  {

    for ( Map.Entry<String, Person> person : persons.entrySet( ) )
    {
      responseObserver.onNext(SearchResponse.newBuilder().setPerson(person.getValue()).build());
    }

    responseObserver.onCompleted( );
  }
}
