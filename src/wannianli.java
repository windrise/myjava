/*
程序说明；
根据1900年1月1日是星期一
 */

import java.util.Scanner;

class wannian{
    Scanner i = new Scanner(System.in);
    public int year;
    public int month;
    public int day;
    //判断是否为闰年
    public boolean isRun(int year){
        boolean isRn = false;
        isRn = ((year % 4 == 0) && !(year % 100 == 0) || year % 400 == 0);
        return isRn;
    }
    public int monthSumDay(int year, int month){
        int day=0;
        switch (month) {
            case 2:
                if (isRun(year)) {
                    day = 29;
                } else {
                    day = 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                day = 30;
                break;
            default:
                day = 31;
                break;
        }
        return day;
    }

    //计算该当年对应于该年的第多少天
    public int totalDay(int year, int month, int day){
        int sumDay=0;//总天数
        for(int i= 1900; i<year; i++){
            if(isRun(i))
                sumDay=sumDay+366;
            else
                sumDay=sumDay+365;
        }
        //计算当月距于1月多少天
        int beforeday=0;
        int d=0;
        for(int i=1;i<month;i++)
        {
            switch(i){
                case 2:
                    if(isRun(year))
                        d=29;
                    else
                        d=28;
                case 4:
                case 6:
                case 9:
                case 11:
                    d=30;
                    break;
                default:
                    d=31;
                    break;
            }
            beforeday = beforeday+d;
        }
        sumDay = sumDay+beforeday;

        return sumDay;

    }

    //判断周几
    public int weekNum(int year,int month, int day){
        int thisMonthFirstDay=0;
        int temp=1+totalDay(year,month,day)%7;
        if(temp != 7){
            thisMonthFirstDay=temp;
        }
        return thisMonthFirstDay;
    }

    public void printCalendar(int year,int month, int day){
        int mfd = weekNum(year,month,day);
        int sumDay=totalDay(year,month,day);
        int monthSum=monthSumDay(year,month);
        System.out.println("\n日\t一\t二\t三\t四\t五\t六");
        for(int i=0; i<mfd;i++)
        {
            System.out.print("\t");
        }
        for(int i=1;i<=monthSum;i++){
            System.out.print(i+"\t");

            if((sumDay+i-1)%7==5){//星期六换行
                System.out.println();
            }

        }
        System.out.println();
    }

    public void show(){
        System.out.println("*****java万年历程序******");
        String isRun="y";
        while(isRun.equals("y")){
            System.out.print("请输入年：");
            int year=i.nextInt();
            System.out.print("请输入月：");
            int month=i.nextInt();
            System.out.print("请输入日：");
            int day=i.nextInt();
            this.printCalendar(year,month,day);
            System.out.print("\n是否继续（y/n)：");
            isRun=i.next();
        }
    }



}

public class wannianli{
    static wannian fu= new wannian();
    public static void main(String[] args){
        fu.show();
    }

}

