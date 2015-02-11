package mx.amib.sistemas.documentos.model

class FotoSustenante extends Documento {

	Integer numeroMatricula
	String nombreCompleto

	public FotoSustenante(){
		this.idTipo = TipoDocumento.FOTO_SUSTNT.id
	}
	
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
