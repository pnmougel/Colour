package models

import org.squeryl.Schema
import org.squeryl.PrimitiveTypeMode._

object AppDB extends Schema {
    val publishers = table[SPublisher]("publisher")
    
    val fields = table[FieldTable]("field")
    
    val subfields = table[SubFieldTable]("subfield")
    
    on(publishers)(b => declare(
    	b.id is(autoIncremented("publisher_id_seq"))
    ))
    
    on(subfields)(e => declare(
    	e.id is(autoIncremented("subfield_id_seq"))
    ))
    
    on(fields)(e => declare(
    	e.id is(autoIncremented("field_id_seq"))
    ))
    
    val fieldToSubfields = oneToManyRelation(fields, subfields).via((s,c) => s.id === c.field_id) 
}