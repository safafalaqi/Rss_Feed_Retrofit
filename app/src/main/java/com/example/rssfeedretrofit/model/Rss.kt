package com.example.rssfeedretrofit.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import java.io.Serializable


@Root(name = "rss", strict = false)
class Rss constructor() : Serializable   {

    @field:Element(name ="channel")
    var channel:RssChannel? = null


}