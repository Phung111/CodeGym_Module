package AccesModifier_StaticMethod_StaticProperty.Student2;

public class Student2 {
    private String name = "John";
    private String classes = "C02";
    public Student2(){
    }

    public Student2(String name, String classes) {
        this.name = name;
        this.classes = classes;
    }
    public String setClasses(String classes){
        return this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

