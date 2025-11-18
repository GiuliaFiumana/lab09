package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public final class Controller {
    public static final String PATH = System.getProperty("user.home")
    + System.getProperty("file.separator")
    + "outpt.txt";
    private File currentFile = new File(PATH);

    /**
     * Returns the current file.
     *
     * @return the current file
     */
    public File getCurrentFile() {
        return this.currentFile;
    }

    /**
     * Returns the current file path.
     *
     * @return the current file path
     */
    public String getCurrentFilePath() {
        return this.currentFile.getAbsolutePath();
    }

    /**
     * Saves some text on the designed file.
     *
     * @param text
     *            the text to save
     * @throws IOException
     *             if the writing fails
     */
    public void saveString(final String text) throws IOException {
        try (PrintStream out = new PrintStream(currentFile, StandardCharsets.UTF_8)) {
            out.println(text);
        }
    }

    /**
     * Sets a new destination file.
     *
     * @param file
     *            the file where to write
     */
    public void setDestination(final File file) {
        final File parent = file.getParentFile();
        if (parent.exists()) {
            currentFile = file;
        } else {
            throw new IllegalArgumentException("Cannot save in a non-existing folder.");
        }
    }

    /**
     * Sets a new destination file.
     *
     * @param file
     *            the file where to write
     */
    public void setDestination(final String file) {
        setDestination(new File(file));
    }
}
