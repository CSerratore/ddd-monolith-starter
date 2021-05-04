package io.github.cserratore.context2.domain;

import java.util.Date;

interface DomainEvent {
  Date occurredOn();
}
