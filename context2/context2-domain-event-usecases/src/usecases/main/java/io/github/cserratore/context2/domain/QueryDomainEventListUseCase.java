package io.github.cserratore.context2.domain;

import java.util.ArrayList;
import java.util.List;

public class QueryDomainEventListUseCase {

  public static QueryDomainEventListUseCase build() {
    return new QueryDomainEventListUseCase(EventRegistry.eventStore());
  }  

  public void queryDomainEventList(
    DomainEventOutputPort aDomainEventOutputPort) {

    List<DomainEventListItemDTO> result = new ArrayList<>();

    for (StoredEvent aStoredEvent : eventStore.allStoredEvents()) {
      result.add(new DomainEventListItemDTO(
        aStoredEvent.getEventIdSequence(), 
        aStoredEvent.getOccurredOn(), 
        aStoredEvent.getTypeName()));
    }
    
    aDomainEventOutputPort.writeDomainEventList(result);
  }

  EventStore eventStore;
  
  private QueryDomainEventListUseCase(final EventStore anEventStore) {
    this.eventStore = anEventStore;
  }
}
