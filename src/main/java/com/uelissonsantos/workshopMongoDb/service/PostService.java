package com.uelissonsantos.workshopMongoDb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uelissonsantos.workshopMongoDb.domain.Post;
import com.uelissonsantos.workshopMongoDb.repository.PostRepository;
import com.uelissonsantos.workshopMongoDb.service.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	

	
	public Post findById(String id) {
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		return postRepository.findByTitle(text);
	}
	

}
