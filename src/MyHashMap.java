
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class MyHashMap {

    Map<String,Object>[] map = new Map[100];
    String arr[]={"OBJECT","STRING","NOTEXIST"};
    String res="";
    int round = 0;
    String key="";
    Object value=null;

    public MyHashMap(){
        for(int i=0;i < map.length;i++)
        {
            map[i] = new HashMap<String ,Object>();
        }
    }


    public void run(){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt(),m=scanner.nextInt();
        String s="";

        scanner.nextLine();//换行，当前流指在第一行
        for(int i=0;i<n;i++) s += scanner.nextLine();
        s = s.replaceAll(" ","");
        s = s.replaceAll("\n","");

        deal(s);

        //执行查询功能

        for(int i=0;i<m;i++){

            String str = scanner.nextLine();
            String[] string;
            // 按‘.’划分，不能直接使用str.split(".");，注意源码，使用正则表达式
            if(str.contains(".")){
                string = str.split("[.]");
            }else{
                string = new String[1];
                string[0] = str;

            }
            int len = string.length -1;
            if(map[len+1].containsKey(string[len])){
                Object obj = map[len+1].get(string[len]);
                if(obj instanceof String){
                    res += arr[1]+" "+obj+"\n";

                }else {
                    res += arr[0]+"\n";
                }

            }else{
                res += arr[2]+"\n";
            }

        }
        scanner.close();
        System.out.println(res);


    }
    public void deal(String s){
        for(int i=0;i<s.length();i++){
            switch (s.substring(i,i+1)){
                case "{":
                    round++;
                    break;

                case "}":
                    round--;
                    break;
                case "\"":
                    key = getString(s,i+1);
                    i += key.length()+1;
                    key = solveString(key);
                    break;
                case ":":
                    char c = s.charAt(i+1);
                    if(c == '"'){
                        value = getString(s,i+2);
                        i += ((String) value).length()+2;
                        value = solveString((String) value);
                        map[round].put(key,value);
                    }else{
                        map[round].put(key,map[round+1]);
                    }
                default:
                    break;

            }
        }

    }

    public String  getString(String s,int index){
        for(int i=index;i<s.length();i++){
            if(s.charAt(i) == '\\'){
                i++;
                continue;
            }
            if(s.charAt(i) == '"' && (s.charAt(i+1) == '}') || s.charAt(i+1) ==':'|| s.charAt(i+1) ==',' ){
                return s.substring(index,i);
            }
        }
        return "";
    }
    public String  solveString(String s){
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='\\' && (s.charAt(i+1) == '\\' || s.charAt(i+1)=='"'))
                s=splitString(0,s.length(),i,s);
        }
        return s;

    }
    public String splitString(int startIndex,int endIndex,int index,String s){
        return s.substring(startIndex,index) + s.substring(index+1,endIndex);
    }


    public static void main(String[] args){
        new MyHashMap().run();
    }
}
