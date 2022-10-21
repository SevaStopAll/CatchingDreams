package catchingDreams;

import java.util.Scanner;
import java.util.ArrayList;

public class EQueue_OOP_DB {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> queue = new ArrayList<>();
        int numb = sc.nextInt();
        String vObr = "Никто";
        final int uncomfortSize = 5;
        for (int i = 0; i < numb; i++) {            
            String action = sc.next();
            if (action.contains("Добавить")) {    // - добавляет и отражает нового в очереди 
                String name = sc.next();
                queue.add(name);
                System.out.println(name + " в очереди");
            } else if (action.contains("Посмотреть")) { 
                if (!queue.isEmpty()) { 
                    sc.next();
                    System.out.println(String.join(" ", queue));
                } else if (queue.isEmpty()) {
                    sc.next();
                    System.out.println("*прокатилось перекати-поле*");
                }
            } else if (action.contains("Следующий")) { // - вызов следующего 
                if (queue.isEmpty()) {
                    System.out.println("Отлично, попью чаёк!");
                } else if (!queue.isEmpty()) {
                    String first = queue.get(0);
                    System.out.println(first + " в обработке");
                    vObr = first;
                    queue.remove(0);
                }
            } else if (action.contains("Стоит")) {     // - обработка нового человека в очереди, который задумался
                sc.next();
                sc.next();
                sc.next();
                String nameT = sc.next();
                if (queue.size() < uncomfortSize) {  // - если в очереди меньше 5
                    queue.add(nameT);
                } else {                                        // - если очередь 5 и больше
                    System.out.println("Слабак!");
                }
            } else if (sc.next().contains("занимала")) {
                sc.next();
                String zakem = sc.next();
                if (queue.contains(zakem)) {
                    queue.add(queue.indexOf(zakem) + 1, action);
                    continue;
                } else if (!queue.contains(zakem) && !zakem.equals(vObr)) {
                    System.out.println(action + ", не надо тут ля-ля");
                    queue.add(action);
                    continue;
                } else if (zakem.equals(vObr)) {
                    queue.add(0, action);
                }
            }    
        } // Завершение цикла фор
        sc.close();
    } // завершение main
} // завершение класса