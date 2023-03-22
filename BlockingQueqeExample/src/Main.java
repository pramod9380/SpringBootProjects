import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {



        List<Integer> list = new ArrayList<>();
        BlockingQueue<Integer> queue =  new LinkedBlockingQueue<>();
        IntStream.range(0,200).forEach(value-> list.add(value));

//        System.out.println("List : "+list);

//        list.stream().forEach(value-> {
//            try {
//                queue.put(value);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });


        for(int i=0;i< list.size();i++){
            try {
                queue.add(i);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

//        for(int i=0;i< queue.size();i++){
//            System.out.println(queue.poll());
//        }

        System.out.println("Hello World : "+ queue.size());
        queue.stream().forEach(value-> System.out.println(value));
    }
}