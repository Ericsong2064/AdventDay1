
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int index=0;
        int index2=0;
        int sum =0;
        ArrayList<String> fileData = getFileData("src/file");
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<Integer> list4 = new ArrayList<>();
        for(int i = 0; i<fileData.size();i++){
            list1.add(Integer.parseInt(fileData.get(i).substring(0,fileData.get(i).indexOf(" "))));
            list2.add(Integer.parseInt(fileData.get(i).substring(fileData.get(i).indexOf(" ")+3)));
        }
        for(int j=0; j<list1.size();j++) {
            int min=Integer.MAX_VALUE;
            int min2=Integer.MAX_VALUE;
            for (int e = j; e < list1.size(); e++) {
                if (list1.get(e) < min) {
                    min = list1.get(e);
                    index=e;
                }
                if(list2.get(e)<min2){
                    min2=list2.get(e);
                    index2=e;
                }
            }
            list1.remove(index);
            list2.remove(index2);
            list1.add(j,min);
            list2.add(j,min2);
        }
        //first solution
        for(int g =0; g<list1.size();g++){
            sum+= Math.abs(list1.get(g)-list2.get(g));
        }
        System.out.println(sum);
        //part 2
        int total=0;
        for(int z=0;z<list1.size();z++) {
            int reps=0;
            for (int k = 0; k < list1.size(); k++) {
                if(list1.get(z).equals(list2.get(k))){
                    reps++;
                }
            }
            total+=reps*list1.get(z);
        }
        System.out.println(total);
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
