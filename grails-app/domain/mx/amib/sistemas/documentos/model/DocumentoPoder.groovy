package mx.amib.sistemas.documentos.model

class DocumentoPoder extends Documento {

	String tipoDocumentoRespaldo
	String representanteLegalNombreCompleto
	Integer numeroEscritura
	Date fechaApoderamiento
	String matriculasApoderados
	String nombresApoderados
	String notario
	String grupoFinanciero
	String institucion

	public DocumentoPoder(){
		this.idTipo = TipoDocumento.DOC_PODER.id
	}
	
	static mapping = {
		table 't003_t_docpoder'
		tipoDocumentoRespaldo column:'ds_tpdocrespaldo'
		representanteLegalNombreCompleto column:'nb_nbreplegal'
		numeroEscritura column:'nu_escritura'
		fechaApoderamiento column:'fh_apoderamiento'
		matriculasApoderados column:'tx_matriculas'
		nombresApoderados column:'tx_apoderados'
		notario column:'tx_notario'
		grupoFinanciero column:'tx_gpofinanciero'
		institucion column:'tx_instituto'

		version false
	}

	static constraints = {
		representanteLegalNombreCompleto nullable: true, maxSize: 280
		nombresApoderados nullable: true
		notario nullable: true
		grupoFinanciero nullable: true
		institucion nullable: true
	}
	
}
