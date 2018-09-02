package com.getinfo.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.MultipartFile;

import com.mchange.util.Base64Encoder;
public class ImageUploadUtils {

    public static String getImage(MultipartFile upload)
    {
        File file = convertToFile(upload);
        String imageDataString = null;
        try 
        {
            BufferedImage img = ImageIO.read(file);
            imageDataString = encodeToString(img, "PNG");
            System.out.println("Image Successfully Manipulated!");
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("Image not found" + e);
        } 
        catch (IOException ioe) 
        {
            System.out.println("Exception while reading the Image " + ioe);
        }
        return imageDataString;
    }

    public static String encodeToString(BufferedImage image, String type)
    {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();
         //  Base64Encoder encoder = new Base64Encoder();
            imageString=Base64.getEncoder().encodeToString(imageBytes);
          //  imageString = encoder.encode(imageBytes);

            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }

    /**
     * Convert multipartFile to file
     * 
     * @param file
     * @return File
     */
    public static File convertToFile(MultipartFile file) 
    {
        File convFile = new File(file.getOriginalFilename());
        try {
            convFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close();
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        return convFile;
    }
}
