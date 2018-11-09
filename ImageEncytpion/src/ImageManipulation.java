
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

import org.apache.commons.codec.binary.Base64;

/**
 * @desc Image manipulation - Conversion
 * 
 * @filename ImageManipulation.java
 * @author <a href="mailto:jeeva@myjeeva.com">Jeevanandam Madanagopal</a>
 * @copyright &copy; 2010-2012 www.myjeeva.com
 */
public class ImageManipulation {

	/**
	 * @param args
	 * @return 
	 */
	public void manipulate(String sourcep,String destinationp,String operatep) {
		String source=sourcep;
		String imgDdestination=destinationp+"\\converted-DecryptedImage.jpg";
		String fileEdestination=destinationp+"\\converted-EncryptedFile.txt";
		String operate =operatep;
		
		File file = new File(source);
		
		try {
			/*
			 * Reading a Image file from file system
			 */
			RSATest rsa= new RSATest();
			
			
			/*
			 * Converting Image byte array into Base64 String 
			 */

			if(operate.equals("enc")){
				FileInputStream imageInFile = new FileInputStream(file);
				byte imageData[] = new byte[(int)file.length()];
				imageInFile.read(imageData);
			String imageDataString = encodeImage(imageData);
			byte imageStringBytes[]=imageDataString.getBytes();
			/*
			 * Converting a Base64 String into Image byte array 
			 */
			
			
			/*
			 * Write a image byte array into file system  
			 */
			
			FileOutputStream imageOutFile = new FileOutputStream("Converted.txt");
			imageOutFile.write(imageStringBytes);			
			rsa.startEncryption(fileEdestination);
			
			
			imageInFile.close();
			
			
			
			}
			
			
			else if(operate.equals("dec")){	
			rsa.decryption(source);
			FileInputStream fis = new FileInputStream("Converted-complete.txt");
			byte[] buffer = new byte[10];
			StringBuilder sb = new StringBuilder();
			while (fis.read(buffer) != -1) {
				sb.append(new String(buffer));
				buffer = new byte[10];
			}
			fis.close();

			String content = sb.toString();
			
			FileOutputStream convertedImageFile = new FileOutputStream(fileEdestination);
			byte[] stringImageBytes = decodeImage(content);
			convertedImageFile.write(stringImageBytes);
			
			convertedImageFile.close();
		}
			
			
			//imageOutFile.close();
			
			System.out.println("Image Successfully Manipulated!");
			
		} catch (FileNotFoundException e) {
			System.out.println("Image not found" + e);
		} 
		catch(NoSuchFileException e) 
        { 
            System.out.println("No such file/directory exists"); 
        } 
        catch(DirectoryNotEmptyException e) 
        { 
            System.out.println("Directory is not empty."); 
        } 
        catch(IOException e) 
        { 
            System.out.println("Invalid permissions."); 
        }

	}
	
	/**
	 * Encodes the byte array into base64 string
	 * @param imageByteArray - byte array
	 * @return String a {@link java.lang.String}
	 */
	public static String encodeImage(byte[] imageByteArray){		
		return Base64.encodeBase64URLSafeString(imageByteArray);		
	}
	
	/**
	 * Decodes the base64 string into byte array
	 * @param imageDataString - a {@link java.lang.String} 
	 * @return byte array
	 */
	public static byte[] decodeImage(String imageDataString) {		
		return Base64.decodeBase64(imageDataString);
	}

}
