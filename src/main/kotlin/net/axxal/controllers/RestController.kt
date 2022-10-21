package net.axxal.controllers

interface RestController<T> {
    fun getAll(): ArrayList<T>
    fun getById(id: String): T?
    fun save(item: T): T?
    fun update(id: String, item: T): T?
    fun delete(id: String): T?
}