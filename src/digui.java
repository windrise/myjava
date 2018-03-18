public class digui {
    void nCr(int n,int r){
        if(n < r){

            return;
        }

        if(n == 0){
            System.out.println("");
            return;
        }

        nCr(n-1,r-1);
        nCr(n-1,r);

    }
    public static void main(String[] args){
        new digui().nCr(3,1);
    }


}
