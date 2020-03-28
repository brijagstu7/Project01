package IO.mathmodel_5_22;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class edge{
    vertex v1;
    vertex v2;

    public edge(vertex v1, vertex v2) {
        this.v1 = v1;
        this.v2 = v2;
    }
}

class vertex{
    int locno;
    String locname;
    int busno;
    vertex nxtloc;
    vertex lstloc;
    int d;

    public vertex(int locno, int busno) {
        this.locno = locno;
        this.busno = busno;
    }
}

public class dijks {
    HashMap<vertex[], Integer>map = new HashMap<>();
    ArrayList<HashSet<vertex>> hv = new ArrayList<>(){

    };

    static {

    }

    public static void main(String[] args) {

        File file = new File("/users/yang_sijie/mathmodel_re.txt");

        RandomAccessFile raf;
        Scanner sc;

        try {
            raf = new RandomAccessFile(file,"r");
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }



}
