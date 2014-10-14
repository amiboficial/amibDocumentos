package mx.amib.sistemas.documentos.model

import java.util.Date;

class Documento{

	String uuid
	String nombre
	String clave
	byte[] dato
	String mimetype
	Date fechaModificacion
	Date fechaCreacion
	
	static mapping = {
		table 't001_t_doc'
		
		uuid column:'uuid'
		nombre column:'tx_nombre'
		clave column:'tx_clave'
		dato column:'bl_dato'
		mimetype column:'tx_mimetype'
		fechaModificacion column:'fh_modificacion'
		fechaCreacion column:'fh_creacion'
		
		tablePerHierarchy false
		version false
	}
	
	static constraints = {
		uuid nullable: true
		nombre nullable: true
		clave nullable: true, maxSize: 100
		dato nullable: true
		mimetype maxSize: 128
		fechaModificacion nullable: true
		fechaCreacion nullable: true
	}
	
}
