package io.github.cserratore.context2.domain;

interface EventSerializer {

  String serialize(DomainEvent aDomainEvent);

  <T extends DomainEvent> T deserialize(String aSerialization, final Class<T> aType);
}
