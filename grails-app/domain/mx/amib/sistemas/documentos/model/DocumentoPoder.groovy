package mx.amib.sistemas.documentos.model

class DocumentoPoder extends Documento {

	String datosAdicionales

	static mapping = {
		table 't003_t_docpoder'
		
		datosAdicionales column:'tx_datosadicionales'

		version false
	}

	static constraints = {
		datosAdicionales nullable: true, maxSize: 100
	}
	
}
