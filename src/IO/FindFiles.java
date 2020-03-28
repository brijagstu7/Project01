package IO;

import java.io.File;
import java.io.FileFilter;

public class FindFiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File file = new File("src/IO");
		File[] list = file.listFiles(new FileFilter() {
			//an awesome case of anonymous class.
			@Override
			public boolean accept(File file) {
				//this method find files with specific
				//features.
				// TODO Auto-generated method stub
				return file.getPath().endsWith(".java");
			}
			
		});
		for(File i:list) {
			System.out.println(i);
		}
	}

}
