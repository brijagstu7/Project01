package IO.NIO;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class fileSystemDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//Although File in old IO is functional, NIO 
			//supports better way of managing file system.
			DirectoryStream<Path> ds = Files.newDirectoryStream
					(Paths.get("."));
			//you can add wildcards to filter contents.
			
			//one good is, the class implements Iterable:
			for(Path p:ds) {
				System.out.println(p.getFileName());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
