package datastructures;

import java.util.Comparator;

/**
 * Created by vijaya on 2/10/2017.
 */
public class Person implements Comparable<Person> {

    String firstName;
    String lastName;

public Person() {

}

    public Person(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!getFirstName().equals(person.getFirstName())) return false;
        return getLastName().equals(person.getLastName());

    }

    @Override
    public int hashCode() {
        int result = getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        return result;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int compareTo(Person another) {
        int nameDiff = firstName.compareTo(another.firstName);
        if(nameDiff != 0){
            return nameDiff;
        }

         nameDiff = lastName.compareTo(another.lastName);

       return nameDiff;


    }

    @Override
    public String toString() {
        return "{" +
                "" + firstName + '\'' +
                ", '" + lastName + '\'' +
                '}';
    }
}
