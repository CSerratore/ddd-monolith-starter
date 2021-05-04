package io.github.cserratore.context2.domain;

import java.util.Date;

public class DomainEventListItemDTO {

  public DomainEventListItemDTO(
    long anEventIdSequence,
    Date anOccurredOn,
    String aTypeName) {
    this.eventIdSequence = anEventIdSequence;
    this.occurredOn = anOccurredOn;
    this.typeName = aTypeName;
  }

  public long eventIdSequence;
  public Date occurredOn;
  public String typeName;

}
