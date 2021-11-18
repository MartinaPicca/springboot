package it.netgroup.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.netgroup.data.dto.ArticoliDTO;
import it.netgroup.data.dto.RecensioniDTO;
import it.netgroup.data.entity.Articoli;
import it.netgroup.feign.ArticoliClient;

@Component
public class ArticoliConverter {
	
	@Autowired
	ArticoliClient articoliClient;

	public List<ArticoliDTO> convertEntityToDto(List<Articoli> entities) {
		  List<ArticoliDTO> articolidto = new ArrayList<>();

	        for(int i = 0; i < entities.size(); i++) {
	            ArticoliDTO articoliDTO = new ArticoliDTO();
	            articoliDTO.setNomeArticolo(entities.get(i).getNomeArticolo());


	           Integer idArticolo = entities.get(i).getIdarticolo();

	           List<RecensioniDTO> recensione = articoliClient.getRecensioniByRecensioniWebService(idArticolo);

	            articoliDTO.setRecensioni(recensione);
	            articolidto.add(articoliDTO);
	        }
	        return articolidto;
	}

}
