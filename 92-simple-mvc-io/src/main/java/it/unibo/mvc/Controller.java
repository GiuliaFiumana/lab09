package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    public final static String PATH = System.getProperty("user.home")
    + System.getProperty("file.separator")
    + "outpt.txt";
    private File currentFile = new File(PATH);

    public void setAsCurrentFile(final File file) {
        if(file == null) {
            throw new IllegalArgumentException("Errore");
        }
        this.currentFile = file;
    }

    public File getCurrentFile() {
        return this.currentFile;
    }

    public String getPath() {
        return this.currentFile.getAbsolutePath();
    }

    public void saveString(final String s) throws IOException {
        try (PrintStream out = new PrintStream(currentFile, StandardCharsets.UTF_8)) {
            out.println(s);
        }
    }
}
