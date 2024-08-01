package thi_cuoi_module_2.common;

import CaseStudy.Model.Student;
import thi_cuoi_module_2.model.RegularPatient;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IOStreamRegularPatient {
    private static final String PATH = "src/thi_cuoi_module_2/data/regular_patient.csv";
    public static List<RegularPatient> convertToListPatient(){
        List<RegularPatient> list = new ArrayList<>();
        try(
                FileReader reader = new FileReader(PATH);
                BufferedReader bufferReader = new BufferedReader(reader);
                ){
        String line;
        String[] arrayData;
        while((line = bufferReader.readLine()) != null){
            arrayData = line.split(",");
            list.add(new RegularPatient(LocalDate.parse(arrayData[0]),arrayData[1],arrayData[2],Integer.parseInt(arrayData[3]),
                    LocalDate.parse(arrayData[4]),arrayData[5],Integer.parseInt(arrayData[6])));
        }
    } catch (
    FileNotFoundException e) {
        e.printStackTrace();
    } catch (
    IOException e) {
        e.printStackTrace();
    }

        return list;
    }
    public static void addPatientToFile(RegularPatient patient){
        try(
                FileWriter fileWriter = new FileWriter(PATH,true);
                BufferedWriter bufferedWrite = new BufferedWriter(fileWriter);
        ) {
            bufferedWrite.write(patient.convertToLine());
            bufferedWrite.newLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void importPatientToFile(List<RegularPatient> patients){
        try(
                FileWriter fileWriter = new FileWriter(PATH);
                BufferedWriter bufferedWrite = new BufferedWriter(fileWriter);
        ) {
            for (RegularPatient p : patients){
                bufferedWrite.write(p.convertToLine());
                bufferedWrite.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
