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

### Chapter 8. Template Method Pattern

```mermaid
classDiagram
    class CaffeineBeverage {
        +prepareRecipe()
        +boilWater()
        +pourInCup()
        +addCondiments()
    }
    class Tea {
        +addCondiments()
        +brew()
    }
    class Coffee {
        +addCondiments()
        +brew()
    }
    CaffeineBeverage <|-- Tea : extends
    CaffeineBeverage <|-- Coffee : extends
```

```mermaid
classDiagram
    class MyFrame {
        +paint(Graphics graphics)
    }
    JFrame <|-- MyFrame : extends
```

```mermaid
classDiagram
    class MyStringList {
        +size()
        +get(int index)
        +subList(int fromIndex, int toIndex)
    }
    AbstractList <|-- MyStringList : extends
```

### Chapter 9. Iterator and Composite Pattern

#### Iterator Pattern

```mermaid
classDiagram
    class Menu {
        <<interface>>
        +createIterator() Iterator
    }
    class MenuItem {
        -name: String
        -description: String
        -vegetarian: boolean
        -price: double
        +getName() String
        +getDescription() String
        +isVegetarian() boolean
        +getPrice() double
    }
    class DinerMenu {
        -menuItems: MenuItem[]
        -numberOfItems: int
        +addItem(name, description, vegetarian, price)
        +createIterator() Iterator
    }
    class PancakeHouseMenu {
        -menuItems: ArrayList
        +addItem(name, description, vegetarian, price)
        +createIterator() Iterator
    }
    class CafeMenu {
        -menuItems: HashMap
        +addItem(name, description, vegetarian, price)
        +createIterator() Iterator
    }
    class DinerMenuIterator {
        -items: MenuItem[]
        -position: int
        +hasNext() boolean
        +next() MenuItem
    }
    class Waitress {
        -menus: Menu[]
        +printMenu()
    }
    
    Menu <|.. DinerMenu
    Menu <|.. PancakeHouseMenu
    Menu <|.. CafeMenu
    DinerMenu --> MenuItem
    PancakeHouseMenu --> MenuItem
    CafeMenu --> MenuItem
    DinerMenu --> DinerMenuIterator
    Waitress --> Menu
```

#### Composite Pattern

```mermaid
classDiagram
    class MenuComponent {
        <<abstract>>
        +add(menuComponent)
        +remove(menuComponent)
        +getChild(i) MenuComponent
        +getName() String
        +getDescription() String
        +getPrice() double
        +isVegetarian() boolean
        +print()
    }
    class MenuItem {
        -name: String
        -description: String
        -vegetarian: boolean
        -price: double
        +getName() String
        +getDescription() String
        +getPrice() double
        +isVegetarian() boolean
        +print()
    }
    class Menu {
        -menuComponents: List~MenuComponent~
        -name: String
        -description: String
        +add(menuComponent)
        +remove(menuComponent)
        +getChild(i) MenuComponent
        +getName() String
        +getDescription() String
        +print()
    }
    class Waitress {
        -allMenus: MenuComponent
        +printVegetarianMenu()
    }
    
    MenuComponent <|-- MenuItem
    MenuComponent <|-- Menu
    Menu *-- MenuComponent
    Waitress --> MenuComponent
```

### Chapter 10. State Pattern

```mermaid
classDiagram
    class State {
        <<interface>>
        +insertQuarter()
        +ejectQuarter()
        +turnCrank()
        +dispense()
    }

    class GumballMachine {
        -soldOutState: State
        -noQuarterState: State
        -hasQuarterState: State
        -soldState: State
        -winnerState: State
        -state: State
        -count: int
        +insertQuarter()
        +ejectQuarter()
        +turnCrank()
        +setState(state)
        +releaseBall()
        +getCount() int
        +getSoldOutState() State
        +getNoQuarterState() State
        +getHasQuarterState() State
        +getSoldState() State
        +getWinnerState() State
    }

    class NoQuarterState {
        -gumballMachine: GumballMachine
        +insertQuarter()
        +ejectQuarter()
        +turnCrank()
        +dispense()
    }
    class HasQuarterState {
        -randomWinner: Random
        -gumballMachine: GumballMachine
        +insertQuarter()
        +ejectQuarter()
        +turnCrank()
        +dispense()
    }
    class SoldState {
        -gumballMachine: GumballMachine
        +insertQuarter()
        +ejectQuarter()
        +turnCrank()
        +dispense()
    }
    class SoldOutState {
        -gumballMachine: GumballMachine
        +insertQuarter()
        +ejectQuarter()
        +turnCrank()
        +dispense()
    }
    class WinnerState {
        -gumballMachine: GumballMachine
        +insertQuarter()
        +ejectQuarter()
        +turnCrank()
        +dispense()
    }

    State <|.. NoQuarterState
    State <|.. HasQuarterState
    State <|.. SoldState
    State <|.. SoldOutState
    State <|.. WinnerState

    GumballMachine o-- NoQuarterState
    GumballMachine o-- HasQuarterState
    GumballMachine o-- SoldState
    GumballMachine o-- SoldOutState
    GumballMachine o-- WinnerState
    GumballMachine --> State : uses
    NoQuarterState --> GumballMachine
    HasQuarterState --> GumballMachine
    SoldState --> GumballMachine
    SoldOutState --> GumballMachine
    WinnerState --> GumballMachine
```
