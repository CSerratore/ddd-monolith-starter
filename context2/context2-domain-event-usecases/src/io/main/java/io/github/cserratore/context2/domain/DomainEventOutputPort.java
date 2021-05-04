package io.github.cserratore.context2.domain;

import java.util.List;

public interface DomainEventOutputPort {
  
  public void writeCount(final long count);

  public void writeDomainEventList(
    List<DomainEventListItemDTO> aDomainEventListItemDTOList);
}
