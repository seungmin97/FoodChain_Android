package com.team.foodchain

data class PostSigninGeneralResponse (
        var message : String,
        var token : String,
        var identify : Int,
        var cate_flag : Int,
        var locate_flag : Int
)