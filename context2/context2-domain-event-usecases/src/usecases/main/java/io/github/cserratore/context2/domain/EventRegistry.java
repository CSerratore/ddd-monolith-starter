package io.github.cserratore.context2.domain;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EventRegistry {

  public static void init(
    final String anEventSerializerClassName,
    final String anEventStoreClassName) {

    try {
      final Method eventSerializerBuild = Class.forName(anEventSerializerClassName).getDeclaredMethod("build", new Class<?>[0]);
      eventSerializer = (EventSerializer) eventSerializerBuild.invoke(null, new Object[0]);

      final Method eventStoreBuild = Class.forName(anEventStoreClassName).getDeclaredMethod("build", new Class<?>[0]);
      eventStore = (EventStore) eventStoreBuild.invoke(null, new Object[0]);
    } catch (
      NoSuchMethodException |
      ClassNotFoundException |
      InvocationTargetException |
      IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }

  static EventSerializer eventSerializer() {
    return eventSerializer;
  }

  static EventStore eventStore() {
    return eventStore;
  }

  private static EventSerializer eventSerializer;
  private static EventStore eventStore;
}
