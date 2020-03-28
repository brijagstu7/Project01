package IO;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccess_file {
/*
 * see also scanner.java for FileWriter and FileReader
 * RandomAccessFile has the ability to move pointers
 * which is distinctive from the two above.
 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("./a.txt");
		
		RandomAccessFile raf =
				//r: read-only. select r,rw,rwd,rws.
				new RandomAccessFile(file,"rw");
		//write block
		
		//write automatically create the file
		//(but not folder) when it does not exist
		raf.write(65);
		//the ASCII code. If overflow, mod it.
		raf.writeBytes("12");//using ACSII
		//all these writes from the start of the file
		//non-insert.
		raf.writeUTF("我艹");//using UTF_8
		//in UTF_8, '我艹' occupies 3 bytes.
		//writeUTF input 2 bytes and "我艹" follows.
		
		System.out.print(raf.getFilePointer());
		raf.seek(raf.length()-11);//move cursor to
		raf.write("  ".getBytes());//always write from cursor.
		raf.skipBytes(6);//cursor jump 6 bytes forward. 
		raf.write('1');
		raf.length();
		/*
		char a = (char)raf.read();
		//after read once, pointer move to next char
		char b = (char)raf.read();
		System.out.print(a);
		System.out.println(b);
		*/
		System.out.println(raf.readLine());
		System.out.println(raf.readLine());
		
		//System.out.print(raf.readUTF());
		//readUTF may have some bugs
		
		raf.close();
	}

}
