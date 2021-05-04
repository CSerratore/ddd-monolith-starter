package io.github.cserratore.context2.domain;

import java.util.List;

public class StdOutDomainEventOutputAdapter implements DomainEventOutputPort {

  @Override
  public void writeCount(final long count) {

    System.out.println(
      "\"Count\":" + count);
  }

  @Override
  public void writeDomainEventList(List<DomainEventListItemDTO> aDomainEventListItemDTOList) {
    for (DomainEventListItemDTO aListItem: aDomainEventListItemDTOList) {
      System.out.println(
        "\"DomainEvent\":{ " +
          "\"eventIdSequence\":" + aListItem.eventIdSequence + ", " +
          "\"occurredOn\":\"" + aListItem.occurredOn.toString() + "\", " +
          "\"typeName\":\"" + aListItem.typeName + "\" }");
    }
    
  }

}
