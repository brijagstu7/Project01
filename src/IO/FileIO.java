package IO;

import java.io.File;
import java.io.IOException;

public class FileIO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//use / or File.separator as division, 
		//meeting all situations
		File file = new File("C:\\Users\\brija\\Documents\\IT\\C\\example.txt");
		//constructor do not read or write real file,
		//only saving a path.
		System.out.println(file);
		//file.toString prints the path of itself.
		System.out.println(file.isFile());
		//returns the bytes of length of file or folder.
		System.out.println(file.exists());
		System.out.println(file.length());
		//we see that an empty text file occupies 2b,
		//in current OS.
		
		file = new File("a.txt");
		//it creates only when it is not existed
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		file = new File("C:\\Users\\brija\\Documents\\IT\\C\\");
		System.out.println(file.isDirectory());
		file = new File("new/new");//a relative path.
		//mkdir: make directory, but not make parent
		//dir. mkdirs makes parent dir if needed.
		System.out.println(file.mkdirs());
		file.delete();
		
		
	}
	
	
}
