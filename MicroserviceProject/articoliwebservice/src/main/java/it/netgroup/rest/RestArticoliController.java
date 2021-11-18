package it.netgroup.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.netgroup.data.dto.ArticoliDTO;
import it.netgroup.service.ArticoliService;

@RestController
@RequestMapping("/api/articoli")
public class RestArticoliController {
	
	@Autowired
	ArticoliService artser;

	@GetMapping 
	public List<ArticoliDTO> getArticoliDTO(){
		return artser.findAll();
	}
}
