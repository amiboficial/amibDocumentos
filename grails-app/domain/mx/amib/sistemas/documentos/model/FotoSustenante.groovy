package mx.amib.sistemas.documentos.model

class FotoSustenante extends Documento{

	Integer numeroMatricula

	static mapping = {
		table 't004_t_fotosustentante'
		
		numeroMatricula column:'nu_matricula'
		version false
	}

	static constraints = {
		numeroMatricula nullable: true
	}
}
