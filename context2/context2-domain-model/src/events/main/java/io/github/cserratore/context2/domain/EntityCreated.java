package io.github.cserratore.context2.domain;

import java.util.Date;

class EntityCreated implements DomainEvent {

  static EntityCreated build(final EntityId anEntityId) {
    return new EntityCreated(anEntityId);
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

  private EntityCreated(final EntityId anEntityId) {
    super();
    setOccurredOn(new Date());
    setEntityId(anEntityId);
  }

  private void setOccurredOn(final Date aDate) {
    this.occurredOn = aDate;
  }

  private void setEntityId(final EntityId anEntityId) {
    this.entityId = anEntityId;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((entityId == null) ? 0 : entityId.hashCode());
    result = prime * result + ((occurredOn == null) ? 0 : occurredOn.hashCode());
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
    EntityCreated other = (EntityCreated) obj;
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
    return true;
  }
}
