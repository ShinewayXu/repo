package com.x.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.x.entity.AntlrEntity;
import com.x.service.AntlrManagerService;

@RestController
public class AntlrManagerController {
	
	@Resource
	private AntlrManagerService service;

	@RequestMapping("/antlr_man/list")
	public List<AntlrEntity> list(){
		List<AntlrEntity> list = service.list();
		return list;
	}
}
