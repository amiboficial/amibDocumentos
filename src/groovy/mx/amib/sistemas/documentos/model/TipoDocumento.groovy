package mx.amib.sistemas.documentos.model

public enum TipoDocumento {
	NOT_TYPE(1,"NOT_TYPE",""),
	CNBV_DGA_OFICIO(2,"CNBV_DGA_OFICIO","CnbvDgaOficio"), 
	DOC_PODER(3,"DOC_PODER","DocumentoPoder"),
	FOTO_SUSTNT(4,"FOTO_SUSTNT","FotoSustentante"), 
	DOC_SUSTNT(5,"DOC_SUSTNT","DocumentoSustentante"),
	DOC_REV(6,"DOC_REV","DocumentoRevocacion")
	
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
	
	public String getClave() {
		return clave
	}
	
}