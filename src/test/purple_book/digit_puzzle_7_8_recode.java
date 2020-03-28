package test.purple_book;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.pow;

/*

we  need a DEEP clone.
A deep clone is implemented be the clone method,
and for arrays, a new local array should be returned.



        example:
        7*__=8_

        __*__=1_1
     */
public class digit_puzzle_7_8_recode {



    static boolean isN(Object ob){
        if (ob instanceof Integer){
            int n = (Integer)ob;
            if (n<10 && n>0){
                return true;
            }
            return false;
        }else {
            return false;
        }
    }

    static boolean isN0(Object ob){
        if (ob instanceof Integer){
            int n = (Integer)ob;
            if (n<10 && n>=0){
                return true;
            }
            return false;
        }else {
            return false;
        }
    }

    static boolean isN3(Object ob){
        if (ob instanceof Integer){
            int n = (Integer)ob;
            if (n<3 && n>0){
                return true;
            }
            return false;
        }else {
            return false;
        }
    }


    /**
     *
     */
    static class Blank implements Cloneable, Serializable{

        @Override
        protected Blank clone()  {




            Blank b = new Blank(this);
/*
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = null;
            try {
                objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
            ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            ObjectInputStream objectInputStream;
            try {
                objectInputStream = new ObjectInputStream(inputStream);
                b = (Blank) objectInputStream.readObject();;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            */
            return b;

        }

        public Blank(String str) {
            origin = str;
            uradix = str.length();

            String strn = str.replaceAll("_","0");
            existed = Integer.parseInt(strn);


            for (int i = 0; i < uradix; i++) {

                int radix = uradix - i;

                if (str.charAt(i) == '_'){
                    not_existed.add(radix-1);
                }
                /*
                else {//numeric
                    existed += (str.charAt(i)-'0')*pow(10,(radix-1));
                }
                */
            }

        }
        
        //copy constructor --------------- why is is not working!
        public Blank(Blank b){
            this.origin = b.origin;
            this.uradix = b.uradix;
            this.existed = b.existed;

            for (Integer i :
                    b.not_existed) {
                int k = i;
                this.not_existed.add(k);
            }
        }

        Blank[] lastBlank;
        String origin;
        int uradix;
        int existed;
        ArrayList<Integer> not_existed = new ArrayList<>();//remain sequence: ->, i.e. left to right
    }

    static class fillform {
        boolean j[];
        int n[],i;

        public fillform(){
            j = new boolean[]{p.origin.charAt(0) == '_',
                    q.origin.charAt(0) == '_',
                    r.origin.charAt(0) == '_'};

            n = new int[]{p.not_existed.size(),
                    q.not_existed.size(),
                    r.not_existed.size()};

            if (p.not_existed.isEmpty() || q.not_existed.isEmpty() || r.not_existed.isEmpty())i = 2;
            else i = 3;
        }

        public fillform(Blank p,Blank q,Blank r){



            j = new boolean[]{p.origin.charAt(0) == '_',
                    q.origin.charAt(0) == '_',
                    r.origin.charAt(0) == '_'};

            n = new int[]{p.not_existed.size(),
                    q.not_existed.size(),
                    r.not_existed.size()};

            if (p.not_existed.isEmpty() || q.not_existed.isEmpty() || r.not_existed.isEmpty())i = 2;
            else i = 3;

        }

        public fillform(Blank[] blanks){

            Blank p = blanks[0],
                    q = blanks[1],
                    r = blanks[2];


            j = new boolean[]{p.origin.charAt(0) == '_',
                    q.origin.charAt(0) == '_',
                    r.origin.charAt(0) == '_'};

            n = new int[]{p.not_existed.size(),
                    q.not_existed.size(),
                    r.not_existed.size()};

            if (p.not_existed.isEmpty() || q.not_existed.isEmpty() || r.not_existed.isEmpty())i = 2;
            else i = 3;

        }

        public fillform(boolean[] j, int[] n, int i) {

            if (!isN3(i)){
                return;
            }

            this.j = j;
            this.n = n;
            this.i = i;
        }

        /**
         * I did not use i . look for probable mistakes.
         * @return
         */
        int totalnum(){
            int num = 0;
            for (int k = 0; k < 3; k++) {
                num += n[k];
            }
            return num;
        }
    }
    
    
//i need a deep copy.
    static Blank[] copy(Blank[] ts){

        Blank[] theCopy = new Blank[ts.length];

        for (int i=0;i<ts.length;i++) {
            theCopy[i] = ts[i].clone();
        }

        return theCopy;
    }




    static Blank p,q,r;//remain untouched!!

    /**
     *
     * NOTE:        this function is a real mistake of lack of not adequate formalization.
     *              now it is fixed.
     *
     * @param f
     * @param nums must fit the sequence of p.not_existed
     * @return
     */
    static boolean verif(fillform f, int ... nums){

        if (f.totalnum() != nums.length)return false;


        for (int i = 0; i < f.i; i++) {// the most front _ cannot be 0
            int index = 0;
            for (int j = 0; j < i; j++) {
                index += f.n[j];
            }
            if (f.j[i] && nums[index]==0 && p.existed>0)return false;
        }

        int p0 = p.existed ,q0 = q.existed, r0 = r.existed, i=0, j=0;
        for (j=0; j < p.not_existed.size(); j++,i++) {
            p0 += pow(10,p.not_existed.get(j))*nums[i];
        }
        for (j=0; j < q.not_existed.size(); j++,i++) {
            q0 +=  pow(10, q.not_existed.get(j))*nums[i];
        }
        for (j=0 ;j < r.not_existed.size(); j++,i++) {
            r0 +=  pow(10, r.not_existed.get(j))*nums[i];
        }

        if (p0 * q0 == r0){
            return true;
        }
        return false;
    }
    static boolean verif(fillform f, Blank p,Blank q,Blank r, int ... nums){

        if (f.totalnum() != nums.length)return false;


        for (int i = 0; i < f.i; i++) {// the most front _ cannot be 0
            int index = 0;
            for (int j = 0; j < i; j++) {
                index += f.n[j];
            }
            if (f.j[i] && nums[index]==0 && p.existed>0)return false;
        }

        int p0 = p.existed ,q0 = q.existed, r0 = r.existed, i=0, j=0;
        for (j=0; j < p.not_existed.size(); j++,i++) {
            p0 += pow(10,p.not_existed.get(j))*nums[i];
        }
        for (j=0; j < q.not_existed.size(); j++,i++) {
            q0 +=  pow(10, q.not_existed.get(j))*nums[i];
        }
        for (j=0 ;j < r.not_existed.size(); j++,i++) {
            r0 +=  pow(10, r.not_existed.get(j))*nums[i];
        }

        if (p0 * q0 == r0){
            return true;
        }
        return false;
    }
    static boolean verif(fillform f, Blank[] blanks, int ... nums){
        Blank p = blanks[0],
                q = blanks[1],
                r = blanks[2];


        return verif(f,p,q,r,nums);
    }

    /**
     * Drawback:
     * The most front _ cannot be set as 0. Overloaded versions as well.
     * @param f
     * @return
     */
    static int count(fillform f){

        int cnt = 0;

        for (Integer i = (int) pow(10,f.totalnum()-1); i < pow(10,f.totalnum()); i++) {
            char[] ch = i.toString().toCharArray();
            int[] arg = new int[ch.length];
            int in = 0;//index
            for (char c :
                    ch) {
                arg[in++] = c- '0';

            }
            if (verif(f,arg)){
                cnt++;
            }
        }

        return cnt;
    }
    static int count(fillform f,Blank p,Blank q,Blank r){
        int cnt = 0;

        for (Integer i = (int) pow(10,f.totalnum()-1); i < pow(10,f.totalnum()); i++) {//e.g. 100~999, 10^2~10^3-1
            char[] ch = i.toString().toCharArray();
            int[] arg = new int[ch.length];
            int in = 0;
            for (char c :
                    ch) {
                arg[in++] = c- '0';

            }
            if (verif(f,p,q,r,arg)){
                cnt++;
            }
        }

        return cnt;
    }
    static int count(fillform f,Blank[] blanks){
        Blank p = blanks[0],
                q = blanks[1],
                r = blanks[2];


        return count(f,p,q,r);
    }

    static {
        Scanner sc = new Scanner(System.in);

        sc.useDelimiter("[*= \n]");

        String str[] = {sc.next(),sc.next(),sc.next()};//nextLine() can contain blank spaces

        p = new Blank(str[0]);
        q = new Blank(str[1]);
        r = new Blank(str[2]);

        pqrs = new ArrayList<>();

        //pqrs.get(0).set(0,new Blank[]{p,q,r});        //it puzzles me why it cannot compile.

    }

    static ArrayList<ArrayList<Blank[]> > pqrs;//p,q,and r after changes occur.

