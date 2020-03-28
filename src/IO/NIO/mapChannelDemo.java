package IO.NIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class mapChannelDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path p = Paths.get("./a.txt");
		
		try( FileChannel fc = (FileChannel)Files.newByteChannel(p) ){
			//It will be easier to use the map method to 
			//access file via channels than traditions.
			ByteBuffer b = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
			
			System.out.println((char)b.get());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
