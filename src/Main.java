import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        crud dao = new crud();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter grade: ");
                    String grade = sc.nextLine();
                    dao.addStudent(new Student(name, age, grade));
                    break;

                case 2:
                    List<Student> list = dao.getAllStudents();
                    for (Student s : list) {
                        System.out.println(s.getId() + " | " + s.getName() + " | " + s.getAge() + " | " + s.getGrade());
                    }
                    break;

                case 3:
                    System.out.print("Enter student ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new grade: ");
                    String newGrade = sc.nextLine();
                    dao.updateStudent(id, newName, newAge, newGrade);
                    break;

                case 4:
                    System.out.print("Enter student ID to delete: ");
                    int delId = sc.nextInt();
                    dao.deleteStudent(delId);
                    break;

                case 5:
                    System.out.println(" Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again!");
            }

        } while (choice != 5);
        sc.close();
    }
}
