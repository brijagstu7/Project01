package IO.NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class copyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//copy is a static method of Files classes.
		try {
			//copy to output stream
			Files.copy(Paths.get("./a.txt"), System.out);
			//copy to another file
			Files.copy(Paths.get("./a.txt"), 
					Paths.get("./src/IO/NIO/a.txt"), 
					StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
