package interview;

/**
 * Created by ima on 27/11/18.
 */
public class Dog {
    private String name;
    private Integer age;

    public Dog(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    //    @Override
//    public int compareTo(Object o) {
//
//        return this.name.compareToIgnoreCase(((Dog)o).name);
//    }
}
