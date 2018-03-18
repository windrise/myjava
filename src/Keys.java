
import java.util.*;
public class Keys {

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int N=0,K=0;
        N=scanner.nextInt();
        K=scanner.nextInt();
        int[] box=new int[N+1];
        for (int i =0;i<=N ;i++) box[i]=i;
        int[][] record=new int[K][4];
        for(int i=0;i<K;i++)
            for(int j=0;j<3;j++){
                record[i][j]=scanner.nextInt();
            }
        for(int i=0;i<K;i++) record[i][3]=record[i][1]+record[i][2];
        int [] time = new int[K];
        HashSet<Integer>  s = new HashSet<Integer>();
        HashSet<Integer>  c = new HashSet<Integer>();
        for(int i=0;i<K;i++)
        {
            time[i]=record[i][3];
            s.add(record[i][1]);
            c.add(time[i]);
        }
        Arrays.sort(time);
        int [][] as= new int[K][4];
        for(int i=0;i<as.length;i++)
                as[i][0]=1001;

        for(int t=0;t<=time[K-1];t++){
            if(c.contains(t))
            {
                int x=0;


                for(int j=0;j<record.length;j++){

                    if(record[j][3]==t)
                    {

                        as[x][0]=record[j][0];
                        as[x][1]=record[j][1];
                        as[x][2]=record[j][2];
                        as[x][3]=record[j][3];
                        x++;

                    }

                }
                //归还
//                Sort(as,0);
                Arrays.sort(as, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if(o1==o2) return o1[0] -o2[0];
                        return o1[0]-o2[0];
                    }
                });
                int y=0;
                for(int n=1;n<box.length;n++)
                {
                    if(box[n]==-1)
                    {
                        box[n]=as[y][0];
                        as[y][0]=1001;
                        y++;
                    }
                    if(y>=x) break;

                }
            }

            if(s.contains(t))
            {
                for(int i=0;i<record.length;i++)
                {
                    if(record[i][1] == t)
                    {
                        for(int w=1;w<box.length;w++)
                        {
                            if(box[w] == record[i][0])
                                box[w]=-1;
                        }

                    }
                }

            }

        }
        for(int i=1;i<box.length;i++)
            System.out.print(box[i]+" ");
//        System.out.println();
    }
//    public static void Sort(int[][] array,int i)
//    {
//        Arrays.sort(array, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o1==o2) return o1[i] -o2[i];
//                return o1[i]-o2[i];
//            }
//        });
//    }



}
