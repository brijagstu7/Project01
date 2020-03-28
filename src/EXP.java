import java.io.Serializable;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

class DateTime {
    Calendar calendar = Calendar.getInstance(Locale.CHINESE);

    //当前对象[this]减去参数对象[before]，得到日期差值[天数]
    public int subtract(DateTime before){
        long ld1=DateTime.parseDatePart(this.toDatePartString()).getTimeMilliseconds();
        long ld2=DateTime.parseDatePart(before.toDatePartString()).getTimeMilliseconds();
        return (int)((ld1-ld2)/(24*60*60*1000));
    }

    public Calendar getCalendar() {
        return calendar;
    }

    // 用系统当前时间构造
    public DateTime() {
        calendar.setTime(new Date());
    }

    // 指定毫秒时长构造
    public DateTime(long mm) {
        calendar.setTime(new Date(mm));
    }

    // 用指定日期参数构造
    public DateTime(int year, int month, int day) {
        calendar.set(year, month - 1, day);
    }

    // 用指定日期时间参数构造
    public DateTime(int year, int month, int day, int hour, int minute,
                    int second) {
        calendar.set(year, month - 1, day, hour, minute, second);
    }


    // 用一个Date对象构造
    public DateTime(Date date) {
        calendar.setTime(date);
    }

    // 用一个Date对象重置时间
    public void setDate(Date date) {
        calendar.setTime(date);
    }

    // 用毫秒数重置时间(从1970年开始)
    public void setTimeMilliseconds(long milliseconds) {
        calendar.setTimeInMillis(milliseconds);
    }

    // 不改变当前对象,返回新的对象
    public DateTime addDays(int days) {
        DateTime newDT = new DateTime(this.getDate());
        newDT.calendar.add(Calendar.DAY_OF_YEAR, days);
        return newDT;
    }

    // 不改变当前对象,返回新的对象
    public DateTime addMonths(int months) {
        DateTime newDT = new DateTime(this.getDate());
        newDT.calendar.add(Calendar.MONTH, months);
        return newDT;
    }

    // 不改变当前对象,返回新的对象
    public DateTime addYears(int years) {
        DateTime newDT = new DateTime(this.getDate());
        newDT.calendar.add(Calendar.YEAR, years);
        return newDT;
    }

    // 不改变当前对象,返回新的对象
    public DateTime addMinutes(int minutes) {
        DateTime newDT = new DateTime(this.getDate());
        newDT.calendar.add(Calendar.MINUTE, minutes);
        return newDT;
    }

    // 不改变当前对象,返回新的对象
    public DateTime addHours(int hours) {
        DateTime newDT = new DateTime(this.getDate());
        newDT.calendar.add(Calendar.HOUR, hours);
        return newDT;
    }

    // 不改变当前对象,返回新的对象
    public DateTime addMilliseconds(int mss) {
        DateTime newDT = new DateTime(this.getDate());
        newDT.calendar.add(Calendar.MILLISECOND, mss);
        return newDT;
    }

    public Date getDate() {
        return calendar.getTime();
    }



    public int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    public int getMonth() {
        return calendar.get(Calendar.MONTH) + 1;
    }

    public int getDay() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    // 0-sunday,1-monday,...
    public int getDayOfWeek() {
        return calendar.get(Calendar.DAY_OF_WEEK) - Calendar.SUNDAY;
    }

    public int getHour() {
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public int getMinute() {
        return calendar.get(Calendar.MINUTE);
    }

    public int getSecond() {
        return calendar.get(Calendar.SECOND);
    }

    public int getMillisecond() {
        return calendar.get(Calendar.MILLISECOND);
    }

    //计时开始[如,1970年1月1日0时0分0秒0毫秒]的总毫秒数
    public long getTimeMilliseconds() {
        return calendar.getTimeInMillis();
    }

    public String toYearMonthPartHzString() {
        return String.format("%d年%02d月", calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1);
    }

    public String toYearMonthPartString() {
        return String.format("%d-%02d", calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1);
    }

    public String toMonthDayPartHzString() {
        return String.format("%2d月%2d日",	calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH));
    }

