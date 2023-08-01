package com.eureka.server.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eureka.server.entity.Image;

@Repository
public interface ImageRepo extends JpaRepository<Image, Long> {
	
	Optional<Image> findByName(String name);

}
