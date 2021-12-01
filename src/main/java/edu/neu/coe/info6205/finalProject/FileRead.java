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

//					 int id = Integer.valueOf(fields[0]);
//					 int age = Integer.valueOf(fields[1]);
//					 String fname = fields[2];
//					 String lname = fields[3];
//					 String parentFname = fields[4];
//					 String parentLname = fields[5];
//					 int hwage = Integer.valueOf(fields[6]);
//					 list.add(new Teacher(id,age,fname,lname,parentFname,parentLname,hwage));

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;

    }
    public static void writing(String[] strings) {
        try {
            FileWriter fw = new FileWriter("src/main/java/edu/neu/coe/info6205/finalProject/res.txt");
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
