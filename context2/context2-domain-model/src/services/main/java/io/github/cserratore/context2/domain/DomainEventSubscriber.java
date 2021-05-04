package io.github.cserratore.context2.domain;

interface DomainEventSubscriber<T> {

  void handleEvent(final T aDomainEvent);
  
  Class<T> subscribedToEventType();
}