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

Registry.init("io.github.cserratore.context1.domain.HashMapEntityRepository");
ProvisionEntityUseCase provisionEntityUseCase = ProvisionEntityUseCase.build();
QueryEntityValueObjectUseCase queryEntityValueObjectUseCase = QueryEntityValueObjectUseCase.build();
UpdateEntityValueObjectUseCase updateEntityValueObjectUseCase = UpdateEntityValueObjectUseCase.build();

EntityIdOutputPort entityIdOutputPort = new StdOutEntityIdOutputAdapter();
ValueObjectOutputPort valueObjectOutputPort = new StdOutValueObjectOutputAdapter();

provisionEntityUseCase.provisionEntity(new ProvisionEntityCommand("Hello", 111, true), entityIdOutputPort)
String entity1Id = entityIdOutputPort.getEntityIdDTO().id;
queryEntityValueObjectUseCase.queryEntityValueObject(new EntityValueObjectQuery(entity1Id), valueObjectOutputPort)
updateEntityValueObjectUseCase.updateEntityValueObject(new UpdateEntityValueObjectCommand(entity1Id, "Goodbye", 222, false))
queryEntityValueObjectUseCase.queryEntityValueObject(new EntityValueObjectQuery(entity1Id), valueObjectOutputPort)