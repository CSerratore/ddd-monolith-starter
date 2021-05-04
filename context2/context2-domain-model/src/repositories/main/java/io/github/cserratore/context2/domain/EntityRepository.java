package io.github.cserratore.context2.domain;

interface EntityRepository {

  void add(Entity anEntity);

  Entity entityOfId(EntityId anEntityId);
  
}
