package io.github.cserratore.context2.domain;

public class QueryDomainEventCountUseCase {

  public static QueryDomainEventCountUseCase build() {
    return new QueryDomainEventCountUseCase(EventRegistry.eventStore());
  }  

  public void queryDomainEventCount(DomainEventOutputPort aDomainEventOutputPort) {
    aDomainEventOutputPort.writeCount(eventStore.countStoredEvents());
  }

  EventStore eventStore;
  
  private QueryDomainEventCountUseCase(final EventStore anEventStore) {
    this.eventStore = anEventStore;
  }
}
