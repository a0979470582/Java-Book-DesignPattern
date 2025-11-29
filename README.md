# Java-Book-DesignPattern

### Chapter 1. Strategy Pattern

```mermaid
classDiagram
    class Duck {
        +performFly()
        +performQuack()
        +setFlyBehavior()
        +setQuackBehavior()
    }
    class MallardDuck
    Duck <|-- MallardDuck

    class FlyBehavior {
        <<interface>>
        +fly()
    }
    class FlyWithWings
    class FlyNoWay
    FlyBehavior <|.. FlyWithWings
    FlyBehavior <|.. FlyNoWay

    class QuackBehavior {
        <<interface>>
        +quack()
    }
    class Quack
    class MuteQuack
    QuackBehavior <|.. Quack
    QuackBehavior <|.. MuteQuack

    Duck o-- FlyBehavior : uses
    Duck o-- QuackBehavior : uses
```

### Chapter 2. Observer Pattern

```mermaid
classDiagram
    class Subject {
        <<interface>>
        +registerObserver(observer)
        +removeObserver(observer)
        +notifyObservers()
    }
    class WeatherData {
        +registerObserver(observer)
        +removeObserver(observer)
        +notifyObservers()
        +setMeasurements(temperature, humidity, pressure)
        +getTemperature()
        +getHumidity()
        +getPressure()
    }
    Subject <|.. WeatherData

    class Observer {
        <<interface>>
        +update()
    }
    class CurrentConditionsDisplay {
        +update()
        +display()
    }
    Observer <|.. CurrentConditionsDisplay

    class DisplayElement {
        <<interface>>
        +display()
    }
    DisplayElement <|.. CurrentConditionsDisplay

    WeatherData o-- Observer : maintains
    CurrentConditionsDisplay o-- WeatherData : observes
```

### Chapter 3. Decorator Pattern

```mermaid
classDiagram
    class Beverage {
        <<abstract>>
        +getDescription()
        +cost()
        +setSize(size)
        +getSize()
        -description
        -size
        enum Size
    }
    class Espresso
    class HouseBlend
    Beverage <|-- Espresso
    Beverage <|-- HouseBlend

    class CondimentDecorator {
        <<abstract>>
        +getDescription()
        +cost()
        -beverage
    }
    CondimentDecorator <|-- Mocha
    CondimentDecorator <|-- Soy
    CondimentDecorator <|-- Whip

    class Mocha
    class Soy
    class Whip

    Beverage <|-- CondimentDecorator
    CondimentDecorator o-- Beverage : wraps
```

### Chapter 4. Factory Pattern

```mermaid
classDiagram
    %% Factory Method Pattern
    class PizzaStore {
        <<abstract>>
        +orderPizza(String type) Pizza
        +createPizza(String type)* Pizza
    }
    class NYPizzaStore {
        +createPizza(String type) Pizza
    }
    class ChicagoStore {
        +createPizza(String type) Pizza
    }
    PizzaStore <|-- NYPizzaStore
    PizzaStore <|-- ChicagoStore

    %% Abstract Factory Pattern
    class IngredientFactory {
        <<interface>>
        +createDough() String
        +createSauce() String
        +createToppings() String
    }
    class NYIngredientFactory {
        +createDough() String
        +createSauce() String
        +createToppings() String
    }
    class ChicagoIngredientFactory {
        +createDough() String
        +createSauce() String
        +createToppings() String
    }
    IngredientFactory <|.. NYIngredientFactory
    IngredientFactory <|.. ChicagoIngredientFactory

    %% Product
    class Pizza {
        <<abstract>>
        -String name
        -String dough
        -String sauce
        -List~String~ toppings
        +prepare() void
        +bake() void
        +cut() void
        +box() void
        +getName() String
    }
    class CheesePizza {
        -IngredientFactory ingredientFactory
        +CheesePizza(IngredientFactory, String)
        +prepare() void
    }
    Pizza <|-- CheesePizza

    %% Relations
    PizzaStore ..> Pizza : creates
    NYPizzaStore ..> CheesePizza : creates
    ChicagoStore ..> CheesePizza : creates
    NYPizzaStore ..> NYIngredientFactory : uses
    ChicagoStore ..> ChicagoIngredientFactory : uses
    CheesePizza ..> IngredientFactory : depends
```

### Chapter 5. Singleton Pattern

```mermaid
classDiagram
    class SingletonNotThreadSafe {
        -static instance : SingletonNotThreadSafe
        -SingletonNotThreadSafe()
        +getInstance() SingletonNotThreadSafe
        +clearInstance() void
    }
```

```mermaid
classDiagram
    class SingletonThreadSafe {
        -static instance : SingletonThreadSafe
        -SingletonThreadSafe()
        +getInstance() SingletonThreadSafe
        +clearInstance() void
    }
```

```mermaid
classDiagram
    class SingletonPrivateLoader {
        -SingletonPrivateLoader()
        +getInstance() SingletonPrivateLoader
        %% Holder~ is loaded lazily by JVM
    }
```

```mermaid
classDiagram
    class SingletonByEnum {
        <<enum>>
        SINGLETON
    }
```
