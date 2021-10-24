package com.livedataexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel : ViewModel {

    public var string : MutableLiveData<String>
    public var number = MutableLiveData<Int>()
    public var list = MutableLiveData<List<String>>()
    public var value = MutableLiveData<Double>()

    constructor()
    {
        number.value = 99
        string = MutableLiveData()
        list = MutableLiveData<List<String>>()
        value.value = 0.0

    }
}
