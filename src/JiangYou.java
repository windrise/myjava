
import java.util.*;

public class JiangYou {
    public static void main(String[] args){
        new JiangYou().run();
    }
    void run(){

        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int i=0,j=0,k=0;
        i=n/50;
        j=(n%50)/30;
        k=((n%50)%30)/10;

        int result=i*7+j*4+k;
        System.out.println(result);

    }

}
