package com.dev.comapp.controllers;

import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dev.comapp.models.Post;
import com.dev.comapp.repository.CategoriaRepository;
import com.dev.comapp.repository.PostRepository;


@Controller
public class PostController {
	
	@Autowired
	private PostRepository repository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping("/post")
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("/post");
		mv.addObject("posts", repository.findAll());
			
		return mv;
	}
	
	@GetMapping("/add")
	public ModelAndView add(Post post) {
		
		ModelAndView mv = new ModelAndView("/postAdd");
		mv.addObject("post", post);
		
		mv.addObject("categorias", categoriaRepository.findAll());
		
		return mv;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		Optional<Post> post = repository.findById(id);
		Post e = post.get();	
		
		return add(e);
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		Optional<Post> post = repository.findById(id);
		Post e = post.get();
		repository.delete(e);	
		
		return findAll();
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid Post post, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(post);
		}
		
		repository.saveAndFlush(post);
		
		return findAll();
	}
	
}
