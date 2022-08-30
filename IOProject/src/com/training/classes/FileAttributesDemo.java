package com.training.classes;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileAttributesDemo {

	public static void main(String[] args) {
		
		//attributes of a file
		
		File file = new File("d:\\files");
		if(file.exists())
		{
			System.out.println("File Exists..");
			
			if(file.isDirectory())
			{
				System.out.println("it is a directory");
				File files[]= file.listFiles();
				for(File fn:files)
				{
					System.out.println(fn+" "+fn.length());
				}
			}
			else 
			{
				System.out.println("It is a regular file");
				System.out.println("Size:"+file.length());
				System.out.println("Modified:"+new Date(file.lastModified()));
				System.out.println("Readable:"+file.canRead());
				System.out.println("Writable:"+file.canWrite());
				
				
			}
		}
		else
		{
			System.out.println("File does not exist");
			
			try {
				file.createNewFile();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}

	}

}
