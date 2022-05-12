package com.chainsys.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class FileOperations {


	public static void main(String[]args) throws IOException
	{
		
		readDataFromFile();
	}
	public static void CreateNewFile()
	{
		try {
		File file=new File("D:\\files\\ki.txt");
		if(file.createNewFile())
		{
			System.out.println("File Created");
		}
		else
		{
			System.out.println("File exists");
		}
	}catch(Exception e)
		{
		System.out.println("ERROR");
		}
	}
		public static void renameFile()
		{
			try {
			File file=new File("D:\\files\\ki.txt");
			if(file.renameTo(new File("D:\\files\\kiru.txt")))
			{
				System.out.println(file.getName()+" was renamed successfully");
			}
			else
			{
				System.out.println("File was not renamed successfully ");
			}
		}catch(Exception e)
			{
			System.out.println("ERROR");
			}
	}
		public static void deleteFile()
		{
			try {
			File file=new File("D:\\files\\kiru.txt");
			if(file.delete())
			{
				System.out.println(file.getName()+"was deleted successfully");
			}
			else
			{
				System.out.println("File was not deleted successfully ");
			}
		}catch(Exception e)
			{
			System.out.println("ERROR");
			}
	}
		public static void appendDataToFile()
		{
			String data="Kiruthika chainsys";
			try
			{
				FileWriter output=new FileWriter("D:\\files\\ki.txt");
				output.write(data);
				System.out.println("Data appended");
				output.close();
			}
			catch(Exception e)
			{
				 System.out.println("ERROR");
			}
		}
		public static void readDataFromFile()
		{
			File file=new File("D:\\files\\ki.txt");
			Scanner sc = null;
			try {
				sc = new Scanner(file);
			} catch (FileNotFoundException e) {
				System.out.println("ERROR");
				e.printStackTrace();
			}
			while(sc.hasNextLine())
			{
				System.out.println(sc.nextLine());
			}
			}
		public static void moveFile()
		{
			  
			 {
			        Path source=Paths.get("D:\\files\\kiru.txt");
			        Path target=Paths.get("D:\\files\\kiruthika.txt");
			        try
			        {
			          Files.move(source, target);
			        }
			        catch(IOException e)
			        {
			            e.printStackTrace();
			        }
			    }
			
		}
		public static void copyFile() throws IOException
		{
			var source = new File("D:\\files\\ki.txt");
	        var dest = new File("D:\\files\\kiru.txt");

	        Files.copy(source.toPath(), dest.toPath(),
	                StandardCopyOption.REPLACE_EXISTING);
		}


	
			 public static void modifyFile()throws IOException
		     {
		         String filePath = "D:\\files\\kiruthika.txt";
		         Scanner sc = new Scanner(new File(filePath));
		         StringBuffer buffer = new StringBuffer();
		         while (sc.hasNextLine()) {
		            buffer.append(sc.nextLine()+System.lineSeparator());
		         }
		         String fileContents = buffer.toString();
		         System.out.println("Contents of the file: "+fileContents);
		         sc.close();
		         String oldLine = "kiruthika chainsys";
		         String newLine = "kiru";
		         fileContents = fileContents.replaceAll(oldLine, newLine);
		         FileWriter writer = new FileWriter(filePath);
		         System.out.println("");
		         System.out.println("new data: "+fileContents);
		         writer.append(fileContents);
		         writer.flush();
		     }
		}
		     
		   
		    
		
		


