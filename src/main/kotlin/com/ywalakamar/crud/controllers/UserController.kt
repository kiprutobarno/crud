package com.ywalakamar.crud.controllers

import com.ywalakamar.crud.repository.UserRepository
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import com.ywalakamar.crud.model.User
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("/api")
class UserController(private val repo:UserRepository){
	@GetMapping("/users")

	fun getUsers():List<User> = repo.findAll()
	
	@GetMapping("/users/{id}")
	fun getUserById(@PathVariable(value="id") userId:Int):ResponseEntity<User>{
		return repo.findById(userId).map{
				user->ResponseEntity.ok(user)
		}.orElse(ResponseEntity.notFound().build())
	}
}
