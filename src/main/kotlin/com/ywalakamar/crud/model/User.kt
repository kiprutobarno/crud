package com.ywalakamar.crud.model

import javax.persistence.*

@Entity
@Table(name="users")
data class User(@Id @GeneratedValue(strategy=GenerationType.IDENTITY) val id:Int=0, val firstname:String, val lastname:String, val email:String, val password:String)
