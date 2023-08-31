package com.italoalbano.crm.application.dto

import java.time.LocalDate
import java.util.*

class ItemDTO {
    var id: UUID? = null
    var creationDate: LocalDate? = null
    var name: String? = null
    var description: String? = null
    var documents: List<DocumentDTO>? = null
}
