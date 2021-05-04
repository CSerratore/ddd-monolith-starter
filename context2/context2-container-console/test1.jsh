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

Registry.init("io.github.cserratore.context2.domain.HashMapEntityRepository");
EventRegistry.init(
    "io.github.cserratore.context2.domain.GsonEventSerializer",
    "io.github.cserratore.context2.domain.ArrayListEventStore");

ProvisionEntityUseCase provisionEntityUseCase = ProvisionEntityUseCase.build();
QueryEntityValueObjectUseCase queryEntityValueObjectUseCase = QueryEntityValueObjectUseCase.build();
UpdateEntityValueObjectUseCase updateEntityValueObjectUseCase = UpdateEntityValueObjectUseCase.build();
DomainEventUseCase domainEventUseCase = DomainEventUseCase.build();
QueryDomainEventCountUseCase queryDomainEventCountUseCase = QueryDomainEventCountUseCase.build();
QueryDomainEventListUseCase queryDomainEventListUseCase = QueryDomainEventListUseCase.build();

EntityIdOutputPort entityIdOutputPort = new StdOutEntityIdOutputAdapter();
ValueObjectOutputPort valueObjectOutputPort = new StdOutValueObjectOutputAdapter();
DomainEventOutputPort domainEventOutputPort = new StdOutDomainEventOutputAdapter();

domainEventUseCase.subscribe();
provisionEntityUseCase.provisionEntity(new ProvisionEntityCommand("Hello", 111, true), entityIdOutputPort)
String entity1Id = entityIdOutputPort.getEntityIdDTO().id;
queryEntityValueObjectUseCase.queryEntityValueObject(new EntityValueObjectQuery(entity1Id), valueObjectOutputPort)
updateEntityValueObjectUseCase.updateEntityValueObject(new UpdateEntityValueObjectCommand(entity1Id, "Goodbye", 222, false))
queryEntityValueObjectUseCase.queryEntityValueObject(new EntityValueObjectQuery(entity1Id), valueObjectOutputPort);
queryDomainEventCountUseCase.queryDomainEventCount(domainEventOutputPort);
queryDomainEventListUseCase.queryDomainEventList(domainEventOutputPort);
    