package mx.amib.sistemas.documentos.model

class DocumentoSustentante extends Documento {

	Integer numeroMatricula
	String tipoDocumentoSustentante
	String nombreCompleto
	
	static mapping = {
		table 't005_t_docsustenate'
		
		numeroMatricula column:'nu_matricula'
		nombreCompleto column:'nb_sustentante'
		tipoDocumentoSustentante column:'tx_tpdocsustentante'
		
		version false
	}

	static constraints = {
		tipoDocumentoSustentante nullable: true, maxSize: 100
		numeroMatricula nullable: true
		nombreCompleto nullable: true
	}
}
