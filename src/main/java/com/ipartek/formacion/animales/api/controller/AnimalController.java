package com.ipartek.formacion.animales.api.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.animales.modelo.pojo.Animal;
import com.ipartek.formacion.animales.service.AnimalService;

@CrossOrigin
@RestController
@RequestMapping("/api/animal")
public class AnimalController {

	@Autowired
	AnimalService animalService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Animal>> listar() {

		ResponseEntity<ArrayList<Animal>> response = new ResponseEntity<ArrayList<Animal>>(HttpStatus.NOT_FOUND);
		try {
			ArrayList<Animal> animales = (ArrayList<Animal>) animalService.listar();
			if (!animales.isEmpty()) {
				response = new ResponseEntity<ArrayList<Animal>>(animales, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<ArrayList<Animal>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Animal> detalle(@PathVariable int id) {

		ResponseEntity<Animal> response = new ResponseEntity<Animal>(HttpStatus.NOT_FOUND);
		try {
			Animal animal = (Animal) animalService.detalle(id);
			if (animal != null) {
				response = new ResponseEntity<Animal>(animal, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace(); 
			response = new ResponseEntity<Animal>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}
}
