package mx.amib.sistemas.documentos.model

class FotoSustenante extends Documento {

	Integer numeroMatricula
	String nombreCompleto

	static mapping = {
		table 't004_t_fotosustentante'
		
		numeroMatricula column:'nu_matricula'
		nombreCompleto column:'nb_sustentante'
		
		version false
	}

	static constraints = {
		numeroMatricula nullable: true
		nombreCompleto nullable: true
	}
}
