package IO.NIO;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class channelDemo {
/*
 *  ************	Ⅱ		************	Ⅲ	 ************
 * 	*	FILE   *  read()	*  CHANNEL *  get()  *  BUFFER  *
 * 	*		   *  ----->	*		   * ------> *		    *
 * 	************			************		 ************
 * I.definitions
 * Path.get("...")	   ByteChannel fc = ...	  ByteBuffer buf = ...
 *   
 * Ⅱ.read from FILE to CHANNEL
 * Ⅲ.get a character from BUFFER
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int tmp=0;
		Path p = Paths.get("./a.txt");
		
		try( SeekableByteChannel fc = Files.newByteChannel(p) ) {
			
			ByteBuffer buf = ByteBuffer.allocate(100);
			//Ⅱ
			fc.read(buf);
			
			//After being read, the buffer is pointed at the end.
			buf.rewind();//flip is a similar method as rewind.
			//Ⅲ
			System.out.print((char)buf.get());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
	}

}
