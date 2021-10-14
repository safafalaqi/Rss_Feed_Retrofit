package com.example.rssfeedretrofit.model

import com.example.rssfeedretrofit.model.item.RssItem
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "channel", strict = false)
class RssChannel  constructor() : Serializable {

    @field:ElementList(inline = true, name = "item")
    var items: MutableList<RssItem>? = null

}


