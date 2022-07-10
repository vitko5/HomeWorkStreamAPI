
// Дана колекція клас People (з полями name - ім'я, age - вік, sex - стать)

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // init task list
        List<People> peopleList = new ArrayList<>();
        peopleList.add(new People("Vitaliy",28,'M'));
        peopleList.add(new People("Tatyana",31,'F'));
        peopleList.add(new People("Taras",55,'M'));
        peopleList.add(new People("Miya",21,'F'));
        peopleList.add(new People("Arina",28,'F'));
        peopleList.add(new People("Svetlana",48,'F'));
        peopleList.add(new People("Aleksandra",33,'F'));
        peopleList.add(new People("Sergey",25,'M'));
        peopleList.add(new People("Marik",18,'M'));
        peopleList.add(new People("Arina",19,'F'));

        //1. Вибрати чоловіків-військовозобов'язаних (від 18 до 27 років)
        peopleList.stream()
                .filter(people -> people.getSex() == 'M' && people.getAge() >= 18 && people.getAge() <= 27)
                .forEach(people -> System.out.println(people.getName()));
        System.out.println("===========================================");

        //2. Знайти середній вік серед чоловіків
        double average = peopleList.stream()
                .filter(people -> people.getSex() == 'M')
                .mapToDouble(People::getAge)
                .average()
                .getAsDouble();
        System.out.println("Average age from all male people is: " + average);
        System.out.println("===========================================");

        //3. Знайти кількість потенційно працездатних людей у вибірці (тобто від 18 років і з огляду на що жінки виходять в 55 років, а чоловік в 60)
        peopleList.stream()
                .filter(people -> people.getAge() >= 18 && ((people.getSex() == 'M' && people.getAge() <= 60) || (people.getSex() == 'F' && people.getAge() <= 55)))
                .forEach(people -> System.out.println(people.getName()));
        System.out.println("===========================================");

        //4. Відсортувати колекцію людей за ім'ям в зворотному алфавітному порядку
        peopleList.stream()
                .sorted(Comparator.comparing(People::getName).reversed())
                .forEach(people -> System.out.println(people.getName()));
        System.out.println("===========================================");

        //5. Відсортувати колекцію людей спочатку за ім’ям, а потім за віком
        peopleList.stream()
                .sorted(Comparator.comparing(People::getName).thenComparing(People::getAge))
                .forEach(people -> System.out.println(people.getName() + " " + people.getAge()));
        System.out.println("===========================================");

        //6. Знайти найстаршу людину
        People oldestPeople = peopleList.stream()
                .max(Comparator.comparing(People::getAge))
                .get();
        System.out.printf("%s (%s) is oldest people from database\n",oldestPeople.getName(),oldestPeople.getAge());
        System.out.println("===========================================");

        //7. Знайти наймолодшу людину
        People youngerPeople  = peopleList.stream()
                .min(Comparator.comparing(People::getAge))
                .get();
        System.out.printf("%s (%s) is younger people from database\n",youngerPeople.getName(),youngerPeople.getAge());
        System.out.println("===========================================");

        //8. Вивести скільки є чоловіків
        long countMale = peopleList.stream()
                .filter(people -> people.getSex() == 'M')
                .count();
        System.out.printf("Database have %s male\n",countMale);
        System.out.println("===========================================");

        //9. Вивести скільки є жінок
        long countFemale = peopleList.stream()
                .filter(people -> people.getSex() == 'F')
                .count();
        System.out.printf("Database have %s female\n",countFemale);
        System.out.println("===========================================");

        //10. Вивеcти всіх жінок в яких ім’я починається на “A”
        peopleList.stream()
                .map(People::getName)
                .filter(people -> people.startsWith("A"))
                .forEach(System.out::println);
        System.out.println("===========================================");
    }
}
