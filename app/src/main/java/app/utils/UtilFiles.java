package app.utils;

import org.primefaces.model.UploadedFile;
import org.primefaces.util.Base64;

import java.io.File;
import java.util.Random;

public class UtilFiles {

    private final static String PATH = "/Users/guillermo/apache-tomcat-8.0.33/webapps/ROOT/resources/files";

    private final static String FILE_ROUTE = "/resources/files/";

    public static byte[] transformFile(UploadedFile file){

        return file.getContents();

    }

    public static String transformFileToBase64(byte[] file){

        return Base64.encodeToString(file,false);

    }

    public static String getPath(){

        return PATH;

    }

    public static String getFileRoute(File file) {

        return FILE_ROUTE+file.getName();
    }

    public static String getRandomName(){

        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        StringBuilder randomName = new StringBuilder();

        Random random = new Random();

        for (int i = 0; i < 32; i++) {

            char c = chars[random.nextInt(chars.length)];

            randomName.append(c);
        }

        return randomName.toString();
    }

    public static String getTypeFile(UploadedFile uploadedFile) {

        String originalName = uploadedFile.getFileName();

        int index = originalName.indexOf(".");

        String typeFile = originalName.substring(index);

        return typeFile;
    }
}
