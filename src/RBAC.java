import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class RBAC {
    public static void main(String[] args){
        int p,num_temp;
        String str;
        Scanner sc = new Scanner(System.in);
        p = sc.nextInt();
        for(int i=0;i<p;i++){
            str = sc.next();
        }
        p = sc.nextInt();
        Role2[] roles = new Role2[p];
        for(int i=0;i<p;i++)
        {
            Role2 role = new Role2(sc.next());
            num_temp = sc.nextInt();
            Map<String,Integer> privileges = role.privileges;
            for(int j=0;j<num_temp;j++)
            {
                str = sc.next();
                String[] pItem = str.split(":");
                Integer topLevel = null;
                if(pItem.length == 2){
                    topLevel=Integer.parseInt(pItem[1]);
                    Integer level = privileges.get(pItem[0]);
                    if(level != null){
                        topLevel = level > topLevel ? level:topLevel;
                    }
                }
                privileges.put(pItem[0],topLevel);
            }
            role.setPris(privileges);
            roles[i]=role;

        }
        //输入用户描述
        p = sc.nextInt();
        User2[] users=new User2[p];
        for(int i =0;i<p;i++)
        {
            User2  user = new User2(sc.next());
            Map<String,Integer> privileges=user.privileges;
            num_temp = sc.nextInt();
            for(int j=0;j<num_temp;j++)
            {
                String rolename = sc.next();
                int k=0;
                int len = roles.length;
                while(k<len){
                    if(rolename.equals(roles[k].name)){
                        break;
                    }
                    k++;
                }

                if(k!=len){
                    Map<String,Integer> privilegesRole = roles[k].privileges;
                    Set<Entry<String, Integer>> entrySet=privilegesRole.entrySet();
                    for(Entry<String,Integer> entry:entrySet){
                        String key=entry.getKey();
                        Integer topLevel = entry.getValue();
                        Integer level = privileges.get(key);
                        if(level !=null){
                            topLevel = level > topLevel ? level:topLevel;
                        }
                        privileges.put(key,topLevel);
                    }
                }
            }
            user.setPris(privileges);
            users[i]=user;

        }

        //对输入的用户权限进行检查
        p = sc.nextInt();
        String[] results = new String[p];
        for(int i=0;i<p;i++)
        {
            String username = sc.next();
            str = sc.next();
            String flag = "false";
            for(User2 user : users){
                if(username.equals(user.name)){
                    Map<String, Integer> authorities = user.privileges;
                    String[] auth = str.split(":");
                    Set<Entry<String,Integer>> entrySet= authorities.entrySet();
                    for(Entry<String,Integer> entry:entrySet){

                        if(auth[0].equals(entry.getKey())){
                            flag="true";
                            Integer ownLevel = entry.getValue();
                            if(auth.length ==2){
                                int level = Integer.parseInt(auth[1]);
                                if(ownLevel != null && level <= ownLevel)
                                {
                                    flag="true";
                                }else {
                                    flag = "false";
                                }
                            }else{
                                if(ownLevel != null){
                                    flag=ownLevel.toString();
                                }
                            }
                        }
                    }
                }

            }
            results[i]=flag;

        }
        sc.close();
        for(String result:results){
            System.out.println(result);
        }

    }


}
class Privilege2{
    String name;
    Map<String,Integer> privileges=new HashMap<String, Integer>();

    public void setPris(Map<String,Integer> privileges){
        this.privileges=privileges;
    }
}

class User2 extends Privilege2{
    public User2(String name){
        this.name = name;
    }
}

class Role2 extends Privilege2{
    public  Role2(String name){
        this.name = name;
    }
}