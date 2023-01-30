package domcie.config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class addlocation {
    public static final String newLine = System.getProperty("line.separator");

    public static void addloc(File loc, String string)  {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileOutputStream(loc, true));
            printWriter.write(newLine + string);
        } catch (IOException ioex) {
            ioex.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.flush();
                printWriter.close();
            }
        }
    }
}
