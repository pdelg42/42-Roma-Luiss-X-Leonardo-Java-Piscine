import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Program {

    private static Path currentDirectory;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java FileUtility <absolute_path>");
            return;
        }

        Path startingDir = Paths.get(args[0]);
        currentDirectory = startingDir;

        try {
            displayHelp();
            while (true) {
                System.out.print("\n" + "MegaMiniShell" + "> ");
                String input = System.console().readLine();
                String[] commandArgs = input.split("\\s+");
                executeCommand(commandArgs);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void executeCommand(String[] args) throws IOException {
        if (args.length == 0) {
            displayHelp();
        } else {
            String command = args[0].toLowerCase();
            switch (command) {
                case "mv":
                    if (args.length == 3) {
                        moveFile(args[1], args[2]);
                    } else {
                        System.out.println("Invalid usage. Syntax: mv WHAT WHERE");
                    }
                    break;
                case "ls":
                    listContents();
                    break;
                case "cd":
                    if (args.length == 2) {
                        changeDirectory(args[1]);
                    } else {
                        System.out.println("Invalid usage. Syntax: cd FOLDER_NAME");
                    }
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Unknown command. Type 'help' for available commands.");
            }
        }
    }

    private static void displayHelp() {
        System.out.println("Welcome to MegaMiniShell!");
        System.out.println("Available commands:");
        System.out.println("mv WHAT WHERE    Move or rename a file.");
        System.out.println("ls               List folder contents.");
        System.out.println("cd FOLDER_NAME   Change the current directory.");
        System.out.println("exit             Exit the program.");
    }

    private static void moveFile(String what, String where) throws IOException {
        Path source = currentDirectory.resolve(what);
        Path target = currentDirectory.resolve(where);

        if (Files.exists(source)) {
            if (!Files.isDirectory(target)) {
                Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("File moved/renamed successfully.");
            } else {
                System.out.println("Cannot move a file inside a directory. Specify a new file name in WHERE.");
            }
        } else {
            System.out.println("File not found.");
        }
    }

    private static void listContents() throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(currentDirectory)) {
            for (Path file : stream) {
                String fileName = file.getFileName().toString();
                if (Files.isDirectory(file)) {
                    System.out.println(fileName + " [DIR]");
                } else {
                    long fileSizeKB = Files.size(file) / 1024;
                    System.out.println(fileName + " - " + fileSizeKB + " KB");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void changeDirectory(String folderName) {
        Path newDir = currentDirectory.resolve(folderName);
        if (Files.isDirectory(newDir)) {
            currentDirectory = newDir;
        } else {
            System.out.println("Directory not found.");
        }
    }
}
