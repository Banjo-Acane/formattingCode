import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Exercise> exercises;
        String fileName = "test1.txt";
        exercises = read(fileName);
        Scanner scanner = new Scanner(System.in);
        if(scanner.next().equals("y"))
        write(exercises);
    }
    public static ArrayList<Exercise> read(String fileName) throws IOException {
        ArrayList<Exercise> exercises = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String str;
        int i = 1;
        while((str = br.readLine())!=null) {
            if (str.length() > 1) {
                //题目开头
                if (str.substring(0, 2).equals(i+" ")) {
                    Exercise e = new Exercise();
                    System.out.println(str.substring(2));
                    //ID 从第几位开始
                    e.setID(76+i);
                    e.setQuestion(str.substring(2));
                    exercises.add(e);
                    i++;
                    //答案开头
                } else if (str.substring(0, 2).equals("1）")||str.substring(0, 2).equals("1．")
                ||str.substring(0, 2).equals("1、")) {
                    int mark[] = new int[5];
                    for (int j = 0; j < str.length(); j++) {
                        String c = str.substring(j, j + 1);
                        if (c.equals("2")) {
                            exercises.get(i - 2).setChoice1(str.substring(2, j-1));
                            mark[0] = j;
                        } else if (c.equals("3")) {
                            exercises.get(i - 2).setChoice2(str.substring(mark[0] + 2, j-1));
                            mark[1] = j;
                        } else if (c.equals("4")) {
                            exercises.get(i - 2).setChoice3(str.substring(mark[1] + 2, j-1));
                            exercises.get(i - 2).setChoice4(str.substring(j + 2));
                        }
                    }
                } else if (str.substring(0, 2).equals("答案")) {
                    exercises.get(i - 2).setAnswer(Integer.parseInt(str.substring(3)));
                }
            }
        }
        br.close();
        return exercises;
    };
    public static void write(ArrayList<Exercise> exercises) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt",true));
        for (Exercise e:exercises){
            bw.write(e.getID()+","+e.getQuestion()+","+e.getChoice1()+","+e.getChoice2()+","+e.getChoice3()+","+e.getChoice4()+","+e.getAnswer()+"\n");
        }
        bw.close();
    }
}
