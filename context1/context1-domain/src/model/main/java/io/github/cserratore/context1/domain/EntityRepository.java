package io.github.cserratore.context1.domain;

interface EntityRepository {

  void add(Entity anEntity);

  Entity entityOfId(EntityId anEntityId);
  
}
