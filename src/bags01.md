0,1背包问题


public class bags01 {


    int w[n], v[n],W;

    int search(int idx, int S){
        if(S>W){
            return 0;
        }
        if(idx >= n){
            return 0;
        }
        if(f[idx][S] >= 0){
            
        }

        search(idx+1,S+w[idx])+v[idx];
        search(idx+1,S)
    }

    
    


//}
