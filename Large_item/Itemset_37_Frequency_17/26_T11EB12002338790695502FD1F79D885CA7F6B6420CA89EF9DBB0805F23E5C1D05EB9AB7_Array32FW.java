// TODO: license
package org.reaktivity.nukleus.echo.internal.types;

import java.nio.ByteOrder;
import java.util.function.Consumer;
import java.util.function.Predicate;
import org.agrona.BitUtil;
import org.agrona.DirectBuffer;
import org.agrona.MutableDirectBuffer;
import org.agrona.concurrent.UnsafeBuffer;

public final class Array32FW<V extends Flyweight> extends ArrayFW<V> {
  private static final int LENGTH_SIZE = BitUtil.SIZE_OF_INT;

  private static final int FIELD_COUNT_SIZE = BitUtil.SIZE_OF_INT;

  private static final int LENGTH_OFFSET = 0;

  private static final int FIELD_COUNT_OFFSET = LENGTH_OFFSET + LENGTH_SIZE;

  private static final int FIELDS_OFFSET = FIELD_COUNT_OFFSET + FIELD_COUNT_SIZE;

  private static final DirectBuffer EMPTY_BUFFER = new UnsafeBuffer();

  private final ByteOrder byteOrder;

  private final V itemRO;

  private final DirectBuffer itemsRO = new UnsafeBuffer(0L, 0);

  private int maxLength;

  public Array32FW(V itemRO) {
    this.itemRO = itemRO;
    this.byteOrder = ByteOrder.nativeOrder();
  }

  public Array32FW(V itemRO, ByteOrder byteOrder) {
    this.itemRO = itemRO;
    this.byteOrder = byteOrder;
  }

  @Override
  public int length() {
    return buffer().getInt(offset() + LENGTH_OFFSET, byteOrder);
  }

  @Override
  public int fieldsOffset() {
    return offset() + FIELDS_OFFSET;
  }

  @Override
  public int fieldCount() {
    return buffer().getInt(offset() + FIELD_COUNT_OFFSET, byteOrder);
  }

  @Override
  public int maxLength() {
    return maxLength;
  }

  @Override
  public void forEach(Consumer<? super V> consumer) {
    int offset = offset() + FIELDS_OFFSET;
    for (int i = 0; i < fieldCount(); i++) {
      itemRO.wrap(buffer(), offset, limit(), this);
      consumer.accept(itemRO);
      offset = itemRO.limit();
    }
  }

  @Override
  public boolean anyMatch(Predicate<? super V> predicate) {
    int offset = offset() + FIELDS_OFFSET;
    for (int i = 0; i < fieldCount(); i++) {
      itemRO.wrap(buffer(), offset, maxLimit(), this);
      if (predicate.test(itemRO)) {
        return true;
      }
      offset = itemRO.limit();
    }
    return false;
  }

  @Override
  public V matchFirst(Predicate<? super V> predicate) {
    int offset = offset() + FIELDS_OFFSET;
    for (int i = 0; i < fieldCount(); i++) {
      itemRO.wrap(buffer(), offset, maxLimit(), this);
      if (predicate.test(itemRO)) {
        return itemRO;
      }
      offset = itemRO.limit();
    }
    return null;
  }

  @Override
  public boolean isEmpty() {
    return fieldCount() == 0;
  }

  @Override
  public DirectBuffer items() {
    return itemsRO;
  }

  @Override
  public Array32FW<V> wrap(DirectBuffer buffer, int offset, int maxLimit) {
    super.wrap(buffer, offset, maxLimit);
    final int itemsSize = limit() - fieldsOffset();
    if (itemsSize == 0) {
      itemsRO.wrap(EMPTY_BUFFER, 0, 0);
    }
    else {
      itemsRO.wrap(buffer, offset + FIELDS_OFFSET, itemsSize);
    }
    checkLimit(limit(), maxLimit);
    return this;
  }

