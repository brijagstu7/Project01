import java.util.Scanner;
import java.io.*;
public class NEW {
	static File fw=new File("成绩.xls");
	static int num=0;//学生人数（学号）
	static int sub=0;//课程数目
	static String[]subject=null;//课程名
	static String[]name=null;//学生姓名
	static double[][]score=null;//学号对应课程的分数
	private static Scanner input;
	private static Scanner input2;
	private static Scanner input3;
	private static Scanner scan;
	static int z;

	public static void Build() {
		input3 = new Scanner(System.in);
		System.out.println("请输入学生的人数：");
		num=input3.nextInt();
		System.out.println("请输入课程的数目:");
		sub=input3.nextInt();
		String[]subject_1=new String[sub];
		subject=subject_1;

		for(int i=0;i<subject.length;i++) {

			System.out.println("请输入第"+(i+1)+"门课的名字");
			subject[i]=input3.next();

		}
		String[]name_1=new String[num];
		name=name_1;

		double[][]score_1=new double[num][sub];
		score=score_1;

		for(int i=0;i<name.length;i++) {
			System.out.println("请输入第"+(i+1)+"个学生的名字(如果输入够了就输入over)");
			name[i]=input3.next();
			if(name[i]=="over") break;
			else
			{
				for(int j=0;j<subject.length;j++) {
					System.out.println("请输入"+name[i]+"的"+subject[j]+"成绩");
					score[i][j]=input3.nextDouble();
//				double[]sum=new double[i];
//				sum[i]=sum[i]+score[i][j];
					/*
					 * 不知道这个变量是干什么的，感觉没什么用
					 */
				}}
		}
		Command();
	}
	public static void Delete() {
		input = new Scanner(System.in);
		String name1=null;
		System.out.println("请输入你需要删除的学生姓名");
		name1=input.next();
		for(int i=0;i<name.length;i++) {
			if(name1==name[i]) {
				name[i]=null;
				for(int j=0;j<subject.length;j++)
				{
					score[i][j]=0;
				}
				break;}
			else continue;
		}
		Command();
	}
	public static void Change() {
		input2 = new Scanner(System.in);
		String name2=null;
		System.out.println("请输入你需要加入的学生姓名");
		name2=input2.next();
		for(int i=0;i<name.length;i++) {
			if(name[i]==null) {
				name[i]=name2;
				for(int j=0;j<subject.length;j++) {
					score[i][j]=0;
					for(int m=0;m<subject.length;m++) {
						System.out.println("请输入"+name[i]+"的"+subject[m]+"成绩");
						score[i][m]=input2.nextDouble();}
				}
				break;
			}
			else {continue;}
		}
		Command();
	}
	public static void Show() {
		System.out.print("姓名%4s");
		for(int i=0;i<subject.length;i++) {
			System.out.printf("%4s",subject[i]);}
		System.out.print("\n");
		for(int i=0;i<num;i++) {
			if(name[i]==null) break;
			System.out.printf("%4s",name[i]);
			for(int j=0;j<subject.length;j++) {
				System.out.printf("%4f",score[i][j]);
			}
			System.out.println("");
			Command();
		}
	}

	public static void Exit(){
		System.exit(0);
	}
	public static void Command(){
		System.out.println("请输入你需要的操作数字：");
		scan = new Scanner(System.in);
		z=scan.nextInt();
		switch(z) {
			case 1:
				Build();break;
			case 2:
				Delete();break;
			case 3:
				Change();break;
			case 4:
				Show();break;
			case 5:
				Exit();break;
			default:
				System.out.println("您的输入错了！");break;
		}
	}
	public static void main(String[] args) {
		System.out.println("1.构建");
		System.out.println("2.删除");
		System.out.println("3.更改");
		System.out.println("4.显示");
		System.out.println("5.退出");
		Command();
	}
}