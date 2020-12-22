package com.nytimespopular.assigenment.util

object CollectionUtils {
    fun <T> isEmpty(list: List<T>?): Boolean {
        return list == null || list.isEmpty()
    }

    fun <K, V> isEmpty(map: Map<K, V>?): Boolean {
        return map == null || map.isEmpty()
    }

    fun <T> isEmpty(set: Set<T>?): Boolean {
        return set == null || set.isEmpty()
    }
}