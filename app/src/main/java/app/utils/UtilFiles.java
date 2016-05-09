package app.utils;

import org.primefaces.model.UploadedFile;

public class UtilFiles {

    public static byte[] transformFile(UploadedFile file){

        return file.getContents();

    }

}
