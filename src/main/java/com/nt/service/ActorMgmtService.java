package com.nt.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.nt.commons.ActorConfiProperties;
import com.nt.constant.ActorConstants;
import com.nt.exception.ActorNotFoundException;
import com.nt.model.Actor;
import com.nt.repository.IActorReposiotry;

@Service
public class ActorMgmtService implements IActorMgmtService {

	private IActorReposiotry repo;
	
	private Map<String,String> messages;
//	private LoggerFactory logger = LoggerFactory.getLogger(getClass(ActorMgmtService.class));
	
	//Constructor Injection
	public ActorMgmtService(IActorReposiotry repo,ActorConfiProperties props) {
		this.repo = repo;
		messages = props.getMessages();
		System.out.println("messages::"+messages.toString());
	}
	
	
	@Override
	public String registerActor(Actor actor) {
		var saved = repo.save(actor);
		
		return saved.getActorId() != null ? messages.get(ActorConstants.SAVE_SUCCESS)+saved.getActorId() : messages.get(ActorConstants.SAVE_FAILURE);
	}
	
	
	
	@Override
	public Iterable<Actor> getAllActor() {
		Iterable<Actor> list = repo.findAll();
		//to sort as ascending order by names

		//using Lambda Expression
		Collections.sort((List<Actor>) list,
				(t1, t2) -> t1.getActorname().compareTo(t2.getActorname()));
		return list;
	}
	
	
	//fetch by ActorId
	
	@Override
	public Actor getActorById(int id) {
		/*Actor actor = repo.findById(id).get();
				return actor;*/

		//using lambda expression
		return repo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException(messages.get(ActorConstants.FINDY_BY_ID_INVALID)));
	}
	
	
	//fetch by Category
	@Override
	public List<Actor> fetchActorByCategories(String category1,
			String category2) {

		return repo.getActorByCategory(category1, category2);
	}
	
	//update or create
	@Override
	public String updateActor(Actor actor) {
		Optional<Actor> opt = repo.findById(actor.getActorId());
			if(opt.isPresent()) {
				repo.save(actor);   //update actor
				return messages.get(ActorConstants.UPDATE_SUCCESS);
			}
			else
				throw new ActorNotFoundException(messages.get(ActorConstants.FIND_BY_ID_FAILURE));
			
		
	}


	//full delete operation

	@Override
	public String deleteActorById(int id) {
		Optional<Actor> opt = repo.findById(id);
		if(opt.isPresent()) {
			repo.deleteById(id);
			return messages.get(ActorConstants.DELETE_SUCCESS)+ " with id value:: "+id;
		}
		else
			 throw new  ActorNotFoundException(messages.get(ActorConstants.FIND_BY_ID_FAILURE));
	}


	//performing partial update operation

	@Override
	public String updateMob(int id, long mob) {
		Optional<Actor> opt = repo.findById(id);
		
		if(opt.isPresent()) {
			Actor actor = opt.get();
			actor.setMobno(mob);
			repo.save(actor);
			return "Actor having id value: "+id+" phoneNo updated....";  
			
			
		} else
			throw new ActorNotFoundException(messages.get(ActorConstants.FIND_BY_ID_FAILURE));
	}

}