    public String toDatePartHzString() {
        return String.format("%d年%02d月%02d日", calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH));
    }

    public String toDatePartString() {
        return String.format("%d-%02d-%02d", calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH));
    }

    public String toDateTimeString() {
        return String.format("%d-%02d-%02d %02d:%02d:%02d",
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
    }

    public String toTimePartString() {
        return String.format("%02d:%02d:%02d",
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
    }

    public String toTimePartStringByEndOfMunite() {
        return String.format("%02d:%02d",
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE));
    }

    public String toTimePartWithMillisecondString() {
        return String.format("%02d:%02d:%02d.%d",
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND),
                calendar.get(Calendar.MILLISECOND));
    }

    // dateText: 2013-10-26
    public static DateTime parseDatePart(String dateText) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            ParsePosition pos = new ParsePosition(0);
            Date date = formatter.parse(dateText, pos);
            return new DateTime(date);
        } catch (Exception ex) {
            return null;
        }
    }

    // dateText: 2013-10-25 18:50:30
    public static DateTime parseDateTime(String dateText) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss");
            ParsePosition pos = new ParsePosition(0);
            Date date = formatter.parse(dateText, pos);
            return new DateTime(date);
        } catch (Exception ex) {
            return null;
        }
    }

    // dateText: 2013-10-25 18:50:30.120
    public String toDateTimeWithMillisecondString() {
        return String.format("%d-%02d-%02d %02d:%02d:%02d.%d",
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND),
                calendar.get(Calendar.MILLISECOND));
    }

    // dateText: 2013-10-25 18:50:30.120
    public static DateTime parseDateTimeWithMillisecond(String dateText) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss.SSS");
            ParsePosition pos = new ParsePosition(0);
            Date date = formatter.parse(dateText, pos);
            return new DateTime(date);
        } catch (Exception ex) {
            return null;
        }
    }

    // dateText: 2013-10-25 18:50
    public String toDateTimeStringByEndOfMunite() {
        return String.format("%d-%02d-%02d %02d:%02d",
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE));
    }

    // dateText: 2013-10-25 18:50
    public static DateTime parseDateTimeByEndOfMunite(String dateText) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm");
            ParsePosition pos = new ParsePosition(0);
            Date date = formatter.parse(dateText, pos);
            return new DateTime(date);
        } catch (Exception ex) {
            return null;
        }
    }

}


//1) 表示第一小题 后同
class Person implements Comparable<Person> , Serializable {

    private String id;
    private String name;
    private String gender;
    private DateTime birthday;

    public Person(String id, String name, String gender, DateTime birthday) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }
    public Person(String id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    Person() {
    }

    public Person(String id, String name, String gender, long ms) {
        this.id = id;
        this.name = name;
        this.gender = gender;

        this.setBirthday(new DateTime(ms));
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(DateTime birthday) {
        this.birthday = birthday;
    }

    @Override
    public int compareTo(Person o) {
        /*
        5/19第二次提交
        因为较长的身份证号超过了int的存储值而且不存在ParseLong方法，我把身份证号截断2半然后拼接后比较。
         */
        int num00 = Integer.parseUnsignedInt(this.id.substring(0,this.id.length()/2));
        int num01 = Integer.parseUnsignedInt(this.id.substring(this.id.length()/2));
        int num10 = Integer.parseUnsignedInt(o.id.substring(0,o.id.length()/2));
        int num11 = Integer.parseUnsignedInt(o.id.substring(o.id.length()/2));

        long num0 = num00*(long)Math.pow(10,(int)(Math.log10(num01)+1))+num01;
        long num1 = num10*(long)Math.pow(10,(int)(Math.log10(num11)+1))+num11;
        if (num0>num1){
            return 1;
        }else if(num0==num1){
            return 0;
        }else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}

class CompSal implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.salary > o2.salary){
            return 1;
        }else if (o1.salary == o2.salary){
            return 0;
        }else {
            return -1;
        }
    }
}

