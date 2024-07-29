package CaseStudy.common;

import CaseStudy.Model.Student;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IOStreamStudent {
    private static final String PATH = "src/CaseStudy/data/student.csv";

    public static List<Student> convertToListStudent(){
        List<Student> list = new ArrayList<>();
        try(
                FileReader reader = new FileReader(PATH);
                BufferedReader bufferReader = new BufferedReader(reader);
            ) {
            String line;
            String[] arrayData;
            while((line = bufferReader.readLine()) != null){
                arrayData = line.split(",");
                list.add(new Student(Integer.parseInt(arrayData[0]),
                        arrayData[1], arrayData[2], LocalDate.parse(arrayData[3]), arrayData[4], arrayData[5]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void addStudentToFile(Student student){
        try(
                FileWriter fileWriter = new FileWriter(PATH,true);
                BufferedWriter bufferedWrite = new BufferedWriter(fileWriter);
            ) {
                bufferedWrite.write(student.convertToLine());
                bufferedWrite.newLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void importStudentToFile(List<Student> students){
        try(
                FileWriter fileWriter = new FileWriter(PATH);
                BufferedWriter bufferedWrite = new BufferedWriter(fileWriter);
        ) {
            for (Student s : students){
                bufferedWrite.write(s.convertToLine());
                bufferedWrite.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
