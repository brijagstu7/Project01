package IO;

import java.io.File;

public class DeleteDir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File(".");//. means current dir
		File[] files = file.listFiles();
		
		get(files);
		//To delete a directory is permitted only
		//if it does not have any child folders.
		//Hence you have to iterate all contents.
	}
	static void get(File[] files) {
		File[] tmp;
		for(File i:files) {
			System.out.println(i);
			tmp = i.listFiles();
			if(tmp!=null)get(tmp);
		}
	}
}
