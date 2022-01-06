package com.shivani.springboot.restAPI.util;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.aspectj.apache.bcel.util.ClassPath;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	public String UPLOAD_DIR;

	public boolean uploadFile(MultipartFile file, String dir) {
		try {

			/*
			 * InputStream inputStream = file.getInputStream(); byte[] data = new
			 * byte[inputStream.available()]; inputStream.read(data);
			 * 
			 * FileOutputStream fileOutputStream = new
			 * FileOutputStream(UPLOAD_DIR+File.separator+file.getOriginalFilename());
			 * fileOutputStream.write(data);
			 * 
			 * fileOutputStream.flush(); fileOutputStream.close(); f=true;
			 */
			UPLOAD_DIR = new ClassPathResource(dir).getFile().getAbsolutePath();

			Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
