package io.github.cserratore.context2.domain;

/**
 * A generic value object.
 */
class ValueObject {
  
  /** 
   * @param aStringProperty
   * @param anIntegerProperty
   * @param aBooleanProperty
   * @return ValueObject
   */
  // Public Interface
  static ValueObject build(
    final String aStringProperty,
    final int anIntegerProperty,
    final boolean aBooleanProperty) {
    return new ValueObject(aStringProperty, anIntegerProperty, aBooleanProperty);
  }

  
  /** 
   * @return String
   */
  String stringProperty() {
    return this.stringProperty;
  }

  
  /** 
   * @return int
   */
  int integerProperty() {
    return this.integerProperty;
  }

  
  /** 
   * @return boolean
   */
  boolean booleanProperty() {
    return this.booleanProperty;
  }

  

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (booleanProperty ? 1231 : 1237);
    result = prime * result + integerProperty;
    result = prime * result + ((stringProperty == null) ? 0 : stringProperty.hashCode());
    return result;
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ValueObject other = (ValueObject) obj;
    if (booleanProperty != other.booleanProperty)
      return false;
    if (integerProperty != other.integerProperty)
      return false;
    if (stringProperty == null) {
      if (other.stringProperty != null)
        return false;
    } else if (!stringProperty.equals(other.stringProperty))
      return false;
    return true;
  }


  private ValueObject(
    final String aStringProperty,
    final int anIntegerProperty,
    final boolean aBooleanProperty) {
      this.stringProperty = aStringProperty;
      this.integerProperty = anIntegerProperty;
      this.booleanProperty = aBooleanProperty;
  }

  private final String stringProperty;
  private final int integerProperty;
  private final boolean booleanProperty;
}
