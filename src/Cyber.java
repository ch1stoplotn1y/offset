import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Cyber {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String temp;
        String[] items;
        Set<Person> persons = new TreeSet<>();

        while (true) {
            temp = scan.nextLine();
            if (temp.equals("END!")) break;
            items = temp.split(" ");
            persons.add(new Person(items[0], Integer.parseInt(items[1])));
        }

        persons.forEach(System.out::println);
    }
}

class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        Person p = (Person) o;
        if (this == p) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return age == p.age && Objects.equals(name, p.name);
    }

    @Override
    public String toString() {
        return age + ", " + name;
    }

    @Override
    public int compareTo(Person o) {
        if (age != o.age) return age - o.age;
        return name.compareTo(o.name);
    }
}
