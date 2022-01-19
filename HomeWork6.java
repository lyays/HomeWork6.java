/**
 * GU_QA_1524 (08.06.2021)
 * Java 1. Homework #6
 *
 * @author Nurgalina Lyaysan
 * @version 11.01.2022 - 12.01.2021
 *
 */

public class HomeWork6 {
    public static void main(String[]args) {
        //        IAnimal cat = new Cat("Murka", "white", 2, 200, 0);  //общий тип
        //        IAnimal dog = new Dog("Tuzik", "black", 6, 500, 10);
        Cat cat = new Cat(200);
        Dog dog = new Dog(500, 10);
        IAnimal[] animals = {cat, dog};
        for (IAnimal a: animals) { //переменная с типом, внутри 3 элемента, с права : перебираемый по элементно(список, массив), и засылает в перем-ю а соотв-й элемент списка
            System.out.println(a);
            //  System.out.println(a.voice());
            System.out.println(a.run(100));
            System.out.println(a.run(300));
            System.out.println(a.run(600));

            System.out.println(a.swim(5));
            System.out.println(a.swim(15));
        }
        System.out.println("Animals were created: " + Animal.getCountOfAnimals());
    }
}

class Cat extends Animal {
    Cat(int runLimit, int swimLimit) {
        super(runLimit, swimLimit);
    }
    //    Cat (String name, String color, int age, int runLimit, int swimLimit) {
    //        super(name, color, age, runLimit, swimLimit);
    //    }
    //    @Override
    //    public String voice () {
    //        return "meow!";
    //    }
    Cat(int runLimit) {
        super(runLimit, -1);
    }

    @ Override
    public String swim(int distance) {
        return getClassName() + " can't swim ";
    }
}

class Dog extends Animal {
    Dog(int runLimit, int swimLimit) {
        super(runLimit, swimLimit);
    }
    //    Dog (String name, String color, int age, int runLimit, int swimLimit) {
    //        super(name, color, age, runLimit, swimLimit);
    //    }
    //    @Override
    //    public String voice () {
    //        return "gaw!";
    //    }
}

interface IAnimal { // интерфейс содержит абстрактные методы и связан с классом и м.б типом ссылочной переменной IAnimal cat = new Cat
    // String voice();
    String run(int distance);
    String swim(int distance);
}

abstract class Animal implements IAnimal { //интерфейс реализует класс Аnimal, может идти несколько интерфейсов через запятую
    //    protected String name;
    //    protected String color;
    //    protected int age;
    protected int runLimit;
    protected int swimLimit;
    protected String className;
    protected static int countOfAnimals = 0;

    // Animal (String name, String color, int age, int runLimit, int swimLimit) {
    Animal(int runLimit, int swimLimit) {
        //        this.name = name;
        //        this.color = color;
        //        this.age = age;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        className = getClass().getSimpleName();
        countOfAnimals++;
    }

    public String getClassName() {
        return className;
    }

    public static int getCountOfAnimals() {
        return countOfAnimals;
    }

    @ Override
    public String run(int distance) {
        if (distance > runLimit) {
            return className + " couldn't run " + distance;
        } else {
            return className + " successfully run " + distance;
        }
    }

    @ Override
    public String swim(int distance) {
        if (distance > swimLimit) {
            return className + " couldn't swim " + distance;
        } else {
            return className + " successfully swim " + distance;
        }
    }

    @ Override
    public String toString() {
        // return name + ", " + color + ", " + age + ", " + className +  ", runLimit: " + runLimit + ", swimLimit: " + swimLimit;
        return className + ", runLimit: " + runLimit + ", swimLimit: " + swimLimit;
    }
}
