package mx.amib.sistemas.documentos.model.readonly

import mx.amib.sistemas.documentos.model.Documento

class DocumentoMatricula extends Documento {
	String matriculas
	
	static mapping = {
		table 'v003_v_docmatricula'
		
		matriculas column:'tx_matriculas'
		
		version false
	}
}
