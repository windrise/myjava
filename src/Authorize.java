
import java.util.*;
class Privilege{
    String name="";
    String level="";
    Privilege(String n,String l){
        this.name=n; this.level=l;
    }
    String getLevel(String n){
        return this.level;
    }

}
class Role{
    String RoleName="";
    int Pnum=0;
    Map privilegemap=new HashMap();
    Role(String name,int num,Map pmap){
        this.RoleName=name;this.Pnum=num;this.privilegemap=pmap;
    }

}
class Use{
    String UseName="";
    int Rnum=0;
    String[] UseRole;
    Use(String useName,int rnum,String[] useRole){
        this.UseName=useName;this.Rnum=rnum;this.UseRole=useRole;
    }

}

public class Authorize {
    public static void main(String[] args){
        new Authorize().run();
    }

    Privilege[] AllP =null;

    Role[] AllR=null;

    Use[] AllU=null;
    public void run(){
        Scanner scanner=new Scanner(System.in);
        String line="";
        String[] Privi=null;
        int PrivilegeNum=scanner.nextInt();

        //读入权限
        for (int i = 0; i < PrivilegeNum; i++) {
            line=scanner.nextLine();
            Privi = line.split(":");
            AllP[i] = new Privilege(Privi[0],Privi[1]);
        }
        //读入角色
        int RoleNum=scanner.nextInt();

        Map Rolemap=new HashMap();
        String[] information=null;
        for (int i = 0; i < RoleNum; i++) {
            line=scanner.nextLine();
            information=line.split(" ");
            int num=0;
            num=Integer.valueOf(information[1]);
            for (int i1 = 2; i1 < 2+num; i1++) {
                if(information[i].contains(":"))
                {
                    Rolemap.put(information[i1].split(":")[0],information[i1].split(":")[1]);
                }else{
                    Rolemap.put(information[i1],null);
                }
            }
            AllR[i] = new Role(information[0],num, Rolemap);
            
        }
        //读入用户

        String[] UseRoleString=null;
        int UseNum=scanner.nextInt();
        for (int i = 0; i < UseNum; i++) {
            line=scanner.nextLine();
            information=line.split(" ");
            int num=0,n=0;
            num=Integer.valueOf(information[1]);
            for (int i1 =2; i1 < 2+num; i1++) {
                UseRoleString[n++]=information[i1];
            }

            AllU[i]=new Use(information[0],num,UseRoleString);
        }
        //查询
        int searchN=scanner.nextInt();
        boolean result=false;
        for (int i = 0; i < searchN; i++) {
            line=scanner.nextLine();
            information=line.split(" ");

            if(information[1].contains(":"))
            {
                String str1=null,str2=null;
                str1=information[1].split(":")[0];
                str2=information[1].split(":")[1];


            }

        }

    }
    //判断用户的权限
    boolean IsPrivile(String[] s){
        for( Use i:AllU){

        }

        return true;
    }

}
