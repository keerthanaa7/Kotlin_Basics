package com.example.koltinbasics

import kotlin.Result


fun getResult(id: Int): kotlin.Result<String> {
    if(id == 1){
        return kotlin.Result.success("kotlin standard result class")
    }else{
        return Result.failure(Exception("exception"))
    }

}