    /**
     * proved. debugged
     * @param blanks
     * @return epsi
     */
    static ArrayList<Blank[]> xtp1(Blank[] blanks){

        Blank[] oldBlanks = copy(blanks);//we are worried that ...

        ArrayList<Blank[]> arr = new ArrayList<>();
        //ArrayList<Integer>saveIndices = new ArrayList<>();

        int num = count(new fillform(blanks),blanks );

        if (num>1){
            //do not add _s.

            //these are replacing _ to number.
            for (int i = 0; i < blanks.length; i++) {// it needs to be 3.
                StringBuilder sb = new StringBuilder(blanks[i].origin);
                for (int j = 0; j<blanks[i].not_existed.size();j++) {
                    for (Integer k = 0; k < 9; k++) {
                        int index = blanks[i].origin.length() - blanks[i].not_existed.get(j) -1;
                        sb.replace(index,index+1,k.toString());
                        blanks[i] = new Blank(sb.toString());
                        arr.add(copy(blanks));

                        blanks = copy(oldBlanks);
                        sb = new StringBuilder(blanks[i].origin);
                    }
                }
            }
            //_*_=_
            //these are replacing number to number.

            for (int i = 0; i < blanks.length; i++) {// it needs to be 3.
                StringBuilder sb = new StringBuilder(blanks[i].origin);

                for (int j = 0; j<blanks[i].origin.length();j++) {
                    if (sb.charAt(j) != '_'){
                        for (Integer k = 0; k <= 9; k++) {
                            sb.replace(j,j+1,k.toString());
                            blanks[i] = new Blank(sb.toString());
                            arr.add(copy(blanks));

                            blanks = copy(oldBlanks);
                            sb = new StringBuilder(blanks[i].origin);
                        }
                    }
                }
            }
        }else {//suppose num ≠ 1. i.e. num==0
            //replacing number to number and replacing number to _.
            for (int i = 0; i < blanks.length; i++) {// it needs to be 3.
                StringBuilder sb = new StringBuilder(blanks[i].origin);

                for (int j = 0; j<blanks[i].origin.length();j++) {

                    //replacing number to _.
                    sb.replace(j,j+1,"_");
                    blanks[i] = new Blank(sb.toString());
                    arr.add(copy(blanks));

                    blanks = copy(oldBlanks);
                    sb = new StringBuilder(blanks[i].origin);

                    if (sb.charAt(j) != '_'){
                        for (Integer k = 0; k <= 9; k++) {
                            sb.replace(j,j+1,k.toString());
                            blanks[i] = new Blank(sb.toString());
                            arr.add(copy(blanks));

                            blanks = copy(oldBlanks);
                            sb = new StringBuilder(blanks[i].origin);
                        }

                    }
                }
            }


        }

        return arr;
    }


    /**
     * not proved.
     * @param n
     * @param old
     * @param origin
     * @return
     */
    static boolean replaceQ(Blank[] old, Blank[] n, Blank[] origin){
        if (old==null)return true;


        char nd = 0,od = 0;
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (!n[i].origin.equals(origin[i].origin)){
                for (int j = 0; j < n[i].origin.length(); j++) {
                    if (n[i].origin.charAt(j) != origin[i].origin.charAt(j)){
                        nd = n[i].origin.charAt(j);
                        cnt++;
                    }
                }
            }
            if (!old[i].origin.equals(origin[i].origin)){
                for (int j = 0; j < old[i].origin.length(); j++) {
                    if (old[i].origin.charAt(j) != origin[i].origin.charAt(j)){
                        od = n[i].origin.charAt(j);
                    }
                }
            }
        }

        if (cnt > 1){
            return false;
        }

        return nd == '_' || nd < od;
    }

    /**
     * proved , not debugged
     *
     * Bugs are rooted in somewhere that you urged to be false.
     * Miracles are rooted in somewhere that you did not notice.
     *
     *
     * @return number of changes made to the cards
     */
    static int epsi(){
        pqrs.add(new ArrayList<>());

        for (Blank[] b :
                pqrs.get(pqrs.size() - 2)) {

            if ((count(new fillform(b),b)) == 1){
                end = b;
                return 1;
            }


            ArrayList<Blank[]> arr = xtp1(b);
            pqrs.get(pqrs.size()-1).addAll(arr);

            //arr is a set of any eps_i, whence b is eps_i-1

            //where  we FOCUS
            for (Blank[] d :
                    arr) {
                if (replaceQ(d[0].lastBlank,b,d))
                    d[0].lastBlank = b;
            }
        }

        return 0;

    }

    static Blank[] end;


    /**
     *
     * @param i
     */
    static void printStack(Blank[] i){
        if (i == null)return;



        if (i[0].lastBlank != null)printStack(i[0].lastBlank);

        System.out.println(i[0].origin+"*"+i[1].origin+"="+i[2].origin);

    }

    public static void main(String[] args) {
        //System.out.println(count(new fillform()));


        pqrs.add(new ArrayList<>());
        pqrs.get(0).add(new Blank[]{p,q,r});

        int i=0;
        while ((epsi()) == 0)i++;
        System.out.println("counts:"+i);
        printStack(end);


    }

}
