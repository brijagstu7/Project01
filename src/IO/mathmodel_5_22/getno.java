package IO.mathmodel_5_22;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class getno {

    static HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    static HashMap<ArrayList<Integer>, String> map1 = new HashMap<>();

    static HashMap<Integer, Integer>ellst = new HashMap<>();
    static HashMap<Integer, String>elbus = new HashMap<>();

    static ArrayList<ArrayList<Integer>> d = new ArrayList<>(){
        {
            add(new ArrayList<>());
        }
    };
    static ArrayList<ArrayList<String>> dt = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> no = new ArrayList<>();

    static {

    }

    static ArrayList<String> getbusnos(int locno){
        ArrayList<String> arr = new ArrayList<>();

        for (ArrayList<Integer> a :
                no) {
            if (a.contains(locno)){
                arr.add(map1.get(a));
            }
        }

        return arr;
    }
    static ArrayList<Integer> getlocnos(String busno){
        return map.get("S"+busno);
    }

    static void exit(){

        System.exit(0);
    }

    public static void main(String[] args) {
        File file1 = new File("/users/yang_sijie/黎雪儿_王梦琳_杨思捷_附件1.txt");
        File file0 = new File("/users/yang_sijie/source.txt");
        Scanner data = null,src = null;
        try {
            data = new Scanner(file1);
            src = new Scanner(file0);
        } catch (IOException e) {

            e.printStackTrace();
        }

        //data.next();

        //Pattern pattern = Pattern.compile("[，、\n ]+");

        //Pattern.matches("(\\d|NaN)","");

        while (data.hasNext()){
            String s = data.next();

            if (s.equals("L")){
                dt.add(new ArrayList<>());
                no.add(new ArrayList<>());
            }else if (s.matches("(\\d*|NaN)")){

                if (s.equals("NaN")){
                    map.put(s.concat(Integer.toString(dt.size())), no.get(no.size()-1));
                    map1.put( no.get(no.size()-1), s.concat(Integer.toString(dt.size())));
                }else {
                    map.put(s,no.get(no.size()-1));
                    map1.put(no.get(no.size()-1),s);
                }
            }else if (s.matches("S\\d+")){
                String str = s.substring(1);

                no.get(no.size()-1).add(Integer.parseInt(str));

            }else {
                dt.get(dt.size()-1).add(s);
            }


        }

        Scanner sc = new Scanner(System.in);

        d.get(0).add(sc.nextInt());

        int end = sc.nextInt();

        for (int i = 0; i < 99; i++) {
            ArrayList<Integer> di = d.get(i);
            d.add(new ArrayList<>());
            for (int sl :
                   di ) {
                for (String bn :
                        getbusnos(sl)) {
                    for (int el :
                            getlocnos(bn)) {
                        if (el == sl){
                            continue;
                        }
                        if (el == end){

                            System.out.println(i);
                            exit();


                        }
                        ellst.put(el,sl);
                        elbus.put(el,bn);
                        d.get(i+1).add(el);


                    }
                }
            }
        }






        /*

        src.useDelimiter("[，、：\n ]+");

        while (src.hasNext()){
            String s = src.next();

            boolean ok = false;



            if (s.matches("T\\d")){

            }else {
                for (int i = 0; i < dt.size(); i++) {
                    ArrayList<String>as = dt.get(i);
                    ArrayList<Integer>ai = no.get(i);

                    for (int j = 0; j < as.size(); j++) {
                        if (s.equals(as.get(j))){
                            System.out.println(s+":S"+ai.get(j));

                            ok = true;
                            break;
                        }
                    }

                    if (ok){
                        break;
                    }
                }
            }
        }

*/
    }
}
