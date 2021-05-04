package io.github.cserratore.context2.domain;

import java.util.UUID;

/**
 * A value object representing an EntityId.
 */
class EntityId {
  
  /**
   * Constructs a unique EntityId.
   * @return an instance of an EntityId
   */
  static EntityId build() {
    return new EntityId();
  }

  /**
   * Constructs an EntityId from a String representation.
   */
  static EntityId fromString(final String anEntityIdString) {
    return new EntityId(UUID.fromString(anEntityIdString));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
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
    EntityId other = (EntityId) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }


  @Override
  public String toString() {
    return id.toString();
  }


  private final UUID id;

  private EntityId() {
    this.id = UUID.randomUUID();
  }

  private EntityId(final UUID aUUID) {
    this.id = aUUID;
  }


}
