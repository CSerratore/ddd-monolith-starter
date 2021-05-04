package io.github.cserratore.context1;

import io.github.cserratore.context1.domain.EntityIdOutputPort;
import io.github.cserratore.context1.domain.EntityValueObjectQuery;
import io.github.cserratore.context1.domain.ProvisionEntityCommand;
import io.github.cserratore.context1.domain.ProvisionEntityUseCase;
import io.github.cserratore.context1.domain.QueryEntityValueObjectUseCase;
import io.github.cserratore.context1.domain.Registry;
import io.github.cserratore.context1.domain.StdOutEntityIdOutputAdapter;
import io.github.cserratore.context1.domain.StdOutValueObjectOutputAdapter;
import io.github.cserratore.context1.domain.UpdateEntityValueObjectCommand;
import io.github.cserratore.context1.domain.UpdateEntityValueObjectUseCase;
import io.github.cserratore.context1.domain.ValueObjectOutputPort;

public class Console {
  public static void main(final String[] args) throws Exception {

    init();

    System.out.println("Bounded Context 1 System Console ready");

    provisionEntityUseCase.provisionEntity(
      new ProvisionEntityCommand("Hello", 111, true), 
      entityIdOutputPort);

    final String entityId = entityIdOutputPort.getEntityIdDTO().id;

    queryEntityValueObjectUseCase.queryEntityValueObject(
      new EntityValueObjectQuery(entityId), 
      valueObjectOutputPort);

    updateEntityValueObjectUseCase.updateEntityValueObject(
      new UpdateEntityValueObjectCommand(
        entityId, "Goodbye", 222, false));

    queryEntityValueObjectUseCase.queryEntityValueObject(
      new EntityValueObjectQuery(entityId), 
      valueObjectOutputPort);
    
  }

  private static void init() {
    Registry.init("io.github.cserratore.context1.domain.HashMapEntityRepository");
    provisionEntityUseCase = ProvisionEntityUseCase.build();
    queryEntityValueObjectUseCase = QueryEntityValueObjectUseCase.build();
    updateEntityValueObjectUseCase = UpdateEntityValueObjectUseCase.build();

    entityIdOutputPort = new StdOutEntityIdOutputAdapter();
    valueObjectOutputPort = new StdOutValueObjectOutputAdapter();
  }

  private static ProvisionEntityUseCase provisionEntityUseCase;
  private static QueryEntityValueObjectUseCase queryEntityValueObjectUseCase;
  private static UpdateEntityValueObjectUseCase updateEntityValueObjectUseCase;
  private static EntityIdOutputPort entityIdOutputPort;
  private static ValueObjectOutputPort valueObjectOutputPort;
}
