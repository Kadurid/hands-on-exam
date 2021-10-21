package org.springsource.cloudfoundry.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springsource.cloudfoundry.mvc.repository.*;

@RequestMapping("user")
public class UserResource {
	
	public static final String USER_ENTRY_URL = "/users";
	
	@Autowired
	UserRepository repository;
	
	@RequestMapping(value = USER_SEARCH_URL, method = RequestMethod.GET)
	public User listar() {
		repository.findAll();
	}
	
	@RequestMapping(value = USER_SEARCH_URL+ "/{id}", method = RequestMethod.GET)
	public User consultar(@PathVariable Long id) {
		repository.findById(id);
	}
	
	@RequestMapping(value = USER_SEARCH_URL, method = RequestMethod.POST)
	public User salvar(@RequestBody User user) {
		repository.save(user);
	}
	
	@RequestMapping(value = USER_SEARCH_URL+ "/{id}", method = RequestMethod.PUT)
	public User salvar(@PathVariable Long id, @RequestBody User user) {
		repository.findById(id).map(e -> {
			repository.save(user);
		});
	}
	
	

}
