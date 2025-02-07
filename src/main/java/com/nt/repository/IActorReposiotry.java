package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nt.model.Actor;
@Repository
public interface IActorReposiotry extends CrudRepository<Actor, Integer> {
	@Query("from Actor where category in(:c1,:c2) order by category")			//JPQL 
	public List<Actor> getActorByCategory(@Param("c1") String category1,@Param("c2") String category2);

}
