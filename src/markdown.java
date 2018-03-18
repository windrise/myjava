import java.util.*;
public class markdown {
    String titleLevel[]={"<p>","<h1>","<h2>","<h3>","<h4>","<h5>","<h6>"};
    String titleLevel2[] ={"</p>","</h1>","</h2>","</h3>","</h4>","</h5>","</h6>"};
    public static void main(String[] args){

        new markdown().run();
    }
    public void run(){
        Scanner scan = new Scanner(System.in);
        String line="";
        String content="";


        while(scan.hasNextLine()){
            line = scan.nextLine();
            if(line.contains("#"))
            {
                int Level=sumLevel(line);
                content = getString(line);
                //处理强调和超链接
                content=Tackle(content);
                System.out.println(titleLevel[Level]+content+titleLevel2[Level]);

            }else if(line.contains("*"))
            {
                //处理强调和超链接
                System.out.println("<ul>");
                line=getList(line);
                line=Tackle(line);
                System.out.println(line);
                line=scan.nextLine();
                if(line.equals("")){
                    System.out.print("</ul>");
                }else {
                    while(scan.hasNextLine())
                    {
                        line=getList(line);
                        line=Tackle(line);
                        System.out.println(line);
                        line=scan.nextLine();
                        if(line.equals(""))
                        {
                            System.out.println("</ul>");
//                            System.out.println();
                            break;
                        }
                    }
                }

            }else if(line.equals("")){
                continue;
            }else{
                //处理强调和超链接
                line=Tackle(line);
                System.out.print(titleLevel[0]+line);
                line = scan.nextLine();
                if(line.equals(""))
                {
                    System.out.println(titleLevel2[0]);
//                    System.out.println();
                }
                else{
                    System.out.println();
                    while(scan.hasNextLine())
                    {
                        //处理强调和超链接
                        line=Tackle(line);
                        System.out.print(line);
                        line = scan.nextLine();
                        if(!line.equals(""))
                        {
                            continue;
                        }
                        else
                        {
                            System.out.println(titleLevel2[0]);
                            break;
                        }
                    }
                    if(!scan.hasNextLine())
                    {
                        line=Tackle(line);
                        System.out.print(line);
                        System.out.println(titleLevel2[0]);
                    }
                }

            }

        }

    }
    public String getList(String s){
        String line=s;
        line=line.replaceAll(" ","");
        line=line.replaceAll("\n","");
        line = line.replaceAll("[*]","<li>")+"</li>";
        return line;
    }


    public int sumLevel(String s){
        int num=0;
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)=='#')
                num++;
        return num;
    }

    public String getString(String s) {
        String str=s.replaceAll(" ","");
        int i=0;
        for(;i<str.length();i++)
        {
            if(str.charAt(i) != '#')
                break;
        }
        str = str.substring(i,str.length());
        return str;
    }

    public String Tackle(String s){
        String str = s;
        if(s.contains("_"))
            str=Qiang(str);
        if(s.contains("[") && s.contains("]"))
            str=Link(str);

        return str;
    }

    public String Qiang(String s) {
        int idx=0;
        String str=s;
        boolean pair=false;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '_')
            {
                if(!pair)
                {
                    str=str.replaceFirst("_","<em>");
                    pair=!pair;
                }else{
                    str=str.replaceFirst("_","</em>");
                    pair=!pair;
                }
            }
        }
        return str;
    }

    public String Link(String s){
        String str="";
        int f=0;
        int c=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '[')
                str=s.substring(0,i)+getLink(s,i);
            if(s.charAt(i) == ')')
                str=str+s.substring(i+1,s.length());
        }
        str=str.replace("[","");
        str=str.replace("]","");
        str=str.replace("(","");
        str=str.replace(")","");
        return str;
    }

    public String getLink(String s,int index)
    {
        String LinkName="";
        String LinkUrl="";
        String str="";
        int f=0;
        int c=0;
        for(int i=index;i<s.length();i++)
        {
            if(s.charAt(i)=='[') f=i;
            if(s.charAt(i)==']')
            {
                LinkName=s.substring(f,i+1);
            }
            if(s.charAt(i)=='(') c=i;
            if(s.charAt(i)==')')
            {
                LinkUrl=s.substring(c,i+1);
                str="<a href=\"" + LinkUrl+"\">"+LinkName+"</a>";
            }

        }
        return str;

    }


}
