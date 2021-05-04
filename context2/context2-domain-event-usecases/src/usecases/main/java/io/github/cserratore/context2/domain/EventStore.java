package io.github.cserratore.context2.domain;

import java.util.List;

interface EventStore {


  void append(final DomainEvent aDomainEvent);

  long countStoredEvents();

  List<StoredEvent> allStoredEvents();

  long getNextEventIdSequence();
  
}
