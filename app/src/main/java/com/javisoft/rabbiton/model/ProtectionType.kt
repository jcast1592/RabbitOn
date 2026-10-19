package com.javisoft.rabbiton.model

enum class ProtectionType {
    CONDOM,
    PREP,
    PEP,
    ART,
    DOXY_PEP
}

fun ProtectionType.getName() : String = when (this) {
    ProtectionType.CONDOM -> "Condom"
    ProtectionType.PREP -> "PrEP"
    ProtectionType.PEP -> "PEP"
    ProtectionType.ART -> "Antiretroviral"
    ProtectionType.DOXY_PEP -> "DoxyPEP"
}
