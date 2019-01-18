package proto_generated;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.2.0)",
    comments = "Source: Message.proto")
public final class ThreadManagementServiceGrpc {

  private ThreadManagementServiceGrpc() {}

  public static final String SERVICE_NAME = "proto_generated.ThreadManagementService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<proto_generated.ThreadManagement.Thread,
      proto_generated.ThreadManagement.CreateReply> METHOD_CREATE_THREAD =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "proto_generated.ThreadManagementService", "createThread"),
          io.grpc.protobuf.ProtoUtils.marshaller(proto_generated.ThreadManagement.Thread.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(proto_generated.ThreadManagement.CreateReply.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<proto_generated.ThreadManagement.SearchRequestById,
      proto_generated.ThreadManagement.SearchResponse> METHOD_SEARCH =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "proto_generated.ThreadManagementService", "search"),
          io.grpc.protobuf.ProtoUtils.marshaller(proto_generated.ThreadManagement.SearchRequestById.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(proto_generated.ThreadManagement.SearchResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<proto_generated.ThreadManagement.SearchRequestById,
      proto_generated.ThreadManagement.SearchResponse> METHOD_LIST_ALL =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "proto_generated.ThreadManagementService", "listAll"),
          io.grpc.protobuf.ProtoUtils.marshaller(proto_generated.ThreadManagement.SearchRequestById.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(proto_generated.ThreadManagement.SearchResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ThreadManagementServiceStub newStub(io.grpc.Channel channel) {
    return new ThreadManagementServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ThreadManagementServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ThreadManagementServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static ThreadManagementServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ThreadManagementServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ThreadManagementServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createThread(proto_generated.ThreadManagement.Thread request,
        io.grpc.stub.StreamObserver<proto_generated.ThreadManagement.CreateReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE_THREAD, responseObserver);
    }

    /**
     */
    public void search(proto_generated.ThreadManagement.SearchRequestById request,
        io.grpc.stub.StreamObserver<proto_generated.ThreadManagement.SearchResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEARCH, responseObserver);
    }

    /**
     */
    public void listAll(proto_generated.ThreadManagement.SearchRequestById request,
        io.grpc.stub.StreamObserver<proto_generated.ThreadManagement.SearchResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LIST_ALL, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CREATE_THREAD,
            asyncUnaryCall(
              new MethodHandlers<
                proto_generated.ThreadManagement.Thread,
                proto_generated.ThreadManagement.CreateReply>(
                  this, METHODID_CREATE_THREAD)))
          .addMethod(
            METHOD_SEARCH,
            asyncUnaryCall(
              new MethodHandlers<
                proto_generated.ThreadManagement.SearchRequestById,
                proto_generated.ThreadManagement.SearchResponse>(
                  this, METHODID_SEARCH)))
          .addMethod(
            METHOD_LIST_ALL,
            asyncUnaryCall(
              new MethodHandlers<
                proto_generated.ThreadManagement.SearchRequestById,
                proto_generated.ThreadManagement.SearchResponse>(
                  this, METHODID_LIST_ALL)))
          .build();
    }
  }

  /**
   */
  public static final class ThreadManagementServiceStub extends io.grpc.stub.AbstractStub<ThreadManagementServiceStub> {
    private ThreadManagementServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ThreadManagementServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ThreadManagementServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ThreadManagementServiceStub(channel, callOptions);
    }

    /**
     */
    public void createThread(proto_generated.ThreadManagement.Thread request,
        io.grpc.stub.StreamObserver<proto_generated.ThreadManagement.CreateReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_THREAD, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void search(proto_generated.ThreadManagement.SearchRequestById request,
        io.grpc.stub.StreamObserver<proto_generated.ThreadManagement.SearchResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEARCH, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listAll(proto_generated.ThreadManagement.SearchRequestById request,
        io.grpc.stub.StreamObserver<proto_generated.ThreadManagement.SearchResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LIST_ALL, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ThreadManagementServiceBlockingStub extends io.grpc.stub.AbstractStub<ThreadManagementServiceBlockingStub> {
    private ThreadManagementServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ThreadManagementServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ThreadManagementServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ThreadManagementServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto_generated.ThreadManagement.CreateReply createThread(proto_generated.ThreadManagement.Thread request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE_THREAD, getCallOptions(), request);
    }

    /**
     */
    public proto_generated.ThreadManagement.SearchResponse search(proto_generated.ThreadManagement.SearchRequestById request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEARCH, getCallOptions(), request);
    }

    /**
     */
    public proto_generated.ThreadManagement.SearchResponse listAll(proto_generated.ThreadManagement.SearchRequestById request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LIST_ALL, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ThreadManagementServiceFutureStub extends io.grpc.stub.AbstractStub<ThreadManagementServiceFutureStub> {
    private ThreadManagementServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ThreadManagementServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ThreadManagementServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ThreadManagementServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto_generated.ThreadManagement.CreateReply> createThread(
        proto_generated.ThreadManagement.Thread request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_THREAD, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto_generated.ThreadManagement.SearchResponse> search(
        proto_generated.ThreadManagement.SearchRequestById request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEARCH, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto_generated.ThreadManagement.SearchResponse> listAll(
        proto_generated.ThreadManagement.SearchRequestById request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LIST_ALL, getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_THREAD = 0;
  private static final int METHODID_SEARCH = 1;
  private static final int METHODID_LIST_ALL = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ThreadManagementServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ThreadManagementServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_THREAD:
          serviceImpl.createThread((proto_generated.ThreadManagement.Thread) request,
              (io.grpc.stub.StreamObserver<proto_generated.ThreadManagement.CreateReply>) responseObserver);
          break;
        case METHODID_SEARCH:
          serviceImpl.search((proto_generated.ThreadManagement.SearchRequestById) request,
              (io.grpc.stub.StreamObserver<proto_generated.ThreadManagement.SearchResponse>) responseObserver);
          break;
        case METHODID_LIST_ALL:
          serviceImpl.listAll((proto_generated.ThreadManagement.SearchRequestById) request,
              (io.grpc.stub.StreamObserver<proto_generated.ThreadManagement.SearchResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class ThreadManagementServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto_generated.ThreadManagement.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ThreadManagementServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ThreadManagementServiceDescriptorSupplier())
              .addMethod(METHOD_CREATE_THREAD)
              .addMethod(METHOD_SEARCH)
              .addMethod(METHOD_LIST_ALL)
              .build();
        }
      }
    }
    return result;
  }
}
