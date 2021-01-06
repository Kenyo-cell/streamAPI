import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.*;


public class Main {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                names.get(new Random().nextInt(names.size())),
                families.get(new Random().nextInt(families.size())),
                new Random().nextInt(100),
                Sex.values()[new Random().nextInt(Sex.values().length)],
                Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        List<Person> notAdult = persons.stream()
            .filter(a -> a.getAge() < 18)
            .collect(Collectors.toList());

        List<String> potentionalArmyMen = persons.stream()
            .filter(a -> a.getAge() < 27 && a.getAge() > 18)
            .map(a -> a.getName())
            .collect(Collectors.toList());

        List<Person> highEduWorkPositiveList = persons.stream()
            .filter(a -> a.getEducation().equals(Education.HIGHER))
            .filter(a -> a.getAge() > 18)
            .filter(a -> a.getSex().equals(Sex.MAN) ? a.getAge() < 65 : a.getAge() < 60)
            .sorted(Comparator.comparing(Person::getName))
            .collect(Collectors.toList());
    }
}