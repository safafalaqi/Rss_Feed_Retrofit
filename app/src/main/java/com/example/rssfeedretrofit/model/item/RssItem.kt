package com.example.rssfeedretrofit.model.item

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Path
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "item", strict = false)
class RssItem @JvmOverloads constructor(

    @field:Element(name = "title")
    @param:Element(name = "title")
    var title: String? = null,

    @field:Element(name = "description")
    @param:Element(name = "description")
    var description: String? = null,

    @field:Element(name = "link")
    @param:Element(name = "link")
    var link: String? = null,

    @field:Element(name = "pubdate", required = false)
    @param:Element(name = "pubdate")
    @field:Path("channel")
    @param:Path("channel")
    var pubdate: String? = null,


    @field:Element(name = "content", required = false)
    @param:Element(name = "content")
   var mediacontent: String? = null

) : Serializable