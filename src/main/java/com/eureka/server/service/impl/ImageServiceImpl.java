package com.eureka.server.service.impl;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.eureka.server.entity.Image;
import com.eureka.server.exception.CustomException;
import com.eureka.server.repo.ImageRepo;
import com.eureka.server.service.ImageService;
import com.eureka.server.utils.ImageUtils;

@Service
public class ImageServiceImpl implements ImageService {
	@Autowired
	private ImageRepo imageRepo;


	@Override
	public String uploadImage(MultipartFile multipartFile) throws IOException {
		Image image=new Image();
		image.setName(multipartFile.getOriginalFilename());
		image.setType(multipartFile.getContentType());
		image.setImageData(ImageUtils.compressImage(multipartFile.getBytes()));
		imageRepo.save(image);
		return "file uploaded successfully: "+multipartFile.getOriginalFilename();
	}

	@Override
	public byte[] downloadImage(String imageName) throws InterruptedException, ExecutionException {
		
		Executor executor=Executors.newFixedThreadPool(10);
		CompletableFuture<byte[]> completableFuture=CompletableFuture.supplyAsync(()->{
			return imageRepo.findByName(imageName).get();	
		}
		
).thenApply((image)->{
		try {
		return ImageUtils.decompressImage(image.getImageData());
		}catch (Exception e) {
			throw new CustomException("Something went wrong during file downloading!!!",HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
		);
		return completableFuture.get();
		}

}	
