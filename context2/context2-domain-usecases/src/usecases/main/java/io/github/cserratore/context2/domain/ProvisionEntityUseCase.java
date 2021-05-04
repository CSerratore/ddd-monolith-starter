package io.github.cserratore.context2.domain;

public class ProvisionEntityUseCase {

  public static ProvisionEntityUseCase build() {
    return new ProvisionEntityUseCase(
      Registry.entityRepository());
  }

  public void provisionEntity(
    final ProvisionEntityCommand aCommand, 
    final EntityIdOutputPort anEntityIdOutputPort) {

    final Entity newEntity = Entity.build(
      ValueObject.build(
        aCommand.stringProperty, 
        aCommand.intProperty, 
        aCommand.booleanProperty));

    entityRepository.add(newEntity);
    anEntityIdOutputPort.write(
      new EntityIdDTO(newEntity.id().toString()));
  }

  private final EntityRepository entityRepository;

  private ProvisionEntityUseCase(final EntityRepository anEntityRepository) {
    this.entityRepository = anEntityRepository;
  }
  
}
