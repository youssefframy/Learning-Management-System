package FCIHCaseStudy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tamer A.Yassen
 */
public class FileMangerBinary implements Serializable {

    public boolean write(String FilePath, Object data) {

        try {
            System.out.print("\nwritting in ! " + FilePath);

            ObjectOutputStream writter = new ObjectOutputStream(new FileOutputStream(FilePath));

            writter.writeObject(data);

            System.out.println(" ... Done ! ");
            writter.close();
            return true;

        } catch (IOException e) {
            System.out.println("Can't write ...!\n" + e);
        }

        return false;
    }

    public Object read(String FilePath) {

        Object Result = null;

        try {
            System.out.println("Reading ! From " + FilePath);

            ObjectInputStream Reader = new ObjectInputStream(new FileInputStream(FilePath));

            Result = Reader.readObject();

        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileMangerBinary.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Result;

    }

}
