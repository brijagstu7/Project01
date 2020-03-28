package try01;
/*
 * 为什么使用Java：
 * 我为了使作业尽可能与所学内容对应，已经几乎没有使用c++模版库，而全部使用c语言代码，
 * 但是c语言有一个难以解决的弊病，就是硬件依赖性严重，我只找到了一个库windows.h
 * 包含对bmp图像的操作（而且还只有bmp文件），它只能在Windows OS上使用，不能在
 * 我的Mac设备上调试运行。然而Java提供的BufferedImage类提供对所有图像格式文件的
 * 支持，且不依赖于设备，完美诠释了Java "Write once, run everywhere" 的特点。
 */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;



public class GraphTransfer {
	
	static FileChannel fc = null;
	static FileOutputStream fos = null;
	static ByteBuffer buf = ByteBuffer.allocate(5);

	static boolean writeTo(byte i0, boolean mode) {
		
		if (mode) {
			buf.rewind();
			buf.put(i0);
			buf.rewind();
			try {
				fc.write(buf);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		else{
			buf.rewind();
			buf.put((byte) '\n');
			buf.rewind();
			try {
				fc.write(buf);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	@SuppressWarnings("deprecation")
	public static void main(String args[]) {
		
		File file = new File(args[0]);
		
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int width = bi.getWidth();
		int height = bi.getHeight();
		int minx = bi.getMinX();
		int miny = bi.getMinY();
		
		System.out.println("width:"+width+" height:"+height);
		/*
		 * System.out.println("width=" + width + ",height=" + height + ".");
		 * System.out.println("minx=" + minx + ",miniy=" + miny + ".");
		 */

		try {
			File f = new File("/Users/Yang-sijie/Library/Mobile Documents/com~apple~CloudDocs/eclipse-workspace/Project01/src/try01/tmp0.tmp");
			if(f.exists())
				fos = new FileOutputStream("/Users/Yang-sijie/Library/Mobile Documents/com~apple~CloudDocs/eclipse-workspace/Project01/src/try01/tmp1.tmp");
			else
				fos = new FileOutputStream("/Users/Yang-sijie/Library/Mobile Documents/com~apple~CloudDocs/eclipse-workspace/Project01/src/try01/tmp0.tmp");
			fc = fos.getChannel();
			
			/*
			buf.put("0".getBytes());
			buf.rewind();
			fc.write(buf);
			*/
			
			buf.put(new Integer(width).toString().getBytes());
			buf.rewind();
			fc.write(buf);
			
			buf.rewind();
			buf.put(new Integer(height).toString().getBytes());
			buf.rewind();
			fc.write(buf);
			
			buf = ByteBuffer.allocate(1);
			buf.put((byte)'\n');
			buf.rewind();
			fc.write(buf);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
		
		for (int i = minx; i < width; i++) {
			for (int j = miny; j < height; j++) {

				// The really major problem is how to judge in which case should a pixel
				// be transfered to 000000 or FFFFFF.
				int pixel = bi.getRGB(i, j);
				
				 //* rgb[0] = (pixel & 0xff0000 ) >> 16 ; rgb[1] = (pixel & 0xff00 ) >> 8 ; rgb[2]
				 //* = (pixel & 0xff );
				 
				// System.out.println("i="+i+",j="+j+":"+rgb[0]+","+rgb[1]+","+rgb[2]+")");

				// Here, not so strictly, we think an RGB with F as its highest bits should
				// be transfered to white(0) and black(1) otherwise.
				char i0 = (((pixel << 8) & 0xf0000000) == 0xf0000000) ? '0' : '1';
				// System.out.println("i=" + i + ",j=" + j + ":" + i0);

				if (!writeTo((byte) i0, true))
					return;
				//System.out.println("one");
			}
			writeTo((byte)0,false);
		}
		
		
	}
}
