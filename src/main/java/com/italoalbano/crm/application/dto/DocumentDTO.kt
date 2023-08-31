package com.italoalbano.crm.application.dto

import java.io.InputStream
import java.util.*

class DocumentDTO(
    id: UUID,
    name: String,
    mimeType: String,
    hash: String,
    size: Long,
    inputStream: InputStream
) {
    var id: UUID? = id
    var name: String? = name
    var mimeType: String? = mimeType
    var hash: String? = hash
    var size: Long? = size
    var inputStream: InputStream? = inputStream
}
