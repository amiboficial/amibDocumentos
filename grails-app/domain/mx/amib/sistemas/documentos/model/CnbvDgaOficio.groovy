package mx.amib.sistemas.documentos.model

class CnbvDgaOficio extends Documento {

	String matriculas
	String nombres
	String autorizaciones
	
	static mapping = {
		table 't002_t_cnbvdga'
		
		matriculas column:'tx_matriculas'
		nombres column:'tx_nombres'
		autorizaciones column:'tx_autorizaciones'
		
		version false
	}

	static constraints = {
		matriculas nullable: true
		nombres nullable: true
		autorizaciones nullable: true
	}
}
