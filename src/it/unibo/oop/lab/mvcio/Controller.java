package it.unibo.oop.lab.mvcio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 */
public class Controller {
    private File currentFile;

    /*
     * This class must implement a simple controller responsible of I/O access. It
     * considers a single file at a time, and it is able to serialize objects in it.
     * 
     * Implement this class with:
     * 
     * 1) A method for setting a File as current file
     * 
     * 2) A method for getting the current File
     * 
     * 3) A method for getting the path (in form of String) of the current File
     * 
     * 4) A method that gets a String as input and saves its content on the current
     * file. This method may throw an IOException.
     * 
     * 5) By default, the current file is "output.txt" inside the user home folder.
     * A String representing the local user home folder can be accessed using
     * System.getProperty("user.home"). The separator symbol (/ on *nix, \ on
     * Windows) can be obtained as String through the method
     * System.getProperty("file.separator"). The combined use of those methods leads
     * to a software that runs correctly on every platform.
     */

    public Controller() {
        this.currentFile = new File(System.getProperty("user.home") 
                + System.getProperty("file.separator") + "output.txt"); 
    }

    /**
     * A method for setting a File as current file.
     * 
     * @param file to set as current file
     */
    public void setFile(final File file) {
        this.currentFile = file;
    }

    /**
     * 
     * @return the current file
     */
    public File getFile() {
        return this.currentFile;
    }

    /**
     * 
     * @return the path of the current associated file.
     */
    public String getFilePath() {
        return this.currentFile.getPath();
    }

    /**
     * Saves on the current file the content of the passed string.
     * 
     * @param input a string to save on the current file.
     * @throws IOException
     */
    public void saveToFile(final String input) {
        try (FileWriter writer = new FileWriter(currentFile)) {
            writer.write(input);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
