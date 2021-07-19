package com.ywalakamar.crud.repository

import com.ywalakamar.crud.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository:JpaRepository<User, Long>
