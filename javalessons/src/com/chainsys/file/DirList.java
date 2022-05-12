package com.chainsys.file;

import java.io.File;

public class DirList {

	public static void main(String[] args) {
		String dirname="D:\files";
				File file=new File(dirname);
		String listoffilenameindirectory=file.list();
		for(int i=0;i<listoffilenameindirectory.length();i++)
		{
			File f=new File(dirname+"/"+listoffilenameindirectory);
			if(f.isDirectory())
			{
				System.out.println("\t<"+f.getName()+">is a sub directory");
			}
			else
			{
				System.out.println("\t"+f.getName()+"is a file");
			}
		}
	}

}
