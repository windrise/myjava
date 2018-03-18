//201312-4
import java.util.*;

public class FunnyNum {
    public static void main(String[] args){
        new FunnyNum().run();
//        System.out.println(resolve(5,6));
    }
    void run(){
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        long[][] nums=new long[2][6];
        long mod=1000000007;
        int j=0;
        nums[0][0]=1;
        for(int i=1;i<n;i++)
        {

            nums[i%2][0]=(nums[(i-1)%2][0]) % mod;
            nums[i%2][1]=(2*nums[(i-1)%2][1]+nums[(i-1)%2][0]) % mod;
            nums[i%2][2]=(nums[(i-1)%2][2]+nums[(i-1)%2][0]) % mod;
            nums[i%2][3]=(2*nums[(i-1)%2][3]+nums[(i-1)%2][1]) % mod;
            nums[i%2][4]=(2*nums[(i-1)%2][4]+nums[(i-1)%2][1]+nums[(i-1)%2][2]) % mod;
            nums[i%2][5]=(2*nums[(i-1)%2][5]+nums[(i-1)%2][3]+nums[(i-1)%2][4]) % mod;

        }
//        for(int i=1;i<n;i++)
//        {
//            j=i-1;
//            nums[i][0]=(nums[j][0]) % mod;
//            nums[i][1]=(2*nums[j][1]+nums[j][0]) % mod;
//            nums[i][2]=(nums[j][2]+nums[j][0]) % mod;
//            nums[i][3]=(2*nums[j][3]+nums[j][1]) % mod;
//            nums[i][4]=(2*nums[j][4]+nums[j][1]+nums[j][2]) % mod;
//            nums[i][5]=(2*nums[j][5]+nums[j][3]+nums[j][4]) % mod;
//
//        }
        System.out.println(nums[(n-1)%2][5]);
    }


//    //递归版本  错的
//    static long mod = 1000000007;
//    static long resolve(int n,int status) {
//        if (n == 1&&status==1) return 1;
//        if (n == 2&&status==2) return 1;
//        if (n == 2&&status==3) return 1;
//        if (n == 3&&status==4) return 1;
//        if (n == 3&&status==5) return 2;
//        if (n == 4&&status==6) return 3;
//        switch (status) {
//            case 1:
//                return resolve(n - 1, 1) % mod;
//            case 2:
//                return (2 * resolve(n - 1, 2)) % mod;
//            case 3:
//                return (resolve(n - 1, 3) + resolve(n - 1, 1)) % mod;
//            case 4:
//                return (2 * resolve(n - 1, 4) + resolve(n - 1, 2)) % mod;
//            case 5:
//                return (2 * resolve(n - 1, 5) + resolve(n - 1, 2) + resolve(n - 1, 3)) % mod;
//            case 6:
//                return (2 * resolve(n - 1, 6) + resolve(n - 1, 4) + resolve(n - 1, 5)) % mod;
//        }
//        return 1;
//    }

}
