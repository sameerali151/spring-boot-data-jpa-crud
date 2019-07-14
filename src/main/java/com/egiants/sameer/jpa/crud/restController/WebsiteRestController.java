package com.egiants.sameer.jpa.crud.restController;

import java.util.List;

import com.egiants.sameer.jpa.crud.service.WebsiteService;
import com.egiants.sameer.jpa.crud.vo.WebsiteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SuppressWarnings({"unused"})
public class WebsiteRestController {

	@Autowired
	private WebsiteService service;

	@GetMapping("/website/{id}")
	public ResponseEntity<WebsiteVo> getWebsite(@PathVariable Integer id) {
		return new ResponseEntity<>(service.getWebsiteById(id), HttpStatus.OK);
	}

	@GetMapping("/website")
	public ResponseEntity<List<WebsiteVo>> getWebsiteList() {
		return new ResponseEntity<List<WebsiteVo>>(service.getWebsiteList(), HttpStatus.OK);
	}

	@PostMapping("/website")
	public ResponseEntity<String> saveWebsite(@RequestBody WebsiteVo websiteVo) {
		service.saveWebsite(websiteVo);
		return new ResponseEntity<>("New website successfully saved", HttpStatus.OK);
	}

	@PutMapping("/website")
	public ResponseEntity<String> updateWebsite(@RequestBody WebsiteVo websiteVo) {
		service.updateWebsite(websiteVo);
		return new ResponseEntity<>("Website successfully updated", HttpStatus.OK);
	}

	@DeleteMapping("/website")
	public ResponseEntity<String> deleteWebsite(@RequestBody WebsiteVo websiteVo) {
		service.deleteWebsite(websiteVo);
		return new ResponseEntity<>("Website successfully deleted", HttpStatus.OK);
	}

}
