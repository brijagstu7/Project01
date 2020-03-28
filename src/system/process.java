package system;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class process {


    //i need more.
	public static void main(String args[]) {
		Process p = null;
		Runtime r = Runtime.getRuntime();
		//we gotta open an external process.
		System.out.println("hello");
        InputStream in = null;
        try {
			p = r.exec(new String[]{"/bin/sh","echo","hello"});
            /**
             * I really want to know, why it cannot print!
             */
			p.waitFor();
            in = p.getInputStream();
            BufferedReader read = new BufferedReader(new InputStreamReader(in));
            String result = read.readLine();
            System.out.println("INFO:"+result);
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
