package com.eureka.server.entity;



import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import javax.persistence.*;

@javax.persistence.Entity
@NoArgsConstructor
@AllArgsConstructor
@javax.persistence.Table(name="Images")
public class Image {
	
	@Id
	@GeneratedValue(strategy =  javax.persistence.GenerationType.AUTO)
	@Column(name="IMAGE_ID")
	private Long id;
	@Column(name="IMAGE_NAME")
	private String name;
	@Column(name="IMAGE_TYPE")
	private String type;
	@Lob
    @Column(name = "photo", columnDefinition="BLOB")
	private byte[] imageData;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public byte[] getImageData() {
		return imageData;
	}
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	
	

}
