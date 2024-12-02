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
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the title of the note: ");
        String title = scanner.nextLine().trim();

        if (notes.containsKey(title)) {
            System.out.println("A note with this title already exists. Please choose a different title.");
            return;
        }

        System.out.println("Enter the content of the note (end with an empty line):");
        StringBuilder content = new StringBuilder();
        while (true) {
            String line = scanner.nextLine();
            if (line.trim().isEmpty()) break;
            content.append(line).append("\n");
        }

        Note newNote = new Note(title, content.toString().trim(), new Date());
        notes.put(title, newNote);
        System.out.println("Note added successfully.");
    }

    private static void viewNotes() {
        if (notes.isEmpty()) {
            System.out.println("No notes available.");
            return;
        }

        System.out.println("\n--- List of Notes ---");
        int index = 1;
        for (String title : notes.keySet()) {
            Note note = notes.get(title);
            System.out.printf("%d. %s (Created on: %s)%n", index++, title, note.getDateCreated());
        }
    }

    private static void deleteNote() {
        viewNotes();
        if (notes.isEmpty()) return;

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the title of the note to delete: ");
        String title = scanner.nextLine().trim();

        if (notes.containsKey(title)) {
            notes.remove(title);
            System.out.println("Note deleted successfully.");
        } else {
            System.out.println("No note found with the given title.");
        }
    }

    private static void exportNote() {
        viewNotes();
        if (notes.isEmpty()) return;

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the title of the note to export: ");
        String title = scanner.nextLine().trim();

        if (notes.containsKey(title)) {
            Note note = notes.get(title);
            String fileName = "exports/" + title + ".txt";
            new File("exports").mkdirs(); // Create the exports directory if not exists

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                writer.write("Title: " + note.getTitle() + "\n");
                writer.write("Date Created: " + note.getDateCreated() + "\n");
                writer.write("Content:\n" + note.getContent());
                System.out.println("Note exported successfully to " + fileName);
            } catch (IOException e) {
                System.out.println("Failed to export the note: " + e.getMessage());
            }
        } else {
            System.out.println("No note found with the given title.");
        }
    }

    private static void loadNotes() {

        }
    }

    private static void saveNotes() {

    }
}