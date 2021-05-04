package io.github.cserratore.context1.domain;

import java.util.HashMap;
import java.util.Map;

class HashMapEntityRepository implements EntityRepository {

  static EntityRepository build() {
    return new HashMapEntityRepository();
  }

  @Override
  public void add(final Entity anEntity) {
    map.put(anEntity.id(), anEntity);
    
  }

  @Override
  public Entity entityOfId(final EntityId anEntityId) {
    return map.get(anEntityId);
  }

  private final Map<EntityId, Entity> map = new HashMap<>();

  private HashMapEntityRepository() {}
}
