package com.kapelle.procheck.Storage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.Part;

public class StorageService {
	String saveAsLocation = "";
	String filename = "";
public StorageService(Part filePart, String imgPath, String fileName){
			//String fileName = filePart.getSubmittedFileName();
			OutputStream out = null;
            InputStream filecontent = null;
            
            try {
                out = new FileOutputStream(new File(imgPath + File.separator + fileName + ".jpg"));
                filecontent = filePart.getInputStream();
                
                int read = 0;
                final byte[] bytes = new byte[1024];
                
                while ((read = filecontent.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                System.out.println("New file " + fileName + " created at " + imgPath);
                System.out.println("File{0} being uploaded to {1} "+ new Object[]{fileName, imgPath});
                
            }
            catch (IOException fne) {
				System.out.println("You either did not specify a file to upload or are "
                        + "trying to upload a file to a protected or nonexistent "
                        + "location.");
						System.out.println("ERROR: " + fne.getMessage());
                
				System.out.println( "Problems during file upload. Error: {0}"+ new Object[]{ fne.getMessage() });
            }
            finally {
                if (out != null) {
                    try {
						out.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
                if (filecontent != null) {
                    try {
						filecontent.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
            }
			saveAsLocation = imgPath + File.separator;
			filename = fileName;
    }

/* 
    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        //LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
*/
}
