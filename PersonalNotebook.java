import java.io.*;
import java.util.*;


public class PersonalNotebook {
    private static final String NOTES_FILE = "notes.ser";
    private static Map<String, Note> notes = new HashMap<>();

    public static void main(String[] args) {
        loadNotes();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    addNote();
                    break;
                case "2":
                    viewNotes();
                    break;
                case "3":
                    deleteNote();
                    break;
                case "4":
                    exportNote();
                    break;
                case "5":
                    saveNotes();
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showMenu() {

    }

    private static void viewNotes() {

    }

    private static void deleteNote() {

    }

    private static void exportNote() {

    }

    private static void loadNotes() {

    }
}

private static void saveNotes() {

}
}