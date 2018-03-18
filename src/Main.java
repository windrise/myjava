import java.util.*;

class Main{ 

    public static void main(String[] args){ 
        //读入
        Scanner sc = new Scanner(System.in); 
        
        int n = sc.nextInt(); 

        int[] s = new int[n]; 

        for(int i=0;i<n;i++){ 

            s[i] = sc.nextInt(); 

        } 

        sc.close(); 

        String tmp = " ,"+Arrays.toString(s).replaceAll("[\\[\\]\\s]","").replaceAll(",",",,")+", "; //[\\[\\]\\s]
        int max = Integer.MIN_VALUE; 

        int min = Integer.MAX_VALUE; 

        for(int i=0;i<n;i++){ 

            int si = s[i]; 

            int num = tmp.split(","+ si + ",").length - 1; 
            if(max < num){ 

                max = num; 

                min = si; 

            }else if(max == num){ 

                min = min < si ? min : si; 

            } 

        } 
        
        System.out.println(min); 

    } 

}