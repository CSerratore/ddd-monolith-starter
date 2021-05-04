package io.github.cserratore.context2.domain;

public class DomainEventUseCase {

  public static DomainEventUseCase build() {
    return new DomainEventUseCase(EventRegistry.eventStore());
  }  

  public void subscribe() {
    DomainEventPublisher
    .instance()
    .subscribe(new DomainEventSubscriber<DomainEvent>() {

      public void handleEvent(final DomainEvent aDomainEvent) {
        store(aDomainEvent);
      }

      public Class<DomainEvent> subscribedToEventType() {
        return DomainEvent.class; // all domain events
      }
    });
  }

  private void store(final DomainEvent aDomainEvent) {
    eventStore.append(aDomainEvent);
  }

  EventStore eventStore;
  
  private DomainEventUseCase(final EventStore anEventStore) {
    this.eventStore = anEventStore;
  }
}
