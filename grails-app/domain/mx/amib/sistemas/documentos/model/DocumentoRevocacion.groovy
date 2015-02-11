package mx.amib.sistemas.documentos.model

import java.util.Date;

class DocumentoRevocacion extends Documento {
	
	String tipoDocumentoRespaldo
	String representanteLegalNombreCompleto
	Integer numeroEscritura
	Date fechaRevocacion
	String matriculasRevocados
	String nombresRevocados
	String notario
	String grupoFinanciero
	String institucion

	public DocumentoRevocacion(){
		this.idTipo = TipoDocumento.DOC_REV.id
	}
	
	static mapping = {
		table 't006_t_docrevocacion'
		tipoDocumentoRespaldo column:'ds_tpdocrespaldorevoc'
		representanteLegalNombreCompleto column:'nb_nbreplegal'
		numeroEscritura column:'nu_escritura'
		fechaRevocacion column:'fh_revocacion'
		matriculasRevocados column:'tx_matriculas'
		nombresRevocados column:'tx_revocados'
		notario column:'tx_notario'
		grupoFinanciero column:'tx_gpofinanciero'
		institucion column:'tx_instituto'

		version false
	}

	static constraints = {
		representanteLegalNombreCompleto nullable: true, maxSize: 280
		nombresRevocados nullable: true
		notario nullable: true
		grupoFinanciero nullable: true
		institucion nullable: true
	}
	
}
