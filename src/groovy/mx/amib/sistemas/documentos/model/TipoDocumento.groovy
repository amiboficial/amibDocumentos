package mx.amib.sistemas.documentos.model

public enum TipoDocumento {
	CNBVDGA(1,"CNBVDGA","CnbvDga"), 
	DOCPODER(2,"DOCPODER","DocumentoPoder"), 
	FOTOSUSTNT(3,"FOTOSUSTNT","FotoSustentante"), 
	DOCSUSTNT(4,"DOCSUSTNT","DocumentoSustentante")
	
	Integer id
	String clave
	String name

	TipoDocumento(Integer id, String clave, String name) {
		this.id = id
		this.clave = clave
		this.name = name
	}
	
	public String toString(){
		return name
	}

	public Integer getId() {
		return id
	}
	
}