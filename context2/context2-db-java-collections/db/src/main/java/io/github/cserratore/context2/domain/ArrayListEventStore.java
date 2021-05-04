package io.github.cserratore.context2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

class ArrayListEventStore implements EventStore{

  static ArrayListEventStore build() {
    return new ArrayListEventStore(EventRegistry.eventSerializer());
  }

  public void append(final DomainEvent aDomainEvent) {
    final String eventSerialization = eventSerializer.serialize(aDomainEvent);

    final StoredEvent storedEvent = StoredEvent.build(
      aDomainEvent.getClass().getName(),
      aDomainEvent.occurredOn(),
      eventSerialization,
      this.getNextEventIdSequence());

    list.add(storedEvent);
  }

  public long countStoredEvents() {
    return list.size();
  }

  public List<StoredEvent> allStoredEvents() {
    return list;
  }

 public long getNextEventIdSequence() {
    return lastEventIdSequence.incrementAndGet();
  }

  private AtomicLong lastEventIdSequence = new AtomicLong();
  private EventSerializer eventSerializer;

  private List<StoredEvent> list;

  private ArrayListEventStore(EventSerializer anEventSerializer) {
    this.eventSerializer = anEventSerializer;
    this.list = new ArrayList<>();
  }
  
}
