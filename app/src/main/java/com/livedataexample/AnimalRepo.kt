package com.livedataexample

class AnimalRepo {

    var animals : ArrayList<Animal>

    constructor()
    {
        animals = ArrayList<Animal>()
        var cat2 = Animal("Catto", "cat",  "black", "plad", 17, R.drawable.animal2)
        var cat3 = Animal("Muffy", "cat", "grey", "plad", 33, R.drawable.animal3)
        var cat1 = Animal("Makey", "cat", "brown", "plad", 77, R.drawable.animal4)
        var dog2 = Animal("Jemma", "dog", "grey", "solid",55, R.drawable.animal5)
        var dog3 = Animal("Jimmy", "dog", "brown", "plad", 99, R.drawable.animal6)
        var dog1 = Animal("Lashy", "dog", "black", "plad", 20, R.drawable.animal1)
        animals.add(cat1)
        animals.add(cat2)
        animals.add(cat3)
        animals.add(dog1)
        animals.add(dog2)
        animals.add(dog3)
    }
}