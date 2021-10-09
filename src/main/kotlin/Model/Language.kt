class Language (var id: String, var name: String) {

    override fun equals(other: Any?)
        = (other is Language)
            && id == other.id
            && name == other.name
}