# DDD Starter
A Domain Driven Design monolith starter project that facilitates domain modelling with a minimum of infrastructure dependencies.

The intention is to demonstrate a well structured clean DDD architecture, with a focus on Packaging By Feature Component, to inform the design of more complex modular monolith or microservice approaches.

## Package By Feature Component
### Scenarios
1. A bounded context as a feature component
2. A bounded context with a shared domain model supporting multiple feature components. The expectation is that the domain model is not directly accessible (package protected). This requires the following: 
   1. A (package-protected) domain model component package. 
   2. A set of proxies in aach feature component package that wrap the necessary domain model package objects in a manner that preserves the component's package protection.
3. Could a bounded context exist with multiple non-overlapping services as feature components? Theoretically, yes. However, this assumes even the domain models are completely independent. This is a questionable premise, unless it was already predetermined that these separate services are destined to spin off into separate bounded contexts. Package them individually, as instances of Scenario 1, as they belong to the same bounded context in name only.

Options for addressing Scenario 2 include the following:
1. A factory pattern that uses reflection to invoke methods within the package-protected domain model, e.g. build("package...className").
2. A factory pattern in which the feature component package adds public interfaces that only accept feature component arguments. E.g., addToWrapper(FeatureInterface arg).

## Status
Next steps:
* Create a new ddd-monolith-quickstart archetype.
