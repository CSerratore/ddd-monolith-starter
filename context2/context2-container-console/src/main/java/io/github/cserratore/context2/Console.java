package io.github.cserratore.context2;

import io.github.cserratore.context2.domain.DomainEventOutputPort;
import io.github.cserratore.context2.domain.DomainEventUseCase;
import io.github.cserratore.context2.domain.EntityIdOutputPort;
import io.github.cserratore.context2.domain.EntityValueObjectQuery;
import io.github.cserratore.context2.domain.EventRegistry;
import io.github.cserratore.context2.domain.ProvisionEntityCommand;
import io.github.cserratore.context2.domain.ProvisionEntityUseCase;
import io.github.cserratore.context2.domain.QueryDomainEventCountUseCase;
import io.github.cserratore.context2.domain.QueryDomainEventListUseCase;
import io.github.cserratore.context2.domain.QueryEntityValueObjectUseCase;
import io.github.cserratore.context2.domain.Registry;
import io.github.cserratore.context2.domain.StdOutDomainEventOutputAdapter;
import io.github.cserratore.context2.domain.StdOutEntityIdOutputAdapter;
import io.github.cserratore.context2.domain.StdOutValueObjectOutputAdapter;
import io.github.cserratore.context2.domain.UpdateEntityValueObjectCommand;
import io.github.cserratore.context2.domain.UpdateEntityValueObjectUseCase;
import io.github.cserratore.context2.domain.ValueObjectOutputPort;

public class Console {
  public static void main(final String[] args) throws Exception {

    init();

    System.out.println("Bounded Context 2 System Console ready");

    domainEventUseCase.subscribe();

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

    queryDomainEventCountUseCase.queryDomainEventCount(domainEventOutputPort);
    queryDomainEventListUseCase.queryDomainEventList(domainEventOutputPort);
    
  }

  private static void init() {
    Registry.init("io.github.cserratore.context2.domain.HashMapEntityRepository");
    EventRegistry.init(
      "io.github.cserratore.context2.domain.GsonEventSerializer",
      "io.github.cserratore.context2.domain.ArrayListEventStore");
    provisionEntityUseCase = ProvisionEntityUseCase.build();
    queryEntityValueObjectUseCase = QueryEntityValueObjectUseCase.build();
    updateEntityValueObjectUseCase = UpdateEntityValueObjectUseCase.build();
    domainEventUseCase = DomainEventUseCase.build();
    queryDomainEventCountUseCase = QueryDomainEventCountUseCase.build();
    queryDomainEventListUseCase = QueryDomainEventListUseCase.build();


    entityIdOutputPort = new StdOutEntityIdOutputAdapter();
    valueObjectOutputPort = new StdOutValueObjectOutputAdapter();
    domainEventOutputPort = new StdOutDomainEventOutputAdapter();
  }

  private static ProvisionEntityUseCase provisionEntityUseCase;
  private static QueryEntityValueObjectUseCase queryEntityValueObjectUseCase;
  private static UpdateEntityValueObjectUseCase updateEntityValueObjectUseCase;
  private static DomainEventUseCase domainEventUseCase;
  private static QueryDomainEventCountUseCase queryDomainEventCountUseCase;
  private static QueryDomainEventListUseCase queryDomainEventListUseCase;

  private static EntityIdOutputPort entityIdOutputPort;
  private static ValueObjectOutputPort valueObjectOutputPort;
  private static DomainEventOutputPort domainEventOutputPort;
}

