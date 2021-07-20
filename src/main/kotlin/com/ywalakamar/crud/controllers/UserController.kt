package com.ywalakamar.crud.controllers

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import com.ywalakamar.crud.model.User
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PutMapping
import com.ywalakamar.crud.service.UserService
import org.springframework.web.bind.annotation.DeleteMapping

@RestController
@RequestMapping("/api")
class UserController(private val service:UserService){
	
	@PutMapping("/users/{id}")
	fun updateUser(@PathVariable("id") userId:Int, @RequestBody newUser:User):User=service.update(userId, newUser)
	
	@PostMapping("/users")
	@ResponseStatus(HttpStatus.CREATED)
	fun createUser(@RequestBody user:User):User=service.create(user)
	
	@GetMapping("/users")
	fun getUsers():List<User> = service.readAll()
	
	@GetMapping("/users/{id}")
	fun getUserById(@PathVariable("id") userId:Int):User=service.readOne(userId)
	
	@DeleteMapping("/users/{id}")
	fun deleteUser(@PathVariable("id") userId:Int):Unit=service.delete(userId)
	
	
	
}
