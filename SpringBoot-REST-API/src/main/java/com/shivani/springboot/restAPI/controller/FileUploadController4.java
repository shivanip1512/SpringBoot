package com.shivani.springboot.restAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shivani.springboot.restAPI.util.FileUploadHelper;

@RestController
public class FileUploadController4 {
	
	@Autowired
	private FileUploadHelper fileUploadHelper;

	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadfile(@RequestParam("file") MultipartFile file) {

		String fileContentType = file.getContentType();
		System.out.println(fileContentType);
		
		try {
		if (file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Empty file can'nt be uploaded");
		}
		fileUploadHelper.UPLOAD_DIR="C:\\Users\\Shivani\\git\\springBootMVC\\SpringBoot-REST-API\\src\\main\\resources\\static\\";
		if (fileContentType.equals("application/pdf")) {
			fileUploadHelper.UPLOAD_DIR += "pdf";
		} else if (fileContentType.startsWith("image")) {
			fileUploadHelper.UPLOAD_DIR += "images";
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fileContentType + " file type can'nt be uploaded");
		}
		
//		file upload code..
		boolean isUploaded = fileUploadHelper.uploadFile(file);
		if(isUploaded) {
			return ResponseEntity.ok("File uploaded successfully..");
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong! Try again");
	}
}
