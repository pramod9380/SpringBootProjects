import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Student{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
public class Main {
    public static void main(String[] args) {

        int [] arr = new int[100];
        List<Integer> list = new ArrayList<>();
        IntStream.range(0,100).forEach(i-> {
            list.add(i);
        });
//        System.out.println(list);

//        List<Integer> newList  = list.stream().map(i->i*i).collect(Collectors.toList());
//        newList.stream().forEach(i-> System.out.println(i));

//        List<Integer> evenList = list.stream().filter(i->i%2==0).collect(Collectors.toList());
//        evenList.stream().forEach(i-> System.out.println(i));
//
//        System.out.println("paralell started");
//        evenList.parallelStream().forEach(i-> System.out.println(i));
//
//        int count = (int) evenList.stream().count();
//        System.out.println("no .of elements in list"+count);

//        Map<Integer,String> map = new HashMap<>();
//        map.put(1, "101");
//        map.put(2,"102");
//
//        map.entrySet().stream().forEach(i-> System.out.println(i.getKey()+" "+i.getValue()));


//        System.out.println("Before adding");
//        for(int i=0;i<arr.length;i++){
//            System.out.println(arr[i]);
//        }

//        for(int i=0;i<arr.length;i++){
//               arr[i] = i;
//        }

//        System.out.println("after adding");
//        for(int i=0;i<arr.length;i++){
//            System.out.println(arr[i]);
//        }

//        for( int a : arr){
//            System.out.println(a);
//        }
//
//        int count = 0;
//        while(count<arr.length){
//            System.out.println(arr[count]);
//            count++;
//        }

//        Arrays.stream(arr).forEach(System.out::println);


        Scanner in = new Scanner(System.in);
//        System.out.println("Enter no of students");
//        int num = in.nextInt();

        List<Student> students = new ArrayList<>();

//        for(int i=0; i<num;i++){
//            System.out.println("Enter name");
//            String name = in.next();
//            Student student = new Student();
//            student.setName(name);
//            students.add(student);
//        }

        while (true){
            System.out.println("Enter name");
            String name = in.next();
            Student student = new Student();
            student.setName(name);
            students.add(student);            System.out.println("Do ypu want add another student details\n1.yes\n2.no");
            int option = in.nextInt();
            if(option==1)
                continue;
            else
                break;
        }

        students.stream().forEach(i-> System.out.println(i.getName()));
    }
}