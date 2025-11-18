package it.unibo.mvc;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * an implementation of the interface Controller.
 *
 */

public final class SimpleController implements Controller {

    private final List<String> printedStrings = new LinkedList<>();
    private String nextToPrint;

    @Override
    public void setNextStringToPrint(final String stringa) {
        this.nextToPrint = Objects.requireNonNull(stringa, "La stringa data è nulla");
    }

    @Override
    public String getNextStringToPrint() {
        return this.nextToPrint;
    }

    @Override
    public List<String> getHistoryOfPrintedStrings() {
        return Collections.unmodifiableList(this.printedStrings);
    }

    @Override
    public void printCurrentString() {
        if (this.nextToPrint == null) {
            throw new IllegalStateException("The current string is unset");
        }
        System.out.println(this.nextToPrint); // NOPMD: allowed in exercises
        this.printedStrings.add(this.nextToPrint);
    }
}
