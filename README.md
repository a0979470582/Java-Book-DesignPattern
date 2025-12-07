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

### Chapter 6. Command Pattern

```mermaid
classDiagram
    %% Command Interface
    class Command {
        <<interface>>
        +execute()
        +undo()
    }

    %% Concrete Commands
    class LightOnCommand
    class LightOffCommand
    class StereoOnWithCDCommand
    class StereoOffWithCDCommand
    class MacroCommand {
        -Command[] commands
        +execute()
        +undo()
    }
    class NoCommand

    Command <|.. LightOnCommand
    Command <|.. LightOffCommand
    Command <|.. StereoOnWithCDCommand
    Command <|.. StereoOffWithCDCommand
    Command <|.. MacroCommand
    Command <|.. NoCommand

    %% Invokers
    class RemoteControl {
        -Command[] onCommands
        -Command[] offCommands
        -Command lastCommand
        +setCommand(int, Command, Command)
        +onButtonWasPressed(int)
        +offButtonWasPressed(int)
        +undoButtonWasPressed()
    }
    class SimpleRemoteControl {
        -Command slot
        +setCommand(Command)
        +onPressed()
    }
    RemoteControl o-- Command : holds
    SimpleRemoteControl o-- Command : slot

    %% Receivers
    class Light {
        +on()
        +off()
    }
    class Stereo {
        -int volume
        -String cd
        +on()
        +off()
        +setCD(String)
        +setVolume(int)
        +getVolume() int
        +getCD() String
    }

    LightOnCommand --> Light : receiver
    LightOffCommand --> Light : receiver
    StereoOnWithCDCommand --> Stereo : receiver
    StereoOffWithCDCommand --> Stereo : receiver
    MacroCommand o-- Command : macro
```


### Chapter 7. Adapter Pattern

#### TurkeyToDuckAdapter

```mermaid
classDiagram
    class Duck {
        <<interface>>
        +quack()
        +fly()
    }
    
    class Turkey {
        <<interface>>
        +gobble()
        +fly()
    }
    
    class TurkeyToDuckAdapter {
        -Turkey turkey
        +TurkeyToDuckAdapter(Turkey)
        +quack()
        +fly()
    }
    
    class MallardDuck {
        +quack()
        +fly()
    }
    
    class WildTurkey {
        +gobble()
        +fly()
    }
    
    Duck <|.. TurkeyToDuckAdapter
    Duck <|.. MallardDuck
    Turkey <|.. WildTurkey
    TurkeyToDuckAdapter --> Turkey : adapts
```

#### EnumerationIterator

```mermaid
classDiagram
    class Iterator {
        <<interface>>
        +hasNext() bool
        +next() Object
        +remove()
    }
    
    class Enumeration {
        <<interface>>
        +hasMoreElements() bool
        +nextElement() Object
    }
    
    class EnumerationIterator {
        -Enumeration enumeration
        +EnumerationIterator(Enumeration)
        +hasNext() bool
        +next() Object
        +remove()
    }
    
    Iterator <|.. EnumerationIterator
    EnumerationIterator --> Enumeration : wraps
```

#### HomeTheaterFacade

```mermaid
classDiagram
    class HomeTheaterFacade {
        -Amplifier amplifier
        -Tuner tuner
        -DvdPlayer dvdPlayer
        -CdPlayer cdPlayer
        -Projector projector
        -TheaterLights theaterLights
        +watchMovie(String)
        +endMovie()
    }
    
    class Amplifier {
        +on()
        +off()
        +setDvd(DvdPlayer)
        +setSurroundSound()
        +setVolume(int)
    }
    
    class Tuner {
    }
    
    class DvdPlayer {
        +on()
        +off()
        +play(String)
        +stop()
        +eject()
    }
    
    class CdPlayer {
    }
    
    class Projector {
        +on()
        +off()
    }
    
    class TheaterLights {
        +on()
        +dim(int)
    }
    
    HomeTheaterFacade --> Amplifier
    HomeTheaterFacade --> Tuner
    HomeTheaterFacade --> DvdPlayer
    HomeTheaterFacade --> CdPlayer
    HomeTheaterFacade --> Projector
    HomeTheaterFacade --> TheaterLights
```
