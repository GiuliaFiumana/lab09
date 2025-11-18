package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    /**
     * method for setting the next string to print.
     *
     * @param stringa to print
     */
    void setNextStringToPrint(String stringa);

    /**
     * method to get the next string to print.
     *
     * @return next string to print
     */
    String getNextStringToPrint();

    /**
     * method to get the history og the printed strings.
     *
     * @return a list with all printed strings
     */
    List<String> getHistoryOfPrintedStrings();

    /**
     * method to print the current string.
     *
     */
    void printCurrentString();

}
