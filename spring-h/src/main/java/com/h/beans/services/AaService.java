package com.h.beans.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AaService {
	
	@Autowired
	private AbService abService;

	public AaService() {
		System.out.println("AaService�Ĺ��췽��ִ���ˡ�");
	}
	
	

}
