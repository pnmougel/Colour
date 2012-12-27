package models.renorm

import scala.annotation.target.field

object Annotations {
    type FieldName = Attribute @annotation.target.field
}