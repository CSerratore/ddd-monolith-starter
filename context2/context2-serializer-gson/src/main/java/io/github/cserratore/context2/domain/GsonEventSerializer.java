package io.github.cserratore.context2.domain;

import com.google.gson.Gson;

class GsonEventSerializer implements EventSerializer {

  public static GsonEventSerializer build() {
    return new GsonEventSerializer();
  }

  @Override
  public String serialize(DomainEvent aDomainEvent) {
    String serialization = gson.toJson(aDomainEvent);

    return serialization;
  }

  @Override
  public <T extends DomainEvent> T deserialize(String aSerialization, Class<T> aType) {
    T domainEvent = gson.fromJson(aSerialization, aType);

    return domainEvent;
  }
  
  private Gson gson;

  private GsonEventSerializer() {
    gson = new Gson();
  }
}
