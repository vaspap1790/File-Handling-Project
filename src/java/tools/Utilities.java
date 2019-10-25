
package tools;

import java.io.File;
import java.io.IOException;


public class Utilities {
    
    public static void checkPath(String path) throws IOException {

       File directory = new File(path);
       if (!directory.exists()) {
           directory.mkdir();
       }
   }
    
}
