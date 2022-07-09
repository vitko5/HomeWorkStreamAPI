
// Дана колекція клас People (з полями name - ім'я, age - вік, sex - стать)

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        //for (People people : peopleList) {
        //   System.out.printf("%s is %s y.o. and %s\n",people.getName(),people.getAge(),people.getSex());
        //}

        //1. Вибрати чоловіків-військовозобов'язаних (від 18 до 27 років)
        for (People people : peopleList) {
            if (people.getSex() == 'M' && (people.getAge() >= 18 && people.getAge() <= 27)) {
                System.out.printf("%s (%s y.o.) voenoobyazanniy\n",people.getName(),people.getAge());
            }
        }
        System.out.println("===========================================");

        //2. Знайти середній вік серед чоловіків
        int ageSum = 0;
        int ageCount = 0;
        for (People people : peopleList) {
            if (people.getSex() == 'M') {
                ageSum += people.getAge();
                ageCount++;
            }
        }
        System.out.println("Average age from all male people is: " + ageSum/ageCount);
        System.out.println("===========================================");

        //3. Знайти кількість потенційно працездатних людей у вибірці (тобто від 18 років і з огляду на що жінки виходять в 55 років, а чоловік в 60)
        for (People people : peopleList) {
            if (people.getAge() >= 18 && ((people.getSex() == 'F' && people.getAge()<55) || (people.getSex() == 'M' && people.getAge()<60))) {
                System.out.printf("%s (%s) is good for work\n",people.getName(),people.getAge());
            }
        }
        System.out.println("===========================================");

        //4. Відсортувати колекцію людей за ім'ям в зворотному алфавітному порядку
        List<People> sortedPeopleSet = peopleList.stream().sorted(Comparator.comparing(People::getName).reversed()).toList();
        for (People people : sortedPeopleSet) {
            System.out.println(people.getName());
        }
        System.out.println("===========================================");

        //5. Відсортувати колекцію людей спочатку за ім’ям, а потім за віком
        Comparator<People> comparator = Comparator.comparing(People::getName).thenComparing(People::getAge);
        List<People> sorted2PeopleList = peopleList.stream().sorted(comparator).toList();
        for (People people : sorted2PeopleList) {
            System.out.printf("%s (%s)\n",people.getName(),people.getAge());
        }
        System.out.println("===========================================");

        //6. Знайти найстаршу людину
        People oldestPeople = null;
        for (People people : peopleList) {
            if (oldestPeople == null) {
                oldestPeople = people;
            } else if (oldestPeople.getAge() < people.getAge()){
                oldestPeople = people;
            }
        }
        System.out.printf("%s (%s) is oldest people from database\n",oldestPeople.getName(),oldestPeople.getAge());
        System.out.println("===========================================");

        //7. Знайти наймолодшу людину
        People youngerPeople = null;
        for (People people : peopleList) {
            if (youngerPeople == null) {
                youngerPeople = people;
            } else if (youngerPeople.getAge() > people.getAge()){
                youngerPeople = people;
            }
        }
        System.out.printf("%s (%s) is younger people from database\n",youngerPeople.getName(),youngerPeople.getAge());
        System.out.println("===========================================");

        //8. Вивести скільки є чоловіків
        int countMale = 0;
        for (People people : peopleList) {
            if (people.getSex() == 'M') countMale++;
        }
        System.out.printf("Database have %s male\n",countMale);
        System.out.println("===========================================");

        //9. Вивести скільки є жінок
        int countFemale = 0;
        for (People people : peopleList) {
            if (people.getSex() == 'F') countFemale++;
        }
        System.out.printf("Database have %s female\n",countFemale);
        System.out.println("===========================================");

        //10. Вивеcти всіх жінок в яких ім’я починається на “A”
        Pattern regex = Pattern.compile("^A.+");
        for (People people : peopleList) {
            Matcher matcher = regex.matcher(people.getName());
            if (matcher.matches()) {
                System.out.printf("%s is starting from A\n",people.getName());
            }
        }
        System.out.println("===========================================");
    }
}
