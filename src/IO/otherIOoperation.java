package IO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Scanner;

/**
 * those operations to input and output are generally 
 * traditional and limited in functions, comparing
 * to other classes in this package.
 */
//try-catch features auto-close for Stream objects
public class otherIOoperation {
//a file can open itself.
	//@Test
	public void file_input_stream() {
		// TODO Auto-generated method stub
		FileInputStream fi = null;
		try {
			fi = new FileInputStream(
					"./src/IO/otherIOoperation.java");
			System.out.println("available bytes: "+
					fi.available());
			for (int i = 0; i < 20; i++) 
				System.out.print((char)fi.read());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//FileOutputStream with write.
	public void sequence_input_stream() {
		FileInputStream fi = null, fo = null;
		SequenceInputStream si = null;
		try {
			fi = new FileInputStream(
					"test.txt");
			fo = new FileInputStream("./src/IO/info");
			si = new SequenceInputStream(fi,fo);
			//link two InputStreams.
			Scanner sc = new Scanner(si);
			while(sc.hasNext()) {
				System.out.print(sc.next()+" ");
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//@Test
	//a demo for BR performances as RAF do
	public void testR() {
		int i=0;
		try {
			FileReader fr = new FileReader
					("./src/IO/info");
			BufferedReader br = new BufferedReader(fr);
			for(;i<100;i++) {
				if(i==50)br.mark(10);
				System.out.print((char)br.read());
			}
			br.reset();
			for(i=0;i<50;i++)
				System.out.print((char)br.read());
			System.out.println(br.readLine());
			//in BR, as you see, strings are delimited
			//by LF.
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
