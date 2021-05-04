package io.github.cserratore.context2.domain;

import java.util.Date;

class StoredEvent {

  static StoredEvent build(
    final String aTypeName,
    final Date anOccurredOnDate,
    final String anEventBody,
    final long anEventIdSequence) {
      return new StoredEvent(
        aTypeName,
        anOccurredOnDate,
        anEventBody,
        anEventIdSequence);
  }

  long getEventIdSequence() {
    return eventIdSequence;
  }
  
  String getEventBody() {
    return eventBody;
  }
  
  Date getOccurredOn() {
    return occurredOn;
  }

  String getTypeName() {
    return typeName;
  }

  private String eventBody;
  private Date occurredOn;
  private String typeName;
  private long eventIdSequence;

  private StoredEvent(
    final String aTypeName,
    final Date anOccurredOnDate,
    final String anEventBody,
    final long anEventIdSequence) {
      this();
      this.setTypeName(aTypeName);
      this.setOccurredOn(anOccurredOnDate);
      this.setEventBody(anEventBody);
      this.setEventIdSequence(anEventIdSequence);
  }

  private StoredEvent() {
    super();

    this.setEventIdSequence(-1L);
  }

  private void setEventBody(final String eventBody) {
    this.eventBody = eventBody;
  }

  void setEventIdSequence(long anEventIdSequence) {
    this.eventIdSequence = anEventIdSequence;
  }

  private void setOccurredOn(final Date occurredOn) {
    this.occurredOn = occurredOn;
  }

  private void setTypeName(final String typeName) {
    this.typeName = typeName;
  }

  

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((eventBody == null) ? 0 : eventBody.hashCode());
    result = prime * result + (int) (eventIdSequence ^ (eventIdSequence >>> 32));
    result = prime * result + ((occurredOn == null) ? 0 : occurredOn.hashCode());
    result = prime * result + ((typeName == null) ? 0 : typeName.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    StoredEvent other = (StoredEvent) obj;
    if (eventBody == null) {
      if (other.eventBody != null)
        return false;
    } else if (!eventBody.equals(other.eventBody))
      return false;
    if (eventIdSequence != other.eventIdSequence)
      return false;
    if (occurredOn == null) {
      if (other.occurredOn != null)
        return false;
    } else if (!occurredOn.equals(other.occurredOn))
      return false;
    if (typeName == null) {
      if (other.typeName != null)
        return false;
    } else if (!typeName.equals(other.typeName))
      return false;
    return true;
  }

      
}
