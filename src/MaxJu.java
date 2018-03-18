import java.util.*;

public class MaxJu {

    public static void main(String[] args){

        Scanner scan=new Scanner(System.in);
        int N = scan.nextInt();
        int[] num=new int[N];
        for(int i=0;i<N;i++) num[i]=scan.nextInt();

        int result=0;
        for(int i=0;i<N;i++)
        {
            int width=1;
            for(int j=i-1;j>=0;--j)
            {
                if(num[j] < num[i]) break;
                ++width;
            }
            for(int j=i+1;j<N;++j)
            {
                if(num[j] < num[i]) break;
                ++width;

            }
            int area = width*num[i];
            result = Math.max(area,result);

        }
        System.out.println(result);

    }

}
