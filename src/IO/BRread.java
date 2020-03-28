package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BRread {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		char c;
		BufferedReader br = new BufferedReader
				(new InputStreamReader(System.in));
		do {
			c = (char) br.read();
			System.out.print(c);
		}while(c != 'q');
		
		//the followings are the NIO way to get a buffered reader
		br = Files.newBufferedReader(Paths.get("./src/IO/example.rtf"));
		System.out.println(br.readLine());
	}

}
