package com.eureka.server.service;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
	
	public String uploadImage(MultipartFile multipartFile)throws IOException;
	
	public byte[] downloadImage(String imageName) throws InterruptedException,ExecutionException;

}
