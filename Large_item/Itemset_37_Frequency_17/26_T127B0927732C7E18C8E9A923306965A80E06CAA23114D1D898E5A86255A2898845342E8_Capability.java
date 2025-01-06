// TODO: license
package org.reaktivity.nukleus.echo.internal.types.stream;

public enum Capability {
  CHALLENGE;

  public static Capability valueOf(int ordinal) {
    switch (ordinal) {
      case 0: {
        return CHALLENGE;
      }
    }
    return null;
  }
}
