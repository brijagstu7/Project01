package IO.NIO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileChannel fc = null;
		FileOutputStream fos = null;      
		try {
			fos = new FileOutputStream(new File("./a.txt"));
			fc = fos.getChannel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ByteBuffer buf = ByteBuffer.allocate(10);
		buf.put("fuck it".getBytes());
		buf.rewind();
		try {
			fc.write(buf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
