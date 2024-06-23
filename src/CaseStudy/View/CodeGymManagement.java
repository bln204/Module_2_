package CaseStudy.View;

import CaseStudy.Controller.Student.StudentController;

public class CodeGymManagement {
    public static void main(String[] args) {
        StudentController studentController = new StudentController();
        studentController.displayStudents();
    }
}
