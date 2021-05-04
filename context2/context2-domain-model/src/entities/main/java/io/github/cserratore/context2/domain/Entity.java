package io.github.cserratore.context2.domain;


/**
 * A generic domain model Entity.
 * 
 */
class Entity {

  /**
   * A factory method to construct an Entity.
   * @return
   */
  static Entity build(final ValueObject aValueObject) {
    return new Entity(aValueObject);
  }

  
  /** 
   * Update the Entity's value object.
   * @param aValueObject
   */
  void updateValueObject(final ValueObject aValueObject) {
    this.valueObject = aValueObject;

    DomainEventPublisher
      .instance()
      .publish(EntityValueObjectUpdated.build(this.id, this.valueObject));
  }
  
  /** 
   * Query the Entity's ID.
   * @return EntityId
   */
  EntityId id() {
    return id;
  }

  
  /** 
   * Query the Entity's value object.
   * @return ValueObject
   */
  ValueObject valueObject() {
    return valueObject;
  }


  private EntityId id;
  private ValueObject valueObject;

  private void setId(final EntityId anEntityId) {
    this.id = anEntityId;
  }

  private void setValueObject(final ValueObject aValueObject) {
    this.valueObject = aValueObject;
  }
  
  private Entity(final ValueObject aValueObject) {
    setId(EntityId.build());
    setValueObject(aValueObject);

    DomainEventPublisher
      .instance()
      .publish(EntityCreated.build(this.id));
  }

}