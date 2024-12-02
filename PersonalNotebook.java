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
        System.out.println("\n--- Personal Notebook ---");
        System.out.println("1. Add a new note");
        System.out.println("2. View all notes");
        System.out.println("3. Delete a note");
        System.out.println("4. Export a note");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addNote() {

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