package io.github.cserratore.context1.domain;

public interface EntityIdOutputPort {

  public void write(EntityIdDTO anEntityIdDTO);

  public EntityIdDTO getEntityIdDTO();
  
}
