package april7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utility {

    public static Object[][] readFromCSV(String pathToFile)  {


        List<String[]> list = new ArrayList<>();

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(pathToFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(scanner.hasNextLine()){
            String[]eachroww=scanner.nextLine().split(",");
            list.add(eachroww);
        }




        int columnSize = list.get(0).length;
        int row = list.size();
        Object [][] arr = new Object[row][columnSize];


        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }





        return arr;
    }
}
