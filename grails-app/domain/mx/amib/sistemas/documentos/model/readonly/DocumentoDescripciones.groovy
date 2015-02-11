package mx.amib.sistemas.documentos.model.readonly

import mx.amib.sistemas.documentos.model.Documento

class DocumentoDescripciones {
	String descripcion1
	String descripcion2
	String descripcion3
	String descripcion4
	String descripcion5
	String descripcion6
	
	static mapping = {
		table 'v004_v_docdesc'
		
		descripcion1 column:'tx_desc01'
		descripcion2 column:'tx_desc02'
		descripcion3 column:'tx_desc03'
		descripcion4 column:'tx_desc04'
		descripcion5 column:'tx_desc05'
		descripcion6 column:'tx_desc06'
		
		version false
	}
}
