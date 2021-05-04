package io.github.cserratore.context2.domain;

public class UpdateEntityValueObjectCommand {

  public UpdateEntityValueObjectCommand(
    final String anEntityIdString,
    final String aStringProperty,
    final int anIntProperty,
    final boolean aBooleanProperty) {
      this.entityIdString = anEntityIdString;
      this.stringProperty = aStringProperty;
      this.intProperty = anIntProperty;
      this.booleanProperty = aBooleanProperty;
    }

  public final String entityIdString;
  public final String stringProperty;
  public final int intProperty;
  public final boolean booleanProperty;
}
