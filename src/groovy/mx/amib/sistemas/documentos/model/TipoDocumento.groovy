package mx.amib.sistemas.documentos.model

import java.util.Map
import java.util.HashMap

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

	public static Map<Integer,TipoDocumento> getMap(){
		def enumMap = new HashMap<Integer,TipoDocumento>()
		enumMap.put(TipoDocumento.NOT_TYPE.getId(), TipoDocumento.NOT_TYPE)
		enumMap.put(TipoDocumento.CNBV_DGA_OFICIO.getId(), TipoDocumento.CNBV_DGA_OFICIO)
		enumMap.put(TipoDocumento.DOC_PODER.getId(), TipoDocumento.DOC_PODER)
		enumMap.put(TipoDocumento.FOTO_SUSTNT.getId(), TipoDocumento.FOTO_SUSTNT)
		enumMap.put(TipoDocumento.DOC_SUSTNT.getId(), TipoDocumento.DOC_SUSTNT)
		enumMap.put(TipoDocumento.DOC_REV.getId(), TipoDocumento.DOC_REV)
		return enumMap
	}
	
	public Integer getId() {
		return id
	}
	
	public String getClave() {
		return clave
	}
	
}