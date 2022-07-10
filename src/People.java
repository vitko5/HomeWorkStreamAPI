public class People {
    private String name;
    private int age;
    private char sex;

    public People(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public char getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
