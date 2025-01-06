// TODO: license
package org.reaktivity.nukleus.echo.internal.types.stream;

import java.util.function.Consumer;
import org.agrona.DirectBuffer;
import org.agrona.MutableDirectBuffer;
import org.reaktivity.nukleus.echo.internal.types.ArrayFW;
import org.reaktivity.nukleus.echo.internal.types.Flyweight;
import org.reaktivity.nukleus.echo.internal.types.OctetsFW;

public final class AbortFW extends Flyweight {
  public static final int FIELD_OFFSET_ROUTE_ID = 0;

  private static final int FIELD_SIZE_ROUTE_ID = 8;

  public static final int FIELD_OFFSET_STREAM_ID = FIELD_OFFSET_ROUTE_ID + FIELD_SIZE_ROUTE_ID;

  private static final int FIELD_SIZE_STREAM_ID = 8;

  public static final int FIELD_OFFSET_SEQUENCE = FIELD_OFFSET_STREAM_ID + FIELD_SIZE_STREAM_ID;

  private static final int FIELD_SIZE_SEQUENCE = 8;

  public static final int FIELD_OFFSET_ACKNOWLEDGE = FIELD_OFFSET_SEQUENCE + FIELD_SIZE_SEQUENCE;

  private static final int FIELD_SIZE_ACKNOWLEDGE = 8;

  public static final int FIELD_OFFSET_MAXIMUM = FIELD_OFFSET_ACKNOWLEDGE + FIELD_SIZE_ACKNOWLEDGE;

  private static final int FIELD_SIZE_MAXIMUM = 4;

  public static final int FIELD_OFFSET_TIMESTAMP = FIELD_OFFSET_MAXIMUM + FIELD_SIZE_MAXIMUM;

  private static final int FIELD_SIZE_TIMESTAMP = 8;

  public static final int FIELD_OFFSET_TRACE_ID = FIELD_OFFSET_TIMESTAMP + FIELD_SIZE_TIMESTAMP;

  private static final int FIELD_SIZE_TRACE_ID = 8;

  public static final int FIELD_OFFSET_AUTHORIZATION = FIELD_OFFSET_TRACE_ID + FIELD_SIZE_TRACE_ID;

  private static final int FIELD_SIZE_AUTHORIZATION = 8;

  public static final int FIELD_OFFSET_EXTENSION = FIELD_OFFSET_AUTHORIZATION + FIELD_SIZE_AUTHORIZATION;

  public static final int TYPE_ID = 0x00000004;

  private final OctetsFW extensionRO = new OctetsFW();

  public long routeId() {
    return buffer().getLong(offset() + FIELD_OFFSET_ROUTE_ID);
  }

  public long streamId() {
    return buffer().getLong(offset() + FIELD_OFFSET_STREAM_ID);
  }

  public long sequence() {
    return buffer().getLong(offset() + FIELD_OFFSET_SEQUENCE);
  }

  public long acknowledge() {
    return buffer().getLong(offset() + FIELD_OFFSET_ACKNOWLEDGE);
  }

  public int maximum() {
    return buffer().getInt(offset() + FIELD_OFFSET_MAXIMUM);
  }

  public long timestamp() {
    return buffer().getLong(offset() + FIELD_OFFSET_TIMESTAMP);
  }

  public long traceId() {
    return buffer().getLong(offset() + FIELD_OFFSET_TRACE_ID);
  }

  public long authorization() {
    return buffer().getLong(offset() + FIELD_OFFSET_AUTHORIZATION);
  }

  public OctetsFW extension() {
    return extensionRO;
  }

  public int typeId() {
    return TYPE_ID;
  }

  @Override
  public AbortFW wrap(DirectBuffer buffer, int offset, int maxLimit) {
    super.wrap(buffer, offset, maxLimit);
    extensionRO.wrap(buffer, offset + FIELD_OFFSET_EXTENSION, maxLimit);
    checkLimit(limit(), maxLimit);
    return this;
  }

  @Override
  public AbortFW tryWrap(DirectBuffer buffer, int offset, int maxLimit) {
    if (null == super.tryWrap(buffer, offset, maxLimit)) {
      return null;
    }
    if (null == extensionRO.tryWrap(buffer, offset + FIELD_OFFSET_EXTENSION, maxLimit)) {
      return null;
    }
    if (limit() > maxLimit) {
      return null;
    }
    return this;
  }

  @Override
  public int limit() {
    return extensionRO.limit();
  }

  @Override
  public String toString() {
    return String.format("ABORT [routeId=%d, streamId=%d, sequence=%d, acknowledge=%d, maximum=%d, timestamp=%d, traceId=%d, authorization=%d, extension=%s]", routeId(), streamId(), sequence(), acknowledge(), maximum(), timestamp(), traceId(), authorization(), extension());
  }

  public static final class Builder extends Flyweight.Builder<AbortFW> {
    private static final int INDEX_ROUTE_ID = 0;

    private static final int INDEX_STREAM_ID = 1;

    private static final int INDEX_SEQUENCE = 2;

    private static final int INDEX_ACKNOWLEDGE = 3;

    private static final int INDEX_MAXIMUM = 4;

    private static final int INDEX_TIMESTAMP = 5;

    public static final long DEFAULT_TIMESTAMP = 0;

    private static final int INDEX_TRACE_ID = 6;

    public static final long DEFAULT_TRACE_ID = 0;

    private static final int INDEX_AUTHORIZATION = 7;

    public static final long DEFAULT_AUTHORIZATION = 0;

    private static final int INDEX_EXTENSION = 8;

    private static final int FIELD_COUNT = 9;

    private final OctetsFW.Builder extensionRW = new OctetsFW.Builder();

    private int lastFieldSet = -1;

    public Builder() {
      super(new AbortFW());
    }

    public Builder routeId(long value) {
      assert lastFieldSet == INDEX_ROUTE_ID - 1;
      int newLimit = limit() + FIELD_SIZE_ROUTE_ID;
      checkLimit(newLimit, maxLimit());
      buffer().putLong(limit(), value);
      lastFieldSet = INDEX_ROUTE_ID;
      limit(newLimit);
      return this;
    }

    public Builder streamId(long value) {
      assert lastFieldSet == INDEX_STREAM_ID - 1;
      int newLimit = limit() + FIELD_SIZE_STREAM_ID;
      checkLimit(newLimit, maxLimit());
      buffer().putLong(limit(), value);
      lastFieldSet = INDEX_STREAM_ID;
      limit(newLimit);
      return this;
    }

    public Builder sequence(long value) {
      assert lastFieldSet == INDEX_SEQUENCE - 1;
      int newLimit = limit() + FIELD_SIZE_SEQUENCE;
      checkLimit(newLimit, maxLimit());
      buffer().putLong(limit(), value);
      lastFieldSet = INDEX_SEQUENCE;
      limit(newLimit);
      return this;
    }

    public Builder acknowledge(long value) {
      assert lastFieldSet == INDEX_ACKNOWLEDGE - 1;
      int newLimit = limit() + FIELD_SIZE_ACKNOWLEDGE;
      checkLimit(newLimit, maxLimit());
      buffer().putLong(limit(), value);
      lastFieldSet = INDEX_ACKNOWLEDGE;
      limit(newLimit);
      return this;
    }

    public Builder maximum(int value) {
      assert lastFieldSet == INDEX_MAXIMUM - 1;
      int newLimit = limit() + FIELD_SIZE_MAXIMUM;
      checkLimit(newLimit, maxLimit());
      buffer().putInt(limit(), value);
      lastFieldSet = INDEX_MAXIMUM;
      limit(newLimit);
      return this;
    }

    public Builder timestamp(long value) {
      assert lastFieldSet == INDEX_TIMESTAMP - 1;
      int newLimit = limit() + FIELD_SIZE_TIMESTAMP;
      checkLimit(newLimit, maxLimit());
      buffer().putLong(limit(), value);
      lastFieldSet = INDEX_TIMESTAMP;
      limit(newLimit);
      return this;
    }

    public Builder traceId(long value) {
      if (lastFieldSet < INDEX_TIMESTAMP) {
        timestamp(DEFAULT_TIMESTAMP);
      }
      assert lastFieldSet == INDEX_TRACE_ID - 1;
      int newLimit = limit() + FIELD_SIZE_TRACE_ID;
      checkLimit(newLimit, maxLimit());
      buffer().putLong(limit(), value);
      lastFieldSet = INDEX_TRACE_ID;
      limit(newLimit);
      return this;
    }

    public Builder authorization(long value) {
      if (lastFieldSet < INDEX_TRACE_ID) {
        traceId(DEFAULT_TRACE_ID);
      }
      assert lastFieldSet == INDEX_AUTHORIZATION - 1;
      int newLimit = limit() + FIELD_SIZE_AUTHORIZATION;
      checkLimit(newLimit, maxLimit());
      buffer().putLong(limit(), value);
      lastFieldSet = INDEX_AUTHORIZATION;
      limit(newLimit);
      return this;
    }

    private OctetsFW.Builder extension() {
      if (lastFieldSet < INDEX_AUTHORIZATION) {
        authorization(DEFAULT_AUTHORIZATION);
      }
      assert lastFieldSet == INDEX_EXTENSION - 1;
      return extensionRW.wrap(buffer(), limit(), maxLimit());
    }

    public Builder extension(OctetsFW value) {
      OctetsFW.Builder extensionRW = extension();
      extensionRW.set(value);
      limit(extensionRW.build().limit());
      lastFieldSet = INDEX_EXTENSION;
      return this;
    }

    public Builder extension(Consumer<OctetsFW.Builder> mutator) {
      OctetsFW.Builder extensionRW = extension();
      mutator.accept(extensionRW);
      limit(extensionRW.build().limit());
      lastFieldSet = INDEX_EXTENSION;
      return this;
    }

    public Builder extension(DirectBuffer buffer, int offset, int length) {
      OctetsFW.Builder extensionRW = extension();
      extensionRW.set(buffer, offset, length);
      limit(extensionRW.build().limit());
      lastFieldSet = INDEX_EXTENSION;
      return this;
    }

    @Override
    public Builder wrap(MutableDirectBuffer buffer, int offset, int maxLimit) {
      super.wrap(buffer, offset, maxLimit);
      lastFieldSet = -1;
      limit(offset);
      return this;
    }

    @Override
    public Builder wrap(ArrayFW.Builder<?, ?, ?> array) {
      super.wrap(array);
      lastFieldSet = -1;
      return this;
    }

    @Override
    public Builder rewrap() {
      super.rewrap();
      return this;
    }

    @Override
    public AbortFW build() {
      if (lastFieldSet < INDEX_EXTENSION) {
        extension(b -> { });
      }
      assert lastFieldSet == FIELD_COUNT - 1;
      lastFieldSet = -1;
      return super.build();
    }
  }
}
