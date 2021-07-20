package com.ywalakamar.crud.service

import org.springframework.stereotype.Service
import com.ywalakamar.crud.repository.UserRepository
import com.ywalakamar.crud.model.User
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import com.ywalakamar.crud.exception.UserNotFoundException

@Service
class UserService(private val repo:UserRepository) {
	
	fun create(user:User):User =repo.save(user)
	
	fun readAll():List<User> = repo.findAll()
	
	fun readOne(id:Int):User=repo.findById(id).orElseThrow{UserNotFoundException(HttpStatus.NOT_FOUND, "User not found")}
	
	fun update(userId:Int, user:User):User{
		return if(repo.existsById(userId)){
			repo.save(
				User(
					id=user.id,
					firstname=user.firstname,
					lastname=user.lastname,
					email=user.email,
					password=user.password
				)
			)
		}	else throw UserNotFoundException(HttpStatus.NOT_FOUND, "User not found")
	}
}
