package io.github.cserratore.context2.domain;

public class StdOutValueObjectOutputAdapter implements ValueObjectOutputPort {

  @Override
  public void write(ValueObjectDTO aValueObjectDTO) {

    System.out.println(
      "\"ValueObject\":{ " +
        "\"stringValue\":\"" + aValueObjectDTO.stringValue + "\", " +
        "\"intValue\":" + String.valueOf(aValueObjectDTO.intValue) + ", " +
        "\"booleanValue\":" + String.valueOf(aValueObjectDTO.booleanValue) +
        " }");
  }
}