class CompNatrl implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        int num00 = Integer.parseUnsignedInt(o1.getId().substring(0,o1.getId().length()/2));
        int num01 = Integer.parseUnsignedInt(o1.getId().substring(o1.getId().length()/2));
        int num10 = Integer.parseUnsignedInt(o2.getId().substring(0,o2.getId().length()/2));
        int num11 = Integer.parseUnsignedInt(o2.getId().substring(o2.getId().length()/2));

        long num0 = num00*(long)Math.pow(10,(int)(Math.log10(num01)+1))+num01;
        long num1 = num10*(long)Math.pow(10,(int)(Math.log10(num11)+1))+num11;
        if (num0>num1){
            return 1;
        }else if(num0==num1){
            return 0;
        }else {
            return -1;
        }
    }
}

//2)
class Employee extends Person{
    String corp;
    double salary;

    public Employee(String id, String name, String gender, DateTime birthday, String corp, double salary) {
        super(id, name, gender, birthday);
        this.salary = salary;
        this.corp = corp;
    }
    public Employee(String id, String name, String gender, long ms, String corp, double salary) {
        super(id, name, gender);
        this.setBirthday(new DateTime(ms));
        this.corp = corp;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "corp='" + corp + '\'' +
                ", salary=" + salary +
                "} " + super.toString();
    }

    @Override
    public int compareTo(Person o) {
        return super.compareTo(o);


    }


}

public class EXP{

    static CompSal c = new CompSal();


    //4)
    static void outputList(List<Person> list, Comparator<Person>fx){

        if (fx == null){
            //自然顺序,此处使用lambda，与 new Comparator<>fx(){..} 匿名类等同

            list.sort(new CompNatrl());
        }else {
            list.sort(fx);
        }


        for (Person p :
                list) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {


        //3)
        Employee[] emps = {
            new Employee("2151511351231","mike","male",2135654622,"ti",4136452),
            new Employee("2154353451643","jerry","male",341235462,"ue",1),
            new Employee("7643431435511","patreolin","female",22312565,"hw",546434),
            new Employee("3645643473234","terry","male",1243214122,"bd",99999),
            new Employee("6431565478422","alice","female",2121356546,"tc",0),
        };

        Arrays.sort(emps,c);
        for (Employee e :
                emps) {
            System.out.println(e);
        }

        //5)
        ArrayList<Person> arr = new ArrayList<>(){
            {
                add(new Person("123134124123","miku","female", 824125151));
                add(emps[1]);
                add(new Person("431154112421","sans","female", 435123242));
            }
        };

        outputList(arr, null);

        outputList(arr, Comparator.comparingInt(o -> o.getBirthday().getMillisecond()));

        //6)
        TreeSet<Person> treeSet = new TreeSet<>(){


            {
                addAll(arr);
            }
        };
        System.out.println(treeSet);

        //7)
        TreeMap<String, Person> map = new TreeMap<>(){


            {
                for (Person p :
                        arr) {
                    put(p.getId(), p);
                }
            }
        };
        System.out.println(map);

        //8)
        HashMap<Integer, Person>map1 = new HashMap<>();
        HashMap<Boolean, Person>map2 = new HashMap<>();


        int[] yrs = new int[13];
        int[] genders = new int[2];
        int empno = 0;
        for (Person p :
                arr) {
            /*
            switch (p.getBirthday().getYear()){
                  case 1:yrs[1]++;map1.put(1,p);break;
                  case 2:yrs[2]++;map1.put(2,p);break;
                  case 3:yrs[3]++;map1.put(3,p);break;
                  case 4:yrs[4]++;map1.put(4,p);break;
                  case 5:yrs[5]++;map1.put(5,p);break;
                  case 6:yrs[6]++;map1.put(6,p);break;
                  case 7:yrs[7]++;map1.put(7,p);break;
                  case 8:yrs[8]++;map1.put(8,p);break;
                  case 9:yrs[9]++;map1.put(9,p);break;
                case 10:yrs[10]++;map1.put(10,p);break;
                case 11:yrs[11]++;map1.put(11,p);break;
                case 12:yrs[12]++;map1.put(12,p);break;
            }
            */
            map1.put(p.getBirthday().getYear(),p);

            switch (p.getGender()){
                case "male":genders[1]++;map2.put(true,p);break;
                case "female":genders[0]++;map2.put(false,p);break;
            }
            if (p.getClass().getName().equals("employee")){
                empno++;
            }
        }

        System.out.println(map1);
        System.out.println(genders[1]+"males"+genders[0]+"females");
        System.out.println(empno+"employees");
    }
}