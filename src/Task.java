import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// all the datatypes are listed down
class Task {
    private String description;
    private boolean isCompleted;

    
    // Constructor
    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }
    
    // Getters and setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return (isCompleted ? "[Completed] " : "[Pending] ") + description;
    }}

// ToDoList class manages all tasks 
class ToDoList {
    private List<Task> tasks;

    // Constructor
    public ToDoList() {
        tasks = new ArrayList<>();
    }

    // Add a task to the to-do list
    public void addTask(String description) {
        tasks.add(new Task(description));
    }

    // Remove a task from the to-do list
    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    // Mark a task as completed
    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsCompleted();
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    // Displaying task
    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
}

// main class
 class ToDoListApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoList toDoList = new ToDoList();
        int choice;

        do {

            
            System.out.println("\n--- To-Do List ---");
            System.out.println("1. Add a task");
            System.out.println("2. Remove a task");
            System.out.println("3. Mark a task as completed");
            System.out.println("4. View all tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1: // Add task
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    toDoList.addTask(description);
                    System.out.println("Task added successfully.");
                    break;
                case 2: // Remove task
                    System.out.print("Enter task number to remove: ");
                    int removeIndex = scanner.nextInt() - 1;
                    toDoList.removeTask(removeIndex);
                    break;
                case 3: // Mark task as completed
                    System.out.print("Enter task number to mark as completed: ");
                    int completeIndex = scanner.nextInt() - 1;
                    toDoList.markTaskAsCompleted(completeIndex);
                    break;
                case 4: // View tasks
                    toDoList.displayTasks();
                    break;
                case 5: // Exit
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
