// TODO: license
package org.reaktivity.nukleus.echo.internal.types.stream;

import java.util.function.Consumer;
import org.agrona.DirectBuffer;
import org.agrona.MutableDirectBuffer;
import org.reaktivity.nukleus.echo.internal.types.ArrayFW;
import org.reaktivity.nukleus.echo.internal.types.Flyweight;
import org.reaktivity.nukleus.echo.internal.types.OctetsFW;

public final class DataFW extends Flyweight {
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

  public static final int FIELD_OFFSET_FLAGS = FIELD_OFFSET_AUTHORIZATION + FIELD_SIZE_AUTHORIZATION;

  private static final int FIELD_SIZE_FLAGS = 1;

  public static final int FIELD_OFFSET_BUDGET_ID = FIELD_OFFSET_FLAGS + FIELD_SIZE_FLAGS;

  private static final int FIELD_SIZE_BUDGET_ID = 8;

  public static final int FIELD_OFFSET_RESERVED = FIELD_OFFSET_BUDGET_ID + FIELD_SIZE_BUDGET_ID;

  private static final int FIELD_SIZE_RESERVED = 4;

  public static final int FIELD_OFFSET_LENGTH = FIELD_OFFSET_RESERVED + FIELD_SIZE_RESERVED;

  private static final int FIELD_SIZE_LENGTH = 4;

  public static final int FIELD_OFFSET_PAYLOAD = FIELD_OFFSET_LENGTH + FIELD_SIZE_LENGTH;

  public static final int FIELD_OFFSET_EXTENSION = 0;

  public static final int TYPE_ID = 0x00000002;

  private OctetsFW payloadRO = new OctetsFW();

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

  public int flags() {
    return (int)(buffer().getByte(offset() + FIELD_OFFSET_FLAGS) & 0xFF);
  }

  public long budgetId() {
    return buffer().getLong(offset() + FIELD_OFFSET_BUDGET_ID);
  }

  public int reserved() {
    return buffer().getInt(offset() + FIELD_OFFSET_RESERVED);
  }

  public int length() {
    return buffer().getInt(offset() + FIELD_OFFSET_LENGTH);
  }

  public OctetsFW payload() {
    return length() == -1 ? null : payloadRO;
  }

  public OctetsFW extension() {
    return extensionRO;
  }

  public int typeId() {
    return TYPE_ID;
  }

  @Override
  public DataFW wrap(DirectBuffer buffer, int offset, int maxLimit) {
    super.wrap(buffer, offset, maxLimit);
    payloadRO.wrap(buffer, offset + FIELD_OFFSET_PAYLOAD, offset + FIELD_OFFSET_PAYLOAD + ((int) length() == -1 ? 0 : (int) length()));
    extensionRO.wrap(buffer, payloadRO.limit() + FIELD_OFFSET_EXTENSION, maxLimit);
    checkLimit(limit(), maxLimit);
    return this;
  }

