package io.github.cserratore.context2.domain;

import java.util.Date;

class EntityValueObjectUpdated implements DomainEvent {

  static EntityValueObjectUpdated build(
    final EntityId anEntityId,
    final ValueObject aValueObject) {
    return new EntityValueObjectUpdated(anEntityId, aValueObject);
  }

  @Override
  public Date occurredOn() {
    return this.occurredOn;
  }

  EntityId entityId() {
    return this.entityId;
  }

  private Date occurredOn;
  private EntityId entityId;
  private ValueObject valueObject;

  private EntityValueObjectUpdated(
    final EntityId anEntityId,
    final ValueObject aValueObject) {
    super();
    setOccurredOn(new Date());
    setEntityId(anEntityId);
    setValueObject(aValueObject);
  }

  private void setOccurredOn(final Date aDate) {
    this.occurredOn = aDate;
  }

  private void setEntityId(final EntityId anEntityId) {
    this.entityId = anEntityId;
  }

  private void setValueObject(final ValueObject aValueObject) {
    this.valueObject = aValueObject;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((entityId == null) ? 0 : entityId.hashCode());
    result = prime * result + ((occurredOn == null) ? 0 : occurredOn.hashCode());
    result = prime * result + ((valueObject == null) ? 0 : valueObject.hashCode());
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
    EntityValueObjectUpdated other = (EntityValueObjectUpdated) obj;
    if (entityId == null) {
      if (other.entityId != null)
        return false;
    } else if (!entityId.equals(other.entityId))
      return false;
    if (occurredOn == null) {
      if (other.occurredOn != null)
        return false;
    } else if (!occurredOn.equals(other.occurredOn))
      return false;
    if (valueObject == null) {
      if (other.valueObject != null)
        return false;
    } else if (!valueObject.equals(other.valueObject))
      return false;
    return true;
  }
}
