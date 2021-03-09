import java.lang.reflect.Array;
import java.util.*;

public class test
{
    public static void main(String[] args) {
        Map<Integer,Integer> random = new HashMap();
        ArrayList<Integer> list= new ArrayList<>();
        for (int i = 0;i<50;i++){
            list.add(i);
        }
        int i = 0;
        while(random.size()<5){
            Random r = new Random();
            System.out.println(r);
            random.put(i,r.nextInt(list.size()));
            i++;
        }
        for (Map.Entry<Integer,Integer> entry:random.entrySet()){
            System.out.println(list.get(entry.getValue()));
        }

    }
}
