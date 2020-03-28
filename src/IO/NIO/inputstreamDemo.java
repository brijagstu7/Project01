package IO.NIO;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class inputstreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//the method of Files can pass an InputStream 
			//enabling processes of traditional IO.
			InputStream is = Files.newInputStream(Paths.get("./a.txt")
					, StandardOpenOption.READ);
			System.out.println((char)is.read());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
