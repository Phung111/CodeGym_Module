package AccesModifier_StaticMethod_StaticProperty.Student2;

public class Test {
    public static void main(String[] args) {
        Student2 student = new Student2("ok","ok");
        student.setName("Men");
        student.setClasses("C10");
        System.out.println(student.getName());
    }
}
