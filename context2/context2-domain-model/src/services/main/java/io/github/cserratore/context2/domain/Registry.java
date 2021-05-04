package io.github.cserratore.context2.domain;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Registry {

  public static void init(final String anEntityRepositoryClassName) {

    try {
      final Method build = Class.forName(anEntityRepositoryClassName).getDeclaredMethod("build", new Class<?>[0]);
      entityRepository = (EntityRepository) build.invoke(null, new Object[0]);
    } catch (
      NoSuchMethodException |
      ClassNotFoundException |
      InvocationTargetException |
      IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }

  protected static EntityRepository entityRepository() {
    return entityRepository;
  }

  private static EntityRepository entityRepository;
}
