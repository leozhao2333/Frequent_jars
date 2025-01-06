// TODO: license
package org.reaktivity.nukleus.echo.internal.types.stream;

import org.agrona.DirectBuffer;
import org.agrona.MutableDirectBuffer;
import org.reaktivity.nukleus.echo.internal.types.ArrayFW;
import org.reaktivity.nukleus.echo.internal.types.Flyweight;

public final class ExtensionFW extends Flyweight {
  public static final int FIELD_OFFSET_TYPE_ID = 0;

  private static final int FIELD_SIZE_TYPE_ID = 4;

  public int typeId() {
    return buffer().getInt(offset() + FIELD_OFFSET_TYPE_ID);
  }

  @Override
  public ExtensionFW wrap(DirectBuffer buffer, int offset, int maxLimit) {
    super.wrap(buffer, offset, maxLimit);
    checkLimit(limit(), maxLimit);
    return this;
  }

  @Override
  public ExtensionFW tryWrap(DirectBuffer buffer, int offset, int maxLimit) {
    if (null == super.tryWrap(buffer, offset, maxLimit)) {
      return null;
    }
    if (limit() > maxLimit) {
      return null;
    }
    return this;
  }

  @Override
  public int limit() {
    return offset() + FIELD_OFFSET_TYPE_ID + FIELD_SIZE_TYPE_ID;
  }

  @Override
  public String toString() {
    return String.format("EXTENSION [typeId=%d]", typeId());
  }

  public static final class Builder extends Flyweight.Builder<ExtensionFW> {
    private static final int INDEX_TYPE_ID = 0;

    private static final int FIELD_COUNT = 1;

    private int lastFieldSet = -1;

    public Builder() {
      super(new ExtensionFW());
    }

    public Builder typeId(int value) {
      assert lastFieldSet == INDEX_TYPE_ID - 1;
      int newLimit = limit() + FIELD_SIZE_TYPE_ID;
      checkLimit(newLimit, maxLimit());
      buffer().putInt(limit(), value);
      lastFieldSet = INDEX_TYPE_ID;
      limit(newLimit);
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
    public ExtensionFW build() {
      assert lastFieldSet == FIELD_COUNT - 1;
      lastFieldSet = -1;
      return super.build();
    }
  }
}
