package ru.dm.smirnov;

public class Person {

    private final String name;

    private final int age;

    private final String address;

    private final String phone;

    public Person(BuilderPerson builderPerson) {
        this.name = builderPerson.name;
        this.age = builderPerson.age;
        this.address = builderPerson.address;
        this.phone = builderPerson.phone;
    }

    public static BuilderPerson builder() {
        return new BuilderPerson();
    }

    public static class BuilderPerson {

        private String name;

        private int age;

        private String address;

        private String phone;


        public BuilderPerson name(String name) {
            this.name = name;
            return this;
        }

        public BuilderPerson age(int age) {
            this.age = age;
            return this;
        }

        public BuilderPerson address(String address) {
            this.address = address;
            return this;
        }

        public BuilderPerson phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Person build() {
            return new Person(this);
        }

    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

}
