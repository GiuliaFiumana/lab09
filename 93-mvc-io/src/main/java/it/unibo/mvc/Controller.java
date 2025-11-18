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
     * @return
     */
    String getNextStringToPrint();

    /**
     * method to get the history og the printed strings.
     * 
     * @return
     */
    List<String> getHistoryOfPrintedStrings();
    
    /**
     * method to print the current string.
     * 
     */
    void printCurrentString();

}