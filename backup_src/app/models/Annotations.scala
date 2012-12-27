package models

object Annotations {
    type FieldName = Attribute @annotation.target.field
}