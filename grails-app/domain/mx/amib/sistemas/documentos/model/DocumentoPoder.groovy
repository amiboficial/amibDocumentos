package mx.amib.sistemas.documentos.model

class DocumentoPoder extends Documento {

	String tipoDocumentoRespaldo
	String representanteLegalNombre
	String representanteLegalApellido1
	String representanteLegalApellido2
	Boolean esRegistradoPorGrupoFinanciero
	Integer numeroEscritura
	Date fechaApoderamiento
	String jsonApoderados
	String jsonNotario
	String jsonGrupoFinanciero
	String jsonInstitucion

	static mapping = {
		table 't003_t_docpoder'
		tipoDocumentoRespaldo column:'ds_tpdocrespaldo'
		representanteLegalNombre column:'nb_nombrereplegal'
		representanteLegalApellido1 column:'nb_apellido1replegal'
		representanteLegalApellido2 column:'nb_apellido2replegal'
		esRegistradoPorGrupoFinanciero column:'st_regporgrupofin'
		numeroEscritura column:'nu_escritura'
		fechaApoderamiento column:'fh_apoderamiento'
		jsonApoderados column:'json_apoderados'
		jsonNotario column:'json_notario'
		jsonGrupoFinanciero column:'json_gpofinanciero'
		jsonInstitucion column:'json_instituto'

		version false
	}

	static constraints = {
		representanteLegalNombre nullable: true, maxSize: 80
		representanteLegalApellido1 nullable: true, maxSize: 100
		representanteLegalApellido2 nullable: true, maxSize: 100
		esRegistradoPorGrupoFinanciero nullable: true
		jsonApoderados nullable: true, maxSize: 2000
		jsonNotario nullable: true, maxSize: 2000
		jsonGrupoFinanciero nullable: true, maxSize: 2000
		jsonInstitucion nullable: true, maxSize: 2000
	}
	
}
