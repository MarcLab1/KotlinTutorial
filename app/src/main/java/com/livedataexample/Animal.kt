package com.livedataexample

class Animal  {

    lateinit var name: String
    lateinit var type : String
    lateinit var color: String
    lateinit var pattern : String
    var age: Int = 0
    var imageRef: Int = 0

    constructor(name : String, type: String, color: String, pattern : String, age: Int, imageRef: Int)
    {
        this.name = name
        this.type = type
        this.age = age
        this.imageRef = imageRef
        this.pattern = pattern
        this.color = color
    }

}