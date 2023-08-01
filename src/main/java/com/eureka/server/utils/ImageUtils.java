package com.eureka.server.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class ImageUtils {
	
	public static final int BITE_SIZE=4*1024;
	
	//used to compress the image data 
	public static byte[] compressImage(byte[] data) throws IOException {
		Deflater deflater=new Deflater();//used to compress the image data while storing into the db......
		deflater.setLevel(Deflater.BEST_COMPRESSION);
		deflater.setInput(data);
		deflater.finish();
		ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream(data.length);//used to store and return the compressed image after compressing....
		byte[] tmp=new byte[BITE_SIZE];
		while(!deflater.finished()) {
			int size=deflater.deflate(tmp);//Compressed the input data
			byteArrayOutputStream.write(tmp,0,size);
		}
		byteArrayOutputStream.close();
		return byteArrayOutputStream.toByteArray();
}
	
	//used to decompress the image....
	public static byte[] decompressImage(byte[] data) throws DataFormatException, IOException {
		Inflater inflater=new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream arrayOutputStream=new ByteArrayOutputStream(data.length);
		byte[] tmp=new byte[BITE_SIZE];
		
		while(!inflater.finished()) {
			int count=inflater.inflate(tmp);
			arrayOutputStream.write(tmp,0,count);
		}
		arrayOutputStream.close();
		return arrayOutputStream.toByteArray();
	}
}
