import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;

public class fileread {
    public static void main(String [] args){
        String myFile="E:\\javaworkspace\\myjava\\data\\2.txt";
        //File myFile = new File("E:\\javaworkspace\\myjava\\data\\2.txt");
        readFileByLines(myFile);
    }
    //1、随机读取文件内容
    public static void readFileByRandomAccess(String fileName){
        RandomAccessFile randomFile = null;
        try{
            System.out.println("随机读取一段文件内容：\n");
            randomFile = new RandomAccessFile(fileName ,"r");
            long fileLength = randomFile.length();
            int beginIndex = (fileLength> 4)  ? 0:0;
            randomFile.seek(beginIndex);
            byte[] bytes = new byte [10];
            int byteread =0;
            while ((byteread = randomFile.read(bytes)) != -1){

                System.out.write(bytes,0,byteread);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if(randomFile !=null){
                try{
                    randomFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public static void readFileByLines(String fileName){
        File file = new File(fileName);
        BufferedReader reader = null;
        try{
            System.out.println("以行为单位读取文件内容，一次读一整行\n");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            while((tempString = reader.readLine()) != null){
                //显示行号
                System.out.println("line "+line+":" + tempString+"\n");
                line++;
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(reader != null){
                try{
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }


}
