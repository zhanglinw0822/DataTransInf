package com.zhanglin.tools;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

public class FileTools {
	public static void copy(String filename,String sourcepath,String targetpath) throws Exception{
		Path source = FileSystems.getDefault().getPath(sourcepath).resolve(filename);
		Path target = FileSystems.getDefault().getPath(targetpath);
		if(Files.exists(source)){
			if(Files.notExists(target)){
				Files.createDirectories(target);
			}
			Files.copy(source, target.resolve(filename),StandardCopyOption.REPLACE_EXISTING);
		}
	}
	
	public static void delete(String filename,String path) throws Exception{
		Path source = FileSystems.getDefault().getPath(path).resolve(filename);
		Files.deleteIfExists(source);
	}
	
	public static void write(String filename,String path,byte[] bytes) throws Exception{
		Path source = FileSystems.getDefault().getPath(path);
		if(Files.notExists(source)){
			Files.createDirectories(source);
		}
		Files.write(source.resolve(filename), bytes,StandardOpenOption.CREATE,StandardOpenOption.APPEND);
	}
}
