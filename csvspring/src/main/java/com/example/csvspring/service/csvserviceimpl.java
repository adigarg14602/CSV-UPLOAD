package com.example.csvspring.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.csvspring.entity.User;
//import com.example.csvspring.repository.csvrepo;
import com.example.csvspring.repository.csvrepository;

//import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.*;
@Service
public class csvserviceimpl implements csvservice{
	@Autowired
	public csvrepository csvreposit;
	@Override
	public boolean hasCSVFormat(MultipartFile file) {
		String type = "text/csv";
		if(!type.equals(file.getContentType())) {
			return false;
		}
		return true;
	}
	
	@Override
	public void processandsavedata(MultipartFile file) {
		try {
			List<User> users = csvToUsers(file.getInputStream());
			csvreposit.saveAll(users);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private List<User> csvToUsers(InputStream inputStream) {
		// TODO Auto-generated method stub
		try ( 
			BufferedReader fileReader= new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
			CSVParser csvParser = new CSVParser(fileReader,CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());){
			List<User> users = new ArrayList<User>();	
			List <CSVRecord> record =csvParser.getRecords();
			
				
				for(CSVRecord csvRecords:record) {
					User user = new User(Long.parseLong(csvRecords.get("Index")),csvRecords.get("Height(Inches)"),csvRecords.get("adit"),csvRecords.get("Weigth(Pounds)"));
				
				users.add(user);
				}
				return users;
			}catch(IOException e) {
				e.printStackTrace();
			}
		
		return null;
	}
}
