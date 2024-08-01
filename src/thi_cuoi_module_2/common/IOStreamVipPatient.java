package thi_cuoi_module_2.common;

import thi_cuoi_module_2.model.VIPPatient;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IOStreamVipPatient {
    private static final String PATH = "src/thi_cuoi_module_2/data/vip_patient.csv";
    public static List<VIPPatient> convertToListPatient(){
        List<VIPPatient> list = new ArrayList<>();
        try(
                FileReader reader = new FileReader(PATH);
                BufferedReader bufferReader = new BufferedReader(reader);
        ){
            String line;
            String[] arrayData;
            while((line = bufferReader.readLine()) != null){
                arrayData = line.split(",");
                list.add(new VIPPatient(LocalDate.parse(arrayData[0]),arrayData[1],arrayData[2],Integer.parseInt(arrayData[3]),
                        LocalDate.parse(arrayData[4]),arrayData[5],arrayData[6],Integer.parseInt(arrayData[7])));
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
    public static void addPatientToFile(VIPPatient patient){
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

    public static void importPatientToFile(List<VIPPatient> patients){
        try(
                FileWriter fileWriter = new FileWriter(PATH);
                BufferedWriter bufferedWrite = new BufferedWriter(fileWriter);
        ) {
            for (VIPPatient p : patients){
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
