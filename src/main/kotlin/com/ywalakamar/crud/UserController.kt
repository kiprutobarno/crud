package com.ywalakamar.crud

import com.ywalakamar.crud.repository.UserRepository
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import com.ywalakamar.crud.model.User

@RestController
@RequestMapping("/api")
class UserController(private val repo:UserRepository){
	@GetMapping("/users")

	fun getUsers():List<User> = repo.findAll()
}
