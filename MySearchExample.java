package datastructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by vijaya on 2/10/2017.
 */
public class MySearchExample {


    /**
     *
     * @param i
     * @return Integer found if present
     * else returns null
     */
    public static Integer search(List<Integer> list, Integer obj) {
        for (int i = 0; i<list.size();i++) {
            Integer element = list.get(i);
            if (element.equals(obj)) {
                return element;
            }
        }
        return null;
    }

    public static Integer javaContains(List<Integer> list, Integer obj) {
        int index = list.indexOf(obj);

        if (index > 0) {
            return list.get(index);
        }
        return null;
    }


    public static List<Integer> sort(List<Integer> list) {

        return list;
    }

    public static List notInList(List list, List exclusionList) {
        for (Object obj: exclusionList) {
            if (list.contains(obj)) {
                list.remove(obj);
            }
        }
        return list;
    }

    public static Integer getFibonacci(int n) {
        if (n == 1) {
            return 0;
        }
        if (n== 2) {
            return 1;
        }
        return getFibonacci(n-1) + n;
    }




    public static void main(String[] args) {
//        Integer found = search(generateListOfIntegers(), Integer.valueOf(7));
//        System.out.println("Found in search " + found);
//        Integer javaFound = javaContains(generateListOfIntegers(), Integer.valueOf(7));
//        System.out.println("Found in java contains " + javaFound);
        List<Person> personList =generateListOfPersons();
        System.out.println("personList " + personList);
        List<Person> newPersonList = new ArrayList<>();
        newPersonList.addAll(personList);
        Collections.sort(newPersonList);
        System.out.println("sorted newPersonList " + newPersonList);
        int index = Collections.binarySearch(newPersonList, new Person("Vijaya", "Iyer"));

        if (index > 0 ) {
            Person me = newPersonList.get(index);
            me.setLastName("Raman");
            System.out.println("Found sorted newPersonList " + newPersonList);
        }

        List<Person> exclude = new ArrayList<>();
        exclude.add(new Person("Uma", "Iyer"));
        System.out.println("personList " + personList);

        System.out.println("notinlist " + notInList(personList, exclude));
    }

    public static List<Integer> generateListOfIntegers() {
        List<Integer> list = new ArrayList();
        list.add(Integer.valueOf(3));
        list.add(Integer.valueOf(30));
        list.add(Integer.valueOf(13));
        list.add(Integer.valueOf(23));
        list.add(Integer.valueOf(7));
        list.add(Integer.valueOf(12));
        System.out.println("List " + list);
        return list;
    }


    public static List<Person> generateListOfPersons() {
        List<Person> list = new ArrayList();
        list.add(new Person("Uma", "Iyer"));
        list.add(new Person("Vijaya", "Iyer"));
        list.add(new Person("Vijay", "Raman"));
        list.add(new Person("Lakshman", "Raman"));
        System.out.println("Person List " + list);
        return list;
    }
}
