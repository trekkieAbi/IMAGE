package com.eureka.server.controller;


import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.eureka.server.service.ImageService;


@RestController
@RequestMapping("/image")
public class ImageController {
	@Autowired
	private  ImageService imageService;
	@PostMapping
	public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile multipartFile) throws IOException{
		String uploadImage=imageService.uploadImage(multipartFile);
		return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
	}
	@GetMapping(value="/{fileName}",produces =MediaType.IMAGE_JPEG_VALUE)
	public HttpEntity<?> downloadImage(@PathVariable String fileName) throws InterruptedException, ExecutionException{
		byte[] imageData=imageService.downloadImage(fileName);
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.setContentType(MediaType.IMAGE_JPEG);
		httpHeaders.setContentLength(imageData.length);
		return new HttpEntity<byte[]>(imageData,httpHeaders);
		
	}
	
	

}
