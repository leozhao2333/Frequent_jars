// TODO: license
package org.reaktivity.nukleus.echo.internal.types;

import java.nio.ByteOrder;
import org.agrona.BitUtil;
import org.agrona.DirectBuffer;
import org.agrona.MutableDirectBuffer;
import org.agrona.concurrent.UnsafeBuffer;

public final class BoundedOctets16FW extends BoundedOctetsFW {
  private static final int LENGTH_SIZE = BitUtil.SIZE_OF_SHORT;

  private static final int LENGTH_OFFSET = 0;

  private static final int VALUE_OFFSET = LENGTH_OFFSET + LENGTH_SIZE;

  private final DirectBuffer valueRO = new UnsafeBuffer(0L, 0);

  private final ByteOrder byteOrder;

  public BoundedOctets16FW() {
    this.byteOrder = ByteOrder.nativeOrder();
  }

  public BoundedOctets16FW(ByteOrder byteOrder) {
    this.byteOrder = byteOrder;
  }

  @Override
  public <T> T get(Flyweight.Visitor<T> visitor) {
    return visitor.visit(buffer(), offset() + VALUE_OFFSET, limit());
  }

  @Override
  public DirectBuffer value() {
    return valueRO;
  }

  @Override
  public int length() {
    return buffer().getShort(offset() + LENGTH_OFFSET, byteOrder) & 0xFFFF;
  }

  @Override
  public BoundedOctets16FW tryWrap(DirectBuffer buffer, int offset, int maxLimit) {
    if (super.tryWrap(buffer, offset, maxLimit) == null) {
      return null;
    }
    valueRO.wrap(buffer, offset + VALUE_OFFSET, length());
    if (limit() > maxLimit) {
      return null;
    }
    return this;
  }

  @Override
  public BoundedOctets16FW wrap(DirectBuffer buffer, int offset, int maxLimit) {
    super.wrap(buffer, offset, maxLimit);
    valueRO.wrap(buffer, offset + VALUE_OFFSET, length());
    checkLimit(limit(), maxLimit);
    return this;
  }

  @Override
  public int limit() {
    return offset() + LENGTH_SIZE + length();
  }

  @Override
  public String toString() {
    return String.format("boundedOctets16[%d]", length());
  }

  public static final class Builder extends BoundedOctetsFW.Builder<BoundedOctets16FW> {
    private final ByteOrder byteOrder;

    public Builder() {
      super(new BoundedOctets16FW());
      this.byteOrder = ByteOrder.nativeOrder();
    }

    public Builder(ByteOrder byteOrder) {
      super(new BoundedOctets16FW(byteOrder));
      this.byteOrder = byteOrder;
    }

    @Override
    public Builder set(BoundedOctetsFW value) {
      int newLimit = offset() + LENGTH_SIZE + value.length();
      checkLimit(newLimit, maxLimit());
      buffer().putShort(offset() + LENGTH_OFFSET, (short) (value.length() & 0xFFFF), byteOrder);
      buffer().putBytes(offset() + VALUE_OFFSET, value.buffer(), value.offset() + VALUE_OFFSET, value.length());
      limit(newLimit);
      return this;
    }

    @Override
    public Builder set(DirectBuffer value, int offset, int length) {
      int newLimit = offset() + LENGTH_SIZE + length;
      checkLimit(newLimit, maxLimit());
      buffer().putShort(offset() + LENGTH_OFFSET, (short) (length & 0xFFFF), byteOrder);
      buffer().putBytes(offset() + VALUE_OFFSET, value, offset, length);
      limit(newLimit);
      return this;
    }

    @Override
    public Builder set(byte[] value) {
      int newLimit = offset() + LENGTH_SIZE + value.length;
      checkLimit(newLimit, maxLimit());
      buffer().putShort(offset() + LENGTH_OFFSET, (short) (value.length & 0xFFFF), byteOrder);
      buffer().putBytes(offset() + VALUE_OFFSET, value);
      limit(newLimit);
      return this;
    }

    @Override
    public Builder wrap(MutableDirectBuffer buffer, int offset, int maxLimit) {
      checkLimit(offset + LENGTH_SIZE, maxLimit);
      super.wrap(buffer, offset, maxLimit);
      return this;
    }
  }
}
