package app.utils;

import org.primefaces.model.UploadedFile;
import org.primefaces.util.Base64;

public class UtilFiles {

    public static byte[] transformFile(UploadedFile file){

        return file.getContents();

    }

    public static String transformFileToBase64(byte[] file){

        return Base64.encodeToString(file,false);

    }

}
