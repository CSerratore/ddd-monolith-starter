package io.github.cserratore.context2.domain;

public interface EntityIdOutputPort {

  public void write(EntityIdDTO anEntityIdDTO);

  public EntityIdDTO getEntityIdDTO();
  
}
