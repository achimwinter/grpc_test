package service_impl;

import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import proto_generated.ThreadManagement;
import proto_generated.ThreadManagementServiceGrpc.ThreadManagementServiceImplBase;

public class ThreadManagementServiceImpl extends ThreadManagementServiceImplBase
{
  private Map<Integer, List<ThreadManagement.Thread>> threads;

  public ThreadManagementServiceImpl( )
  {
    super( );
    this.threads = new HashMap<>( );
  }

  @Override
  public void createThread( ThreadManagement.Thread request,
      StreamObserver<ThreadManagement.CreateReply> responseObserver )
  {
    List<ThreadManagement.Thread> threadList = threads.get( request.getId( ) );

    if ( threadList == null )
    {
      threadList = new ArrayList<>( );
    }

    threadList.add( request );

    threads.put( request.getId(), threadList );

    ThreadManagement.CreateReply reply =
        ThreadManagement.CreateReply.newBuilder( ).setThread( request ).build( );

    responseObserver.onNext( reply );
    responseObserver.onCompleted( );
  }

  public void search( ThreadManagement.SearchRequestById request,
      StreamObserver<ThreadManagement.SearchResponse> responseObserver )
  {
    int pattern = request.getMessageId( );

    List<ThreadManagement.Thread> personList = threads.get( pattern );

    ThreadManagement.SearchResponse reply;

    if ( personList != null )
    {
      reply = ThreadManagement.SearchResponse.newBuilder( ).addAllThread( personList ).build( );
    }
    else
    {
      reply = ThreadManagement.SearchResponse.newBuilder( ).build( );
    }

    responseObserver.onNext( reply );
    responseObserver.onCompleted( );
  }

  public void listAll( ThreadManagement.SearchRequestById request,
      final StreamObserver<ThreadManagement.SearchResponse> responseObserver )
  {
    ThreadManagement.SearchResponse.Builder replyBuilder = ThreadManagement.SearchResponse.newBuilder( );

    for ( Map.Entry<Integer, List<ThreadManagement.Thread>> integerListEntry : threads.entrySet( ) )
    {
      replyBuilder.addAllThread( integerListEntry.getValue( ) );
    }

    responseObserver.onNext( replyBuilder.build( ) );
    responseObserver.onCompleted( );
  }
}
