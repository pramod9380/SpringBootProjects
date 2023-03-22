import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;


class Processor implements Runnable{
    List<Integer> subList;
    int count;
    public Processor(List<Integer> list,int count){
//        System.out.println("List: "+list);
        this.subList=list;
        this.count=count;
    }

    @Override
    public void run() {
//        System.out.println("subList:"+subList);
//        subList.stream().forEach(System.out::println);
        for (int val: subList){
            System.out.println(" Thread "+count+", executed "+val);
        }
    }
}
public class ThreadsExample {

    static Logger logger = LoggerFactory.getLogger(ThreadsExample.class);

    private static  final int NUMBER_OF_THREADS=4;
    private static final int NUMBER_OF_ITEMS=14;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Integer> items = new ArrayList<>();
        IntStream.range(0,14).forEach(item->items.add(item));

        ExecutorService exec = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        int minItemsPerThread = NUMBER_OF_ITEMS / NUMBER_OF_THREADS;
        int maxItemsPerThread = minItemsPerThread + 1;
        int threadsWithMaxItems = NUMBER_OF_ITEMS - NUMBER_OF_THREADS * minItemsPerThread;

        int start = 0;
        int count=0;

        List<Future<?>> futures = new ArrayList<Future<?>>(NUMBER_OF_ITEMS);
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            int itemsCount = (i < threadsWithMaxItems ? maxItemsPerThread : minItemsPerThread);
            int end = start + itemsCount;
            Runnable r = new Processor(items.subList(start, end),count++);
            futures.add(exec.submit(r));
            start = end;
        }
        for (Future<?> f : futures) {
            f.get();
        }
        logger.warn("all items processed");
    }
}
