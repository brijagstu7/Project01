package try02.Java_exp.exp2;

//下面指令表示输入数据与希望的类不匹配
import java.util.InputMismatchException;
//下面指令引入文件扫描类Scanner
import java.util.Scanner;

public class PrintController {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char cmd = 'm';
        SolarMonth sm = null;
        boolean isEnglish = true;

        System.out.println("Enter full year (e.g., 2001): ");
        int a = sc.nextInt();
        System.out.println("Enter month in number between 1 and 12: ");
        int b = sc.nextInt();

        sm = new SolarMonth(a,b);

        do {
            //在此处加入你的代码


            if (isEnglish)
                new PrintView(sm).printMonth();
            else
                new HzPrintView(sm).printMonth();
            System.out.println("M - 显示指定的年月份日历\n" +
                    "P - 显示前一月份日历\n" +
                    "N - 显示后一月份日历\n" +
                    "H - 转换打印语种[汉语]\n" +
                    "Q - 退出\n" +
                    "输入功能字符并按回车:");

            cmd = sc.next().charAt(0);

            switch (cmd){
                case 'M':
                    System.out.println("Enter full year (e.g., 2001): ");
                    int a_ = sc.nextInt();
                    System.out.println("Enter month in number between 1 and 12: ");
                    int b_ = sc.nextInt();

                    sm = new SolarMonth(a_,b_);
                    break;
                case 'P':
                    if (b!=1)
                        sm = new SolarMonth(a,b-1);
                    else
                        sm = new SolarMonth(a-1,12);

                    break;
                case 'N':
                    if (b!=12)
                        sm = new SolarMonth(a,b+1);
                    else
                        sm = new SolarMonth(a+1,1);

                    break;
                case 'H':
                    isEnglish = !isEnglish;
                    break;
                case 'Q':

                    break;
            }

        } while (cmd != 'Q');

        sc.close();

    }
}

class PrintView {
    SolarMonth solarMonth;
    public PrintView(SolarMonth solarMonth) {
        this.solarMonth = solarMonth;
    }
    public void printMonth() {
        this.printMonthTitle();
        this.printMonthBody();

    }
    public void printMonthTitle() {
        System.out.println("         "+solarMonth.getMonthName()+" "+solarMonth.getYear());
        System.out.println("------------------------------------------------");
        System.out.println("  Sun Mon Tue Wed Thu  Fri  Sat");
    }
    public void printMonthBody() {
        //------------
    }

}

class HzPrintView extends PrintView {
    public HzPrintView(SolarMonth solarMonth) {
        super(solarMonth);
    }
    //因为英文输出与中文输出仅在标题输出，所以仅需要覆盖下列方法
    @Override
    public void printMonthTitle() {
        System.out.println("         "+solarMonth.getYear()+"年"+solarMonth.getMonthNameHz()+"月");
        System.out.println("------------------------------------------------");
        System.out.println("  日  一  二  三  四  五  六");
    }
}

class SolarMonth {
    private final static String[] names = { "", "January", "February", "March",
            "April", "May", "June", "July", "August", "September", "October",
            "November", "December" }, names0 = {"","一","二","三","四","五","六","七","八","九","十","十一","十二"};

    //描述月份的两个必须数据成员
    private int year;
    private int month;
    //SolarMonth定义为不变对象，因此只定义访问器
    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    //构造方法
    public SolarMonth(int year, int month) {
        this.month = month;
        this.year  = year;
    }

    //将item1中的非打印（不含打印的）方法，定义在本类
    public String getMonthName() {
        return names[month];
    }
    public String getMonthNameHz(){
        return names0[month];
    }
    public int getStartDay() {
return 0;
    }
    private int getTotalNumberOfDays() {
        if (isLeapYear(year)){
            return 366;
        }else {
            return 365;
        }
    }
    //获取实例月份的总天数的实例方法
    public int getNumberOfDaysInMonth() {
        return getNumberOfDaysInMonth(this.year, this.month);
    }
    //获取指定月份的总天数的静态方法，为什？因为在某些方法中需要用年、月参数调用
    public static int getNumberOfDaysInMonth(int year, int month) {
        if (isLeapYear(year)){
            if (month == 1||month == 3||month == 5||month == 7||month == 8||month == 10||month == 12){
                return 31;
            }else if (month == 2){
                return 29;
            }else {
                return 30;
            }
        }else {
            if (month == 1||month == 3||month == 5||month == 7||month == 8||month == 10||month == 12){
                return 31;
            }else if (month == 2){
                return 28;
            }else {
                return 30;
            }
        }

    }
    public static boolean isLeapYear(int year) {
        return year % 4 == 0;
    }
}

