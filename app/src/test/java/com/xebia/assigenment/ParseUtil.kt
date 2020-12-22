package com.xebia.assigenment

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.IOException

class ParseUtil<T> {
    companion object {
        fun <T> getObject(json: String?, className: Class<T>?): T? {
            if (json != null) {
                val mapper = ObjectMapper()
                try {
                    return mapper.readValue(json, className)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
            return null
        }

        fun getJson(`object`: Any?): String? {
            if (`object` != null) {
                val mapper = ObjectMapper()
                try {
                    return mapper.writeValueAsString(`object`)
                } catch (e: JsonProcessingException) {
                    e.printStackTrace()
                }
            }
            return null
        }
    }
}