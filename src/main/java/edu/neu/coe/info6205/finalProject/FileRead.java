package edu.neu.coe.info6205.finalProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class FileRead {
    public static List<String> reading(List<String> list, String fileName) {
        String thisLine = null;
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader in = new BufferedReader(fr);
            while((thisLine = in.readLine())!=null) {
                list.add(thisLine);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;

    }
    public static void writing(String[] strings,String location) {
        try {
            FileWriter fw = new FileWriter(location);
            BufferedWriter out = new BufferedWriter(fw);
            for(String s:strings) {
                out.write(s.toString());
                out.newLine();
            }
            out.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
