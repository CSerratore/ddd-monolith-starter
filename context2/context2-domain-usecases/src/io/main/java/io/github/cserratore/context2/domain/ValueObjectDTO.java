package io.github.cserratore.context2.domain;

public class ValueObjectDTO {

  public ValueObjectDTO(
    String aStringValue,
    String anIntValue,
    String aBooleanValue) {
      this.stringValue = aStringValue;
      this.intValue = anIntValue;
      this.booleanValue = aBooleanValue;
    }

  public String stringValue;
  public String intValue;
  public String booleanValue;
}
