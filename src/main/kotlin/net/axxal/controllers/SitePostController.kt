package net.axxal.controllers

import net.axxal.types.*
import net.axxal.controllers.RestController
import net.axxal.services.SitePostService

class SitePostController() : RestController<SitePost>() {
    override fun getAll(): ArrayList<SitePost> {
        return SitePostServcice.getAll()
    }

    override fun getById(id: String): SitePost? {
        return SitePostService.getById(id)
    }
}