package com.example.csvspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.csvspring.response.ResponseMessage;
import com.example.csvspring.service.csvservice;

@RestController
@RequestMapping("/files")
public class csvcontroller {
	
	@Autowired
	private csvservice service;
	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam ("file") MultipartFile file){
		if(service.hasCSVFormat(file)) {
			service.processandsavedata(file);
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage ("uploaded csv file"+ file.getOriginalFilename()));

		}
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage ("please upload csv file"));
		
	}

}
