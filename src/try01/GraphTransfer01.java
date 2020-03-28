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

import javax.imageio.ImageIO;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class GraphTransfer01 {
	static class node{
		
	    node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		int x,y;
	}
	static node now = new node(0,0),nxt = new node(0,0);
	static int to[][] = {{0,1},{0,-1},{1,0},{-1,0}};
	static ArrayList<ArrayList<Integer>> 
	mp0 = new ArrayList<ArrayList<Integer>>(), mp1 = new ArrayList<ArrayList<Integer>>();
	/*
	static FileChannel fc = null;
	static FileOutputStream fos = null;
	static ByteBuffer buf = ByteBuffer.allocate(5);
	*/
	
	private static boolean countQ = true;
	private static int cnt0;
	private static int cnt1;
	
	static void BFS(int x,int y, ArrayList<ArrayList<Integer>>mp){
	    boolean passQ = (mp.get(x).get(y) == -1);
	    if (passQ) {
	        countQ  = false;
	        return;
	    }
	    
	    now.x = x;
	    now.y = y;
	    Queue<node>q = new LinkedList<node>();
	    q.add(now);
	    
	    while(!q.isEmpty()){
	        now = q.poll();
	        
	        //This loop pushes pixels around the current one.
	        for(int i = 0;i < 4;i++){
	            nxt.x = now.x + to[i][0];
	            nxt.y = now.y + to[i][1];
	            
	            if((nxt.x < 0) || (nxt.x >= mp.get(0).size()) || (nxt.y < 0) || (nxt.y >= mp.size())) {
	                //this means: the circle is not available.
	                countQ = false;
	                continue;
	            }
	            if((-1==mp.get(nxt.x).get(nxt.y))||(mp.get(nxt.x).get(nxt.y)==1))/* || (*mp[nxt.x][nxt.y] == 1)*/
	            	continue;
	            
	            q.add(new node(nxt.x,nxt.y));
	        }
	        //wipe out current pixel.
	        mp.get(now.x).set(now.y, -1);
	    }
	}
	/*
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
	*/
	
	private static void GetArr(String arg, ArrayList<ArrayList<Integer>>mp) {
		File file = new File(arg);
		// "/Users/yang-sijie/Downloads/2018052010110533005.bmp"
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
			
			System.exit(-1);
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

		/*
		try {
			File f = new File("./tmp0.tmp");
			if(f.exists())
				fos = new FileOutputStream("./tmp1.tmp");
			else
				fos = new FileOutputStream("./tmp0.tmp");
			fc = fos.getChannel();
			
			
			//buf.put("0".getBytes());
			//buf.rewind();
			//fc.write(buf);
			
			
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
		*/
		
		for (int i = minx; i < width; i++) {
			mp.add(new ArrayList<Integer>());
			for (int j = miny; j < height; j++) {

				// The really major problem is how to judge in which case should a pixel
				// be transfered to 000000 or FFFFFF.
				int pixel = bi.getRGB(i, j);
				
				 //* rgb[0] = (pixel & 0xff0000 ) >> 16 ; rgb[1] = (pixel & 0xff00 ) >> 8 ; rgb[2]
				 //* = (pixel & 0xff );
				 
				// System.out.println("i="+i+",j="+j+":"+rgb[0]+","+rgb[1]+","+rgb[2]+")");

				// Here, not so strictly, we think an RGB with F as its highest bits should
				// be transfered to white(0) and black(1) otherwise.
				int i0 = (((pixel << 8) & 0xf0000000) == 0xf0000000) ? 0 : 1;
				
				mp.get(mp.size()-1).add(i0);
				
				/*
				if (!writeTo((byte) i0, true))
					return;
				*/
			}
			//writeTo((byte)0,false);
		}
		
		
	
	}
	
	
	public static void main(String args[]) {
		GetArr(args[0], mp0);
		
		for (int i=0; i!=mp0.get(0).size(); i++) {
	        for (int j=0; j!=mp0.size(); j++) {
	            BFS(i, j, mp0);
	            if (countQ) {
	                cnt0++;
	            }
	            countQ = true;
	        }
	    }
		
		mp0.clear();
		GetArr(args[1], mp1);
		
		for (int i=0; i!=mp1.get(0).size(); i++) {
	        for (int j=0; j!=mp1.size(); j++) {
	            BFS(i, j, mp1);
	            if (countQ) {
	                cnt1++;
	            }
	            countQ = true;
	        }
	    }
		mp1.clear();
		
		System.out.printf("The input graph one is%s equal to graph two.\n",(cnt0==cnt1)?"":" not");
	}
}
