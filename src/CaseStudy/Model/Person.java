package CaseStudy.Model;

import java.time.LocalDate;

public abstract class Person {
    private int id;
    private String name;
    private LocalDate birthday;
    private String email;

    public Person(int id, String name, LocalDate birthday, String email) {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return
                ", id=" + id +
                        ", name='" + name + '\'' +
                        ", birthday='" + birthday + '\'' +
                        ", email='" + email + '\'' +
                        '}';
    }
}