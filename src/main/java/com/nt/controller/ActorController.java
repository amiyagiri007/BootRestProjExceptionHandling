package com.nt.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Actor;
import com.nt.service.IActorMgmtService;

@RestController
@RequestMapping("/actor/api") //global path
public class ActorController {

	private IActorMgmtService service;
	
	public ActorController(IActorMgmtService service) {
		this.service = service;
		}

	@PostMapping("/register") //1 end point  and it is non-idemopotent
	public ResponseEntity<Actor> register(@RequestBody Actor actor) {
			service.registerActor(actor);
			return new ResponseEntity<>(actor, HttpStatus.CREATED);
			
	}
	
	
	/*@GetMapping("/get")
	public  ResponseEntity<Iterable<Actor>>  fetchAllActor(){
		//use service
		try {
			Iterable< Actor> list =  service.getAllActor();
			return new ResponseEntity<Iterable<Actor>>(list,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return throw new ResponseEntity<Iterable<Actor>>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/

	@GetMapping("/get")
	public ResponseEntity<?> fetchAllActor() {
		//use service
		try {
			Iterable<Actor> list = service.getAllActor();
			return new ResponseEntity<Iterable<Actor>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@GetMapping("/byId/{id}")
	public ResponseEntity<?> getActor(@PathVariable Integer id){
		/*try {*/
			Actor actor = 	service.getActorById(id);
			return new ResponseEntity<Actor>(actor,HttpStatus.OK);
	/*	}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}*/

	}
	
	@GetMapping("/actorsinfo/{c1}/{c2}")
	public ResponseEntity<?> fetchActorByCategories(@PathVariable("c1") String category1 ,@PathVariable("c2") String category2){
		//use service
		try {
			List<Actor> fetchActorByCategories = service.fetchActorByCategories(category1, category2);
			System.out.println("The list is::"+fetchActorByCategories);
			return new ResponseEntity<List<Actor>>(fetchActorByCategories, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	
	@PutMapping("/update")   //full update or complete updation
	public ResponseEntity<String> updateActor(@RequestBody Actor actor){
			//use service
			String msg  = service.updateActor(actor);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteActor(@PathVariable Integer id){
			String msg = service.deleteActorById(id);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@PatchMapping("/partial/{id}/{mobno}")
	public ResponseEntity<String> partialUpdate(@PathVariable int id,@PathVariable("mobno") long phoneNo){
			//use service
			String msg = service.updateMob(id, phoneNo);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
	}

}
