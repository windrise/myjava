
import java.util.*;
public class ISBN {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = str1.replace("-", "");
        int[] isbn= new int[11];
        int sum=0;
        char cc='0';

        for(int i=0;i<9;i++)
        {
            int ii=(int)str2.charAt(i)-(int)'0';
            sum += ii*(i+1);
        }
        sum = sum%11;
        if(sum == 10)
            cc = 'X';
        else
            cc = (char)(sum + (int)'0');
        if(cc == str2.charAt(9))
            System.out.println("Right");
        else{
            str1 = str1.substring(0,12) + cc;
            System.out.println(str1);
        }

    }

}
