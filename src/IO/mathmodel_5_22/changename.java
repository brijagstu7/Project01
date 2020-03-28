package IO.mathmodel_5_22;

import javax.print.attribute.standard.NumberUp;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class changename {



    public static void main(String[] args) {
        File file = new File("/users/yang_sijie/mathmodel"),t=new File("/users/yang_sijie/mathmodel_re.txt");
        RandomAccessFile target = null;
        Writer fw = null;
        try {
            target = new RandomAccessFile(t,"rw");
            fw = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(t), StandardCharsets.UTF_8));
        } catch (IOException e) {

            e.printStackTrace();
        }

        File[] files = file.listFiles();
        Scanner scdilim = null , scall = null;

        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();


        for (File f :
                files) {

            try {
                scdilim = new Scanner(f);
                scall = new Scanner(f);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            scall.useDelimiter("[&]");
            String addup=scall.next();

            try {
                scdilim.next();
                scdilim.next();
            }catch (Exception e){
                System.out.println(f.toString()+" abnormal.");
            }


            while (scdilim.hasNext()){
                String cn = scdilim.next();
                if (!map.containsKey(cn)){
                    map.put(cn,map.size());
                    arr.add(map.size()-1);
                }else {
                    arr.add(map.get(cn));
                }

            }


            StringBuilder sb = new StringBuilder(addup);
            for (int num:
                    arr){
                String s = " S"+ num;
                sb.append(s);
            }
            addup = sb.toString();

            try {
                fw.write(addup);
                fw.write('\n');
                /*
                target.writeUTF(addup);
                target.write('\n');
                */
            } catch (IOException e) {
                e.printStackTrace();
            }
            arr.clear();

        }
    }

}
