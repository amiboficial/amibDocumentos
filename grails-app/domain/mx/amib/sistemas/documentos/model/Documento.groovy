package mx.amib.sistemas.documentos.model

import java.util.Date;

class Documento {

	Integer idTipo
	
	String uuid
	String nombre
	String clave
	String mimetype
	Date fechaModificacion
	Date fechaCreacion
	
	static mapping = {
		table 'v001_v_docnobinary'
		
		idTipo column:'type'
		
		uuid column:'uuid'
		nombre column:'tx_nombre'
		clave column:'tx_clave'
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
		mimetype maxSize: 128
		fechaModificacion nullable: true
		fechaCreacion nullable: true
	}
	
}
