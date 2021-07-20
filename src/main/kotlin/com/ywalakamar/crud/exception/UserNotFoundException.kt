package com.ywalakamar.crud.exception

import org.springframework.http.HttpStatus

class UserNotFoundException(val statusCode:HttpStatus, val reason:String):Exception()