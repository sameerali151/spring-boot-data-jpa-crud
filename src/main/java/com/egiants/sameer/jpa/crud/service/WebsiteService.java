package com.egiants.sameer.jpa.crud.service;

import java.util.List;
import java.util.stream.Collectors;

import com.egiants.sameer.jpa.crud.entity.Website;
import com.egiants.sameer.jpa.crud.repository.CRUDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egiants.sameer.jpa.crud.vo.WebsiteVo;

@Service
public class WebsiteService {

	@Autowired
	private CRUDRepository repository;

	public List<WebsiteVo> getWebsiteList() {
		return repository.findAll().stream().map(w -> {
			WebsiteVo vo = new WebsiteVo(w.getId(), w.getName(), w.getUrl());
			return vo;
		}).collect(Collectors.toList());
	}

	public WebsiteVo getWebsiteById(Integer id) {
		return repository.findById(id).map(w -> {
			WebsiteVo vo = new WebsiteVo(w.getId(), w.getName(), w.getUrl());
			return vo;
		}).orElseGet(null);
	}

	public void saveWebsite(WebsiteVo vo) {
		Website website = new Website();
		website.setName(vo.getName());
		website.setUrl(vo.getUrl());
		repository.save(website);
	}

	public void updateWebsite(WebsiteVo vo) {
		Website website = new Website(vo.getId(), vo.getName(), vo.getUrl());
		repository.save(website);
	}

	public void deleteWebsite(WebsiteVo vo) {
		Website website = new Website(vo.getId(), vo.getName(), vo.getUrl());
		repository.delete(website);
	}

}
