package mx.amib.sistemas.documentos.model

class CnbvDgaOficio extends Documento {

	String datosAdicionales

	static mapping = {
		table 't002_t_cnbvdga'
		
		datosAdicionales column:'tx_datosadicionales'

		version false
	}

	static constraints = {
		datosAdicionales nullable: true, maxSize: 100
	}
}
