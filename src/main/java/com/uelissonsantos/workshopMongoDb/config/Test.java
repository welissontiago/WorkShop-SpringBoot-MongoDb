package com.uelissonsantos.workshopMongoDb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.uelissonsantos.workshopMongoDb.domain.Post;
import com.uelissonsantos.workshopMongoDb.domain.User;
import com.uelissonsantos.workshopMongoDb.dto.AuthorDTO;
import com.uelissonsantos.workshopMongoDb.dto.CommentDTO;
import com.uelissonsantos.workshopMongoDb.repository.PostRepository;
import com.uelissonsantos.workshopMongoDb.repository.UserRepository;

@Configuration
public class Test implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");	
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viajem", "Vou viajar para são Paulo", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("22/03/2018"), "Partiu escola", "Vou ir para escola", new AuthorDTO (maria));
		
		CommentDTO c1 = new CommentDTO("Boa viagem Maria!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Ta com tudo Maria!", sdf.parse("21/03/2018"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Primeiro dia de aula?", sdf.parse("22/03/2018"), new AuthorDTO(bob));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		userRepository.save(maria);
		
		
		
	}

}
