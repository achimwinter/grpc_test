package servermain;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import service_impl.ThreadManagementServiceImpl;

public class ThreadManagementServer
{
  private final Server server;

  public ThreadManagementServer( int port )
  {
    this.server = ServerBuilder.forPort( port )
        .addService( new ThreadManagementServiceImpl() )
        .build( );
  }

  public static void main( String[] args ) throws Exception
  {
    final ThreadManagementServer server = new ThreadManagementServer( 8888 );
    server.start( );
    System.out.println( "Server running ..." );
    server.blockUntilShutdown( );
  }

  public void start( ) throws IOException
  {
    server.start( );

    Runtime.getRuntime( ).addShutdownHook( new Thread( )
    {

      @Override
      public void run( )
      {
        System.err.println( "Shutting down gRPC server since JVM is shutting down" );
        ThreadManagementServer.this.stop( );
        System.err.println( "Server shut down" );
      }
    } );
  }

  public void stop( )
  {
    if ( server != null )
    {
      server.shutdown( );
    }
  }

  private void blockUntilShutdown( ) throws InterruptedException
  {
    if ( server != null )
    {
      server.awaitTermination( );
    }
  }
}