  @Override
  public Array32FW<V> tryWrap(DirectBuffer buffer, int offset, int maxLimit) {
    if (offset + FIELDS_OFFSET > maxLimit) {
      return null;
    }
    if (super.tryWrap(buffer, offset, maxLimit) == null) {
      return null;
    }
    final int itemsSize = limit() - fieldsOffset();
    if (itemsSize == 0) {
      itemsRO.wrap(EMPTY_BUFFER, 0, 0);
    }
    else {
      itemsRO.wrap(buffer, offset + FIELDS_OFFSET, itemsSize);
    }
    if (limit() > maxLimit) {
      return null;
    }
    return this;
  }

  @Override
  public int limit() {
    return offset() + LENGTH_SIZE + length();
  }

  @Override
  public String toString() {
    return String.format("array32<%d, %d>", length(), fieldCount());
  }

  @Override
  public void maxLength(int maxLength) {
    this.maxLength = maxLength;
  }

  public static final class Builder<B extends Flyweight.Builder<V>, V extends Flyweight> extends ArrayFW.Builder<Array32FW<V>, B, V> {
    private final ByteOrder byteOrder;

    private final B itemRW;

    private final V itemRO;

    private int fieldCount;

    private int maxLength;

    public Builder(B itemRW, V itemRO) {
      super(new Array32FW<>(itemRO));
      this.byteOrder = ByteOrder.nativeOrder();
      this.itemRW = itemRW;
      this.itemRO = itemRO;
    }

    public Builder(B itemRW, V itemRO, ByteOrder byteOrder) {
      super(new Array32FW<>(itemRO, byteOrder));
      this.byteOrder = byteOrder;
      this.itemRW = itemRW;
      this.itemRO = itemRO;
    }

    @Override
    public int fieldsOffset() {
      return offset() + FIELDS_OFFSET;
    }

    @Override
    public Builder<B, V> item(Consumer<B> consumer) {
      itemRW.wrap(this);
      consumer.accept(itemRW);
      itemRW.build();
      maxLength = Math.max(maxLength, itemRW.sizeof());
      checkLimit(itemRW.limit(), maxLimit());
      limit(itemRW.limit());
      fieldCount++;
      return this;
    }

    @Override
    public Builder<B, V> items(DirectBuffer buffer, int srcOffset, int length, int fieldCount,
        int maxLength) {
      buffer().putBytes(offset() + FIELDS_OFFSET, buffer, srcOffset, length);
      int newLimit = offset() + FIELDS_OFFSET + length;
      checkLimit(newLimit, maxLimit());
      limit(newLimit);
      this.fieldCount = fieldCount;
      this.maxLength = maxLength;
      buffer().putInt(offset() + LENGTH_OFFSET, length, byteOrder);
      buffer().putInt(offset() + FIELD_COUNT_OFFSET, fieldCount + FIELD_COUNT_SIZE, byteOrder);
      return this;
    }

    @Override
    public Builder<B, V> wrap(MutableDirectBuffer buffer, int offset, int maxLimit) {
      super.wrap(buffer, offset, maxLimit);
      int newLimit = offset + FIELDS_OFFSET;
      checkLimit(newLimit, maxLimit);
      limit(newLimit);
      fieldCount = 0;
      maxLength = 0;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Array32FW<V> build() {
      int length = limit() - offset() - FIELD_COUNT_OFFSET;
      buffer().putInt(offset() + LENGTH_OFFSET, length, byteOrder);
      buffer().putInt(offset() + FIELD_COUNT_OFFSET, fieldCount, byteOrder);
      final ArrayFW<V> array = super.build();
      final int maxLimit = maxLimit();
      limit(fieldsOffset());
      int itemOffset = fieldsOffset();
      itemRW.reset(this);
      for (int i = 0; i < fieldCount; i++) {
        final Flyweight item = itemRO.wrap(buffer(), itemOffset, maxLimit, array);
        itemOffset = item.limit();
        final Flyweight newItem = itemRW.wrap(this).rebuild((V) item, maxLength);
        final int newLimit = newItem.limit();
        assert newLimit <= itemOffset;
        limit(newLimit);
      }
      length = limit() - offset() - FIELD_COUNT_OFFSET;
      buffer().putInt(offset() + LENGTH_OFFSET, length, byteOrder);
      final Array32FW<V> array32 = super.build();
      array32.maxLength(maxLength);
      return array32;
    }
  }
}
