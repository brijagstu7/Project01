package test;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * This class can check the correctness, by examine whether an answer with normal algorithm and which with
 * violent algorithm are the same.
 *
 * This class is INCOMPLETE when first run.
 */
public class tester {
//I wonder if it could be better to be implemented outside jvm.


    /**
     * This method should be public for the use of two algorithms.
     * @param file the file where examples will be put.
     * @return a specific random example for the test.
     * You can also write the example to a file for the sake of scanners.
     *
     * INCOMPLETE you have to fill this method.
     */
    public static Object[] getRandomExample(File file){

        Random r = new Random();

        return null;
    }

    /**
     * We should ensure that each test has wrote output to a certain file.
     *
     * @param args you have to set the filePath and the length, based on the situation.
     *             after ******************************************** indicator.
     *
     *
     * INCOMPLETE you have to fill this method.
     */
    public static void main(String[] args) {

        String filePath0,filePath1;
        /*********************************************/
        filePath0 = filePath1 = "/users/yang_sijie/eclipse-workspace/Project01/";//folder name

        Scanner sc = new Scanner(System.in);
        /*********************************************/
        filePath0 += "";//file name
        filePath1 += "";//file name

        FileReader fileReader0 = null,fileReader1 = null;
        try {
            fileReader0 = new FileReader(filePath0);
            fileReader1 = new FileReader(filePath1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        /*********************************************/
        long length = 1<<7;//should be approximately file.length
        long i = 0;
        while (i < length){
            try {
                int c1 = fileReader0.read();
                int c2 = fileReader1.read();
                if(c1 != c2){
                    System.out.println("not the same.");
                    System.out.println("If ok, input a string to continue");
                    sc.next();//pause until a input
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            i++;
        }

        System.out.println("the same.");
    }
}
