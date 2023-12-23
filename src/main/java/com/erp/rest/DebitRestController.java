package com.erp.rest;

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

import com.erp.entity.DebitEntity;
import com.erp.service.DebitService;

@RestController
public class DebitRestController {

	@Autowired
	private DebitService Services;

	@PostMapping("/save")
	public ResponseEntity<String> saveDebitNote(@RequestBody DebitEntity entity) {
		Boolean saveDebit = Services.saveDebit(entity);
		if (saveDebit) {
			return new ResponseEntity<String>("data save in debitNote", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("data not save in debitNote", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

	@GetMapping("purchase/{id}")
	public ResponseEntity<DebitEntity> getByIdDebit(@PathVariable Integer id) {
		DebitEntity entity = Services.getById(id);
		if (entity != null) {
			return new ResponseEntity<DebitEntity>(entity, HttpStatus.OK);
		} else {
			return new ResponseEntity<DebitEntity>(entity, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteDebitById(@PathVariable Integer id) {
		String delete = Services.deleteDebitById(id);
		return new ResponseEntity<>(delete, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<DebitEntity> updateDebit(@RequestBody DebitEntity entity) {
		DebitEntity updateDetails = Services.updateDebit(entity);
		if (updateDetails != null) {
			return new ResponseEntity<>(updateDetails, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(updateDetails, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
}
