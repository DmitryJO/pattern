package ru.dm.smirnov;

public class Main {

    public static void main(String[] args) {

        /*
          Реализация паттерна Builder
         */
        Person person1 = Person.builder()
                .age(27)
                .name("Дмитрий")
                .address("Кострома")
                .phone("89997772244")
                .build();

        Person person2 = Person.builder()
                .age(28)
                .name("Гена")
                .address("Кострома")
                .build();

        Person person3 = Person.builder()
                .name("Вероника")
                .phone("89307772242")
                .build();

        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
    }

}
