package CaseStudy.common;



import CaseStudy.Model.Teacher;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IOStreamTeacher {
    private static final String PATH = "src/CaseStudy/data/teacher.csv";

    public static List<Teacher> convertToListStudent(){
        List<Teacher> list = new ArrayList<>();
        try(
                FileReader reader = new FileReader(PATH);
                BufferedReader bufferReader = new BufferedReader(reader);
        ) {
            String line;
            String[] arrayData;
            while((line = bufferReader.readLine()) != null){
                arrayData = line.split(",");
                list.add(new Teacher(Integer.parseInt(arrayData[0]),
                        arrayData[1], arrayData[2], LocalDate.parse(arrayData[3]), arrayData[4], Integer.parseInt(arrayData[5])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void addTeacherToFile(Teacher teacher){
        try(
                FileWriter fileWriter = new FileWriter(PATH,true);
                BufferedWriter bufferedWrite = new BufferedWriter(fileWriter);
        ) {
            bufferedWrite.write(teacher.convertToLine());
            bufferedWrite.newLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void importTeacherToFile(List<Teacher> teachers){
        try(
                FileWriter fileWriter = new FileWriter(PATH);
                BufferedWriter bufferedWrite = new BufferedWriter(fileWriter);
        ) {
            for (Teacher s : teachers){
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
