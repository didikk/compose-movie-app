package com.example.mymovie.domain.mapper

interface Mapper<FROM, TO> {
    /**
     * map object from one type to another
     * @param from - type for mapping
     * @return expected object with specified type
     */
    fun map(from: FROM): TO
}