package io.github.cserratore.context1.domain;

public class ProvisionEntityCommand {

  public ProvisionEntityCommand(
    final String aStringProperty,
    final int anIntProperty,
    final boolean aBooleanProperty) {
      this.stringProperty = aStringProperty;
      this.intProperty = anIntProperty;
      this.booleanProperty = aBooleanProperty;
  }


  final public String stringProperty;
  final public int intProperty;
  final public boolean booleanProperty;
}
