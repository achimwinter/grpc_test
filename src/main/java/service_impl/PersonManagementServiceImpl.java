package service_impl;

import io.grpc.stub.StreamObserver;
import proto_generated.PersonManagement;
import proto_generated.PersonManagement.Person;
import proto_generated.PersonManagement.SearchResponse;
import proto_generated.PersonManagementServiceGrpc.PersonManagementServiceImplBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonManagementServiceImpl extends PersonManagementServiceImplBase
{
  private Map<String, List<Person>> persons;

  public PersonManagementServiceImpl( )
  {
    super( );
    this.persons = new HashMap<>( );
  }

  @Override
  public void createPerson( Person request,
      StreamObserver<PersonManagement.CreateReply> responseObserver )
  {

    List<Person> personList = persons.get( request.getLastname() );

    if (personList == null) {
      personList = new ArrayList<>();
    }


    personList.add(request);

    persons.put(request.getLastname(), personList);

    PersonManagement.CreateReply reply =
        PersonManagement.CreateReply.newBuilder( ).setPerson( request ).build( );

    responseObserver.onNext( reply );
    responseObserver.onCompleted( );
  }

  public void search( PersonManagement.SearchRequest request,
      StreamObserver<PersonManagement.SearchResponse> responseObserver )
  {
    String pattern = request.getLastname( );

    List<Person> personList = persons.get( pattern );

    PersonManagement.SearchResponse reply;

    if ( pattern != null )
    {
      reply = PersonManagement.SearchResponse.newBuilder( ).setPerson(personList.get(0)).build( );
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

    for ( Map.Entry<String, List<Person>> persons : persons.entrySet( ) )
    {
      persons.getValue().forEach(p -> responseObserver.onNext(SearchResponse.newBuilder().setPerson(p).build()));
    }

    responseObserver.onCompleted( );
  }
}
