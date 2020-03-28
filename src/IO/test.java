package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis;
		File f;
		f = new File("./a.txt");
		
		//current directory is always at Project
		
		
		try {
			//except for File, other IO operations
			//do not support auto-add files
			fis = new FileInputStream(f);
			while(fis.read()!=-1)
				System.out.println((char)fis.read());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
