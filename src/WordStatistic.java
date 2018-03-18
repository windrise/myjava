import com.sun.javafx.image.IntPixelGetter;

import java.sql.Statement;
import java.util.*;
import java.util.Map;
import java.io.*;
import java.util.Map.Entry;

public class WordStatistic {
//要求 输入为  “1.txt x.txt”
    public static void main(String [] args){
    String input=null;
    String [] in = null;
    Scanner scan = new Scanner(System.in);
    input=scan.nextLine();
    in=input.split(" ");

    File fileparent = new File("E:\\javaworkspace\\myjava\\data");



    }

}
class Statis{
    private static Map<String,Integer> Wordstatis = new HashMap<String,Integer>();
    private static Map<Character,Integer> Charstatis = new HashMap<Character, Integer>();
    private static Set<String> wordset = Wordstatis.keySet();
    static Set<Character> st = Charstatis.keySet();
    static void  Word(String word){
        if(wordset.contains(word)) {
            Statis.Wordstatis.put(word, Statis.Wordstatis.get(word) + 1);
        }else{
            Statis.Wordstatis.put(word,  1);
        }

    }

    static void Character(Character character){
       if(st.contains(character))
       {
           Statis.Charstatis.put(character,Statis.Charstatis.get(character)+1);
       }
       else
       {
           Statis.Charstatis.put(character,1);
       }
    }

    static void Output(String filename){
        Set<Entry<String,Integer>> wentrySet=Statis.Wordstatis.entrySet();
        Set<Entry<Character,Integer>> centrySet=Statis.Charstatis.entrySet();
        for(Entry<String,Integer> entry:wentrySet){


        }

    }

}