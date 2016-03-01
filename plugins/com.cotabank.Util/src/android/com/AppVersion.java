// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: AppVersion.proto

public final class AppVersion {
  private AppVersion() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface AppVersionRequestOrBuilder extends
      // @@protoc_insertion_point(interface_extends:AppVersionRequest)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required int32 app_id = 1;</code>
     */
    boolean hasAppId();
    /**
     * <code>required int32 app_id = 1;</code>
     */
    int getAppId();

    /**
     * <code>required int32 app_type = 2;</code>
     *
     * <pre>
     * 0:iOS ; 1:Andriod
     * </pre>
     */
    boolean hasAppType();
    /**
     * <code>required int32 app_type = 2;</code>
     *
     * <pre>
     * 0:iOS ; 1:Andriod
     * </pre>
     */
    int getAppType();
  }
  /**
   * Protobuf type {@code AppVersionRequest}
   */
  public static final class AppVersionRequest extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:AppVersionRequest)
      AppVersionRequestOrBuilder {
    // Use AppVersionRequest.newBuilder() to construct.
    private AppVersionRequest(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private AppVersionRequest(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final AppVersionRequest defaultInstance;
    public static AppVersionRequest getDefaultInstance() {
      return defaultInstance;
    }

    public AppVersionRequest getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private AppVersionRequest(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              appId_ = input.readInt32();
              break;
            }
            case 16: {
              bitField0_ |= 0x00000002;
              appType_ = input.readInt32();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return AppVersion.internal_static_AppVersionRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return AppVersion.internal_static_AppVersionRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              AppVersion.AppVersionRequest.class, AppVersion.AppVersionRequest.Builder.class);
    }

    public static com.google.protobuf.Parser<AppVersionRequest> PARSER =
        new com.google.protobuf.AbstractParser<AppVersionRequest>() {
      public AppVersionRequest parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new AppVersionRequest(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<AppVersionRequest> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    public static final int APP_ID_FIELD_NUMBER = 1;
    private int appId_;
    /**
     * <code>required int32 app_id = 1;</code>
     */
    public boolean hasAppId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required int32 app_id = 1;</code>
     */
    public int getAppId() {
      return appId_;
    }

    public static final int APP_TYPE_FIELD_NUMBER = 2;
    private int appType_;
    /**
     * <code>required int32 app_type = 2;</code>
     *
     * <pre>
     * 0:iOS ; 1:Andriod
     * </pre>
     */
    public boolean hasAppType() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required int32 app_type = 2;</code>
     *
     * <pre>
     * 0:iOS ; 1:Andriod
     * </pre>
     */
    public int getAppType() {
      return appType_;
    }

    private void initFields() {
      appId_ = 0;
      appType_ = 0;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasAppId()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasAppType()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeInt32(1, appId_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeInt32(2, appType_);
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, appId_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, appType_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static AppVersion.AppVersionRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static AppVersion.AppVersionRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static AppVersion.AppVersionRequest parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static AppVersion.AppVersionRequest parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static AppVersion.AppVersionRequest parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static AppVersion.AppVersionRequest parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static AppVersion.AppVersionRequest parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static AppVersion.AppVersionRequest parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static AppVersion.AppVersionRequest parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static AppVersion.AppVersionRequest parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(AppVersion.AppVersionRequest prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code AppVersionRequest}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:AppVersionRequest)
        AppVersion.AppVersionRequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return AppVersion.internal_static_AppVersionRequest_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return AppVersion.internal_static_AppVersionRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                AppVersion.AppVersionRequest.class, AppVersion.AppVersionRequest.Builder.class);
      }

      // Construct using AppVersion.AppVersionRequest.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        appId_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        appType_ = 0;
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return AppVersion.internal_static_AppVersionRequest_descriptor;
      }

      public AppVersion.AppVersionRequest getDefaultInstanceForType() {
        return AppVersion.AppVersionRequest.getDefaultInstance();
      }

      public AppVersion.AppVersionRequest build() {
        AppVersion.AppVersionRequest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public AppVersion.AppVersionRequest buildPartial() {
        AppVersion.AppVersionRequest result = new AppVersion.AppVersionRequest(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.appId_ = appId_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.appType_ = appType_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof AppVersion.AppVersionRequest) {
          return mergeFrom((AppVersion.AppVersionRequest)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(AppVersion.AppVersionRequest other) {
        if (other == AppVersion.AppVersionRequest.getDefaultInstance()) return this;
        if (other.hasAppId()) {
          setAppId(other.getAppId());
        }
        if (other.hasAppType()) {
          setAppType(other.getAppType());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasAppId()) {
          
          return false;
        }
        if (!hasAppType()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        AppVersion.AppVersionRequest parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (AppVersion.AppVersionRequest) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private int appId_ ;
      /**
       * <code>required int32 app_id = 1;</code>
       */
      public boolean hasAppId() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required int32 app_id = 1;</code>
       */
      public int getAppId() {
        return appId_;
      }
      /**
       * <code>required int32 app_id = 1;</code>
       */
      public Builder setAppId(int value) {
        bitField0_ |= 0x00000001;
        appId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 app_id = 1;</code>
       */
      public Builder clearAppId() {
        bitField0_ = (bitField0_ & ~0x00000001);
        appId_ = 0;
        onChanged();
        return this;
      }

      private int appType_ ;
      /**
       * <code>required int32 app_type = 2;</code>
       *
       * <pre>
       * 0:iOS ; 1:Andriod
       * </pre>
       */
      public boolean hasAppType() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required int32 app_type = 2;</code>
       *
       * <pre>
       * 0:iOS ; 1:Andriod
       * </pre>
       */
      public int getAppType() {
        return appType_;
      }
      /**
       * <code>required int32 app_type = 2;</code>
       *
       * <pre>
       * 0:iOS ; 1:Andriod
       * </pre>
       */
      public Builder setAppType(int value) {
        bitField0_ |= 0x00000002;
        appType_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 app_type = 2;</code>
       *
       * <pre>
       * 0:iOS ; 1:Andriod
       * </pre>
       */
      public Builder clearAppType() {
        bitField0_ = (bitField0_ & ~0x00000002);
        appType_ = 0;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:AppVersionRequest)
    }

    static {
      defaultInstance = new AppVersionRequest(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:AppVersionRequest)
  }

  public interface AppVersionResponseOrBuilder extends
      // @@protoc_insertion_point(interface_extends:AppVersionResponse)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required int32 app_id = 1;</code>
     */
    boolean hasAppId();
    /**
     * <code>required int32 app_id = 1;</code>
     */
    int getAppId();

    /**
     * <code>required string version = 2;</code>
     */
    boolean hasVersion();
    /**
     * <code>required string version = 2;</code>
     */
    java.lang.String getVersion();
    /**
     * <code>required string version = 2;</code>
     */
    com.google.protobuf.ByteString
        getVersionBytes();
  }
  /**
   * Protobuf type {@code AppVersionResponse}
   */
  public static final class AppVersionResponse extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:AppVersionResponse)
      AppVersionResponseOrBuilder {
    // Use AppVersionResponse.newBuilder() to construct.
    private AppVersionResponse(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private AppVersionResponse(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final AppVersionResponse defaultInstance;
    public static AppVersionResponse getDefaultInstance() {
      return defaultInstance;
    }

    public AppVersionResponse getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private AppVersionResponse(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              appId_ = input.readInt32();
              break;
            }
            case 18: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000002;
              version_ = bs;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return AppVersion.internal_static_AppVersionResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return AppVersion.internal_static_AppVersionResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              AppVersion.AppVersionResponse.class, AppVersion.AppVersionResponse.Builder.class);
    }

    public static com.google.protobuf.Parser<AppVersionResponse> PARSER =
        new com.google.protobuf.AbstractParser<AppVersionResponse>() {
      public AppVersionResponse parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new AppVersionResponse(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<AppVersionResponse> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    public static final int APP_ID_FIELD_NUMBER = 1;
    private int appId_;
    /**
     * <code>required int32 app_id = 1;</code>
     */
    public boolean hasAppId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required int32 app_id = 1;</code>
     */
    public int getAppId() {
      return appId_;
    }

    public static final int VERSION_FIELD_NUMBER = 2;
    private java.lang.Object version_;
    /**
     * <code>required string version = 2;</code>
     */
    public boolean hasVersion() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required string version = 2;</code>
     */
    public java.lang.String getVersion() {
      java.lang.Object ref = version_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          version_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string version = 2;</code>
     */
    public com.google.protobuf.ByteString
        getVersionBytes() {
      java.lang.Object ref = version_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        version_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private void initFields() {
      appId_ = 0;
      version_ = "";
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasAppId()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasVersion()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeInt32(1, appId_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, getVersionBytes());
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, appId_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, getVersionBytes());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static AppVersion.AppVersionResponse parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static AppVersion.AppVersionResponse parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static AppVersion.AppVersionResponse parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static AppVersion.AppVersionResponse parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static AppVersion.AppVersionResponse parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static AppVersion.AppVersionResponse parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static AppVersion.AppVersionResponse parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static AppVersion.AppVersionResponse parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static AppVersion.AppVersionResponse parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static AppVersion.AppVersionResponse parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(AppVersion.AppVersionResponse prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code AppVersionResponse}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:AppVersionResponse)
        AppVersion.AppVersionResponseOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return AppVersion.internal_static_AppVersionResponse_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return AppVersion.internal_static_AppVersionResponse_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                AppVersion.AppVersionResponse.class, AppVersion.AppVersionResponse.Builder.class);
      }

      // Construct using AppVersion.AppVersionResponse.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        appId_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        version_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return AppVersion.internal_static_AppVersionResponse_descriptor;
      }

      public AppVersion.AppVersionResponse getDefaultInstanceForType() {
        return AppVersion.AppVersionResponse.getDefaultInstance();
      }

      public AppVersion.AppVersionResponse build() {
        AppVersion.AppVersionResponse result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public AppVersion.AppVersionResponse buildPartial() {
        AppVersion.AppVersionResponse result = new AppVersion.AppVersionResponse(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.appId_ = appId_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.version_ = version_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof AppVersion.AppVersionResponse) {
          return mergeFrom((AppVersion.AppVersionResponse)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(AppVersion.AppVersionResponse other) {
        if (other == AppVersion.AppVersionResponse.getDefaultInstance()) return this;
        if (other.hasAppId()) {
          setAppId(other.getAppId());
        }
        if (other.hasVersion()) {
          bitField0_ |= 0x00000002;
          version_ = other.version_;
          onChanged();
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasAppId()) {
          
          return false;
        }
        if (!hasVersion()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        AppVersion.AppVersionResponse parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (AppVersion.AppVersionResponse) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private int appId_ ;
      /**
       * <code>required int32 app_id = 1;</code>
       */
      public boolean hasAppId() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required int32 app_id = 1;</code>
       */
      public int getAppId() {
        return appId_;
      }
      /**
       * <code>required int32 app_id = 1;</code>
       */
      public Builder setAppId(int value) {
        bitField0_ |= 0x00000001;
        appId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 app_id = 1;</code>
       */
      public Builder clearAppId() {
        bitField0_ = (bitField0_ & ~0x00000001);
        appId_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object version_ = "";
      /**
       * <code>required string version = 2;</code>
       */
      public boolean hasVersion() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required string version = 2;</code>
       */
      public java.lang.String getVersion() {
        java.lang.Object ref = version_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            version_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string version = 2;</code>
       */
      public com.google.protobuf.ByteString
          getVersionBytes() {
        java.lang.Object ref = version_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          version_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string version = 2;</code>
       */
      public Builder setVersion(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        version_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string version = 2;</code>
       */
      public Builder clearVersion() {
        bitField0_ = (bitField0_ & ~0x00000002);
        version_ = getDefaultInstance().getVersion();
        onChanged();
        return this;
      }
      /**
       * <code>required string version = 2;</code>
       */
      public Builder setVersionBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        version_ = value;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:AppVersionResponse)
    }

    static {
      defaultInstance = new AppVersionResponse(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:AppVersionResponse)
  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AppVersionRequest_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_AppVersionRequest_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AppVersionResponse_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_AppVersionResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020AppVersion.proto\"5\n\021AppVersionRequest\022" +
      "\016\n\006app_id\030\001 \002(\005\022\020\n\010app_type\030\002 \002(\005\"5\n\022App" +
      "VersionResponse\022\016\n\006app_id\030\001 \002(\005\022\017\n\007versi" +
      "on\030\002 \002(\t"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_AppVersionRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_AppVersionRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_AppVersionRequest_descriptor,
        new java.lang.String[] { "AppId", "AppType", });
    internal_static_AppVersionResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_AppVersionResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_AppVersionResponse_descriptor,
        new java.lang.String[] { "AppId", "Version", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