  @Override
  public DataFW tryWrap(DirectBuffer buffer, int offset, int maxLimit) {
    if (null == super.tryWrap(buffer, offset, maxLimit)) {
      return null;
    }
    int limit;
    limit = offset + FIELD_OFFSET_PAYLOAD + ((int) length() == -1 ? 0 : (int) length());
    if (limit > maxLimit || null == payloadRO.tryWrap(buffer, offset + FIELD_OFFSET_PAYLOAD, limit)) {
      return null;
    }
    if (null == extensionRO.tryWrap(buffer, payloadRO.limit() + FIELD_OFFSET_EXTENSION, maxLimit)) {
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
    return String.format("DATA [routeId=%d, streamId=%d, sequence=%d, acknowledge=%d, maximum=%d, timestamp=%d, traceId=%d, authorization=%d, flags=%d, budgetId=%d, reserved=%d, length=%d, payload=%s, extension=%s]", routeId(), streamId(), sequence(), acknowledge(), maximum(), timestamp(), traceId(), authorization(), flags(), budgetId(), reserved(), length(), payload(), extension());
  }

  public static final class Builder extends Flyweight.Builder<DataFW> {
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

    private static final int INDEX_FLAGS = 8;

    public static final int DEFAULT_FLAGS = 3;

    private static final int INDEX_BUDGET_ID = 9;

    private static final int INDEX_RESERVED = 10;

    public static final int DEFAULT_LENGTH = 0;

    private static final int INDEX_PAYLOAD = 11;

    private static final int INDEX_EXTENSION = 12;

    private static final int FIELD_COUNT = 13;

    private int dynamicOffsetLength;

    private final OctetsFW.Builder payloadRW = new OctetsFW.Builder();

    private final OctetsFW.Builder extensionRW = new OctetsFW.Builder();

    private int lastFieldSet = -1;

    public Builder() {
      super(new DataFW());
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

    public Builder flags(int value) {
      if (value < 0) {
        throw new IllegalArgumentException(String.format("Value %d too low for field \"flags\"", value));
      }
      if (value > 0XFF) {
        throw new IllegalArgumentException(String.format("Value %d too high for field \"flags\"", value));
      }
      if (lastFieldSet < INDEX_AUTHORIZATION) {
        authorization(DEFAULT_AUTHORIZATION);
      }
      assert lastFieldSet == INDEX_FLAGS - 1;
      int newLimit = limit() + FIELD_SIZE_FLAGS;
      checkLimit(newLimit, maxLimit());
      buffer().putByte(limit(), (byte)(value & 0xFF));
      lastFieldSet = INDEX_FLAGS;
      limit(newLimit);
      return this;
    }

    public Builder budgetId(long value) {
      if (lastFieldSet < INDEX_FLAGS) {
        flags(DEFAULT_FLAGS);
      }
      assert lastFieldSet == INDEX_BUDGET_ID - 1;
      int newLimit = limit() + FIELD_SIZE_BUDGET_ID;
      checkLimit(newLimit, maxLimit());
      buffer().putLong(limit(), value);
      lastFieldSet = INDEX_BUDGET_ID;
      limit(newLimit);
      return this;
    }

    public Builder reserved(int value) {
      assert lastFieldSet == INDEX_RESERVED - 1;
      int newLimit = limit() + FIELD_SIZE_RESERVED;
      checkLimit(newLimit, maxLimit());
      buffer().putInt(limit(), value);
      lastFieldSet = INDEX_RESERVED;
      limit(newLimit);
      return this;
    }

    private Builder length(int value) {
      int newLimit = limit() + FIELD_SIZE_LENGTH;
      checkLimit(newLimit, maxLimit());
      buffer().putInt(limit(), value);
      dynamicOffsetLength = limit();
      limit(newLimit);
      return this;
    }

    private OctetsFW.Builder payload() {
      length(DEFAULT_LENGTH);
      assert lastFieldSet == INDEX_PAYLOAD - 1;
      return payloadRW.wrap(buffer(), limit(), maxLimit());
    }

    public Builder payload(OctetsFW value) {
      int size$;
      int newLimit;
      OctetsFW.Builder payloadRW = payload();
      if (value == null) {
        size$ = -1;
        newLimit = limit();
      } else {
        payloadRW.set(value);
        newLimit = payloadRW.build().limit();
        size$ = newLimit - limit();
      }
      limit(dynamicOffsetLength);
      length(size$);
      limit(newLimit);
      lastFieldSet = INDEX_PAYLOAD;
      return this;
    }

    public Builder payload(Consumer<OctetsFW.Builder> mutator) {
      OctetsFW.Builder payloadRW = payload();
      mutator.accept(payloadRW);
      int newLimit = payloadRW.build().limit();
      int size$ = newLimit - limit();
      limit(dynamicOffsetLength);
      length(size$);
      limit(newLimit);
      lastFieldSet = INDEX_PAYLOAD;
      return this;
    }

    public Builder payload(DirectBuffer buffer, int offset, int length) {
      OctetsFW.Builder payloadRW = payload();
      payloadRW.set(buffer, offset, length);
      int newLimit = payloadRW.build().limit();
      int size$ = newLimit - limit();
      limit(dynamicOffsetLength);
      length(size$);
      limit(newLimit);
      lastFieldSet = INDEX_PAYLOAD;
      return this;
    }

    private OctetsFW.Builder extension() {
      if (lastFieldSet < INDEX_PAYLOAD) {
        payload(b -> { });
        int limit = limit();
        limit(dynamicOffsetLength);
        length(-1);
        limit(limit);
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
      dynamicOffsetLength = -1;
      lastFieldSet = -1;
      limit(offset);
      return this;
    }

    @Override
    public Builder wrap(ArrayFW.Builder<?, ?, ?> array) {
      super.wrap(array);
      dynamicOffsetLength = -1;
      lastFieldSet = -1;
      return this;
    }

    @Override
    public Builder rewrap() {
      super.rewrap();
      return this;
    }

    @Override
    public DataFW build() {
      if (lastFieldSet < INDEX_EXTENSION) {
        extension(b -> { });
      }
      assert lastFieldSet == FIELD_COUNT - 1;
      lastFieldSet = -1;
      return super.build();
    }
  }
}
