package it.unibo.oop.lab.mvc;

import java.util.List;

/**
 * A controller that prints strings and has memory of the strings it printed.
 */
public interface Controller {

    /*
     * This interface must model a simple controller responsible of I/O access. It
     * considers only the standard output, and it is able to print on it.
     * 
     * Write the interface and implement it in a class in such a way that it
     * includes:
     * 
     * 1) A method for setting the next string to print. Null values are not
     * acceptable, and an exception should be produced
     * 
     * 2) A method for getting the next string to print
     * 
     * 3) A method for getting the history of the printed strings (in form of a List
     * of Strings)
     * 
     * 4) A method that prints the current string. If the current string is unset,
     * an IllegalStateException should be thrown
     * 
     */

    /**
     * Sets the next string to print.
     * <p>
     * <b>Throws:</b><br>
     *      <b>IllegalArgumentException:</b> if a null value or empty string is passed
     *
     * @param str the string to print next
     * @throws IllegalArgumentException if null values are passed as argument
     */
    void setNextString(String str);

    /**
     * 
     * @return the next string to print
     */
    String getNextString();

    /**
     * 
     * @return a list representing the history of the printed strings
     */
    List<String> getStringHistory();

    /**
     * Prints the current string.
     * <p>
     * <b>Throws:</b><br>
     *      <b>IllegalStateException:</b> if the current string is unset
     * 
     * @throws IllegalStateException if the next string to print is unset
     */
    void printString();

}
