import java.util.*;

public class MidNum {

    public static void main(String[] args){
        new MidNum().run();
    }
    public void judge(int[] array, int mid){
        int less=0,more=0;
        for(int a : array ){
            if( a < mid ) less++;
            if( a > mid ) more++;
        }
        if(less == more ) System.out.println(mid);
        else System.out.println("-1");

    }

    public void run(){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[] array = new int[num];

        for(int i=0;i<num;i++) array[i] = scan.nextInt();
        Arrays.sort(array);
        int mid=0;
        int mid_index=num/2;
        mid = array[mid_index];
        if(num %2 ==0)
        {
            if(array[mid_index] != array[mid_index-1])
            {
                System.out.println("-1");
            }else judge(array,mid);

        }else judge(array,mid);


    }

}