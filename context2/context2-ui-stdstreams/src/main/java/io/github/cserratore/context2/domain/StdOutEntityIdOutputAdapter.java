package io.github.cserratore.context2.domain;

public class StdOutEntityIdOutputAdapter implements EntityIdOutputPort {

  @Override
  public void write(EntityIdDTO anEntityIdDTO) {
    entityIdDTO = anEntityIdDTO;

    System.out.println(
      "\"EntityId\":\"" + entityIdDTO.id + "\"");
  }


  @Override
  public EntityIdDTO getEntityIdDTO() {
    return entityIdDTO;
  }

  private EntityIdDTO entityIdDTO;  
}
