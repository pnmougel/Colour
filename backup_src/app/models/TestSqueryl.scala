package models

import org.squeryl.Schema
import org.squeryl.KeyedEntity
import org.squeryl.annotations.Column
import org.squeryl.PrimitiveTypeMode._
import org.squeryl.dsl.ManyToOne
import org.squeryl.dsl.OneToMany

case class SPublisher(val name : String) extends KeyedEntity[Long] {
    val id : Long = 0
    
    
}

case class SubFieldTable(name : String, field_id : Long) extends KeyedEntity[Long] {
    val id : Long = 0
    lazy val field: ManyToOne[FieldTable] = AppDB.fieldToSubfields.right(this)
    
    
}

case class FieldTable(name : String) extends KeyedEntity[Long] {
    val id : Long = 0    
    lazy val subfields: OneToMany[SubFieldTable] = AppDB.fieldToSubfields.left(this)
    
    def searchField(name : String) = {
        from(AppDB.fields)( f => 
        where(f.name like name) 
        select(f)
    ).page(1, 10)
    }
}

object AppDB2 extends Schema {
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
