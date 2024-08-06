package com.example.csvspring.service;

import org.springframework.web.multipart.MultipartFile;

public interface csvservice {

	boolean hasCSVFormat(MultipartFile file);

	void processandsavedata(MultipartFile file);

}
