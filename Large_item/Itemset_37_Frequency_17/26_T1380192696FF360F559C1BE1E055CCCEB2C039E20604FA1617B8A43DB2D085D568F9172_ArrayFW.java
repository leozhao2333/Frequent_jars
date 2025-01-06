// TODO: license
package org.reaktivity.nukleus.echo.internal.types;

import java.util.function.Consumer;
import java.util.function.Predicate;
import org.agrona.DirectBuffer;

public abstract class ArrayFW<V extends Flyweight> extends Flyweight {
  public abstract int length();

  public abstract int fieldCount();

  public abstract int fieldsOffset();

  public abstract int maxLength();

  public abstract void forEach(Consumer<? super V> consumer);

  public abstract boolean anyMatch(Predicate<? super V> predicate);

  public abstract V matchFirst(Predicate<? super V> predicate);

  public abstract boolean isEmpty();

  public abstract DirectBuffer items();

  public abstract void maxLength(int maxLength);

  public abstract static class Builder<T extends ArrayFW<V>, B extends Flyweight.Builder<V>, V extends Flyweight> extends Flyweight.Builder<T> {
    public Builder(T flyweight) {
      super(flyweight);
    }

    public abstract Builder<T, B, V> item(Consumer<B> consumer);

    public abstract Builder<T, B, V> items(DirectBuffer buffer, int srcOffset, int length,
        int fieldCount, int maxLength);

    public abstract int fieldsOffset();
  }
}
