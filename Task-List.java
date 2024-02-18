import java.util.Scanner;
import java.util.ArrayList;

public class TaskList {
    public static void main(String[] args) {
        boolean status = true;
        ArrayList<String> tasks = new ArrayList<String>();
        ArrayList<String> check = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);

        while (status) {
            System.out.println("\n Options \n");
            System.out.println("1. Display To-Do List\n");
            System.out.println("2. Add a Task\n");
            System.out.println("3. Mark a Task as Completed\n");
            System.out.println("4. Remove a Task\n");
            System.out.println("5. Quit\n");
            System.out.print("enter your input\n");
            int select = scanner.nextInt();

            if (select == 5) {
                status = false;
                System.out.println("thank you");
            } else if (select == 1) {
                if (tasks.size() == 0) {
                    System.out.println("TODO List is empty\n");
                } else {
                    System.out.println("SR_NO " + "> Task" + "> Status");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println(i + 1 + "> " + tasks.get(i) + "> " + check.get(i));
                    }
                }
            } else if (select == 2) {
                System.out.print("Add New task\n");
                String content = scanner.next();
                tasks.add(content);
                check.add("Not Done");
            } else if (select == 3) {
                System.out.print("Enter SR no of task you want mark as done\n");
                int selection = scanner.nextInt();
                if (selection <= tasks.size() && selection != 0) {
                    check.set(selection - 1, "done");
                }
            } else if (select == 4) {
                System.out.print("Enter SR no of task you want to remove\n");
                int remove = scanner.nextInt();
                if (tasks.size() == 0) {
                    System.out.println("TODO List is empty\n");
                } else {
                    tasks.remove(tasks.get(remove - 1));
                }
            }
        }
        scanner.close();
    }
}
