package payLoadManagement;


// This is called POJO - Plain Old Java Object is made by adding default constructor
// and encapsulation concept

public class Person {

      private String name;
      private int age;

    public Person() {
        this.name = name;
    }

    public Person(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
