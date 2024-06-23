package CaseStudy.Model;


import java.time.LocalDate;

public class Student extends Person {
    private String className;

    public Student (int id, String name, LocalDate birthday, String email, String className){
        super(id, name, birthday, email);
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Student{" +
                "className='" + className + '\''
                + super.toString();
    }

}
