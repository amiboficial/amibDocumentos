package mx.amib.sistemas.documentos.service

import grails.transaction.Transactional

import mx.amib.sistemas.documentos.model.TipoDocumento
import mx.amib.sistemas.documentos.model.Documento

import mx.amib.sistemas.documentos.model.CnbvDgaOficio
import mx.amib.sistemas.documentos.model.DocumentoPoder
import mx.amib.sistemas.documentos.model.DocumentoSustentante
import mx.amib.sistemas.documentos.model.FotoSustenante

@Transactional
class DocumentoService {

	//Obtiene instancia de documento
    Documento obtenerDocumento(long id) {
		return Documento.get(id)
    }
	
	//Guarda los metadatos de un documento (independientemente del tipo)
	void guardarMetadatosDocumento(Documento doc){
		Documento docToSave = Documento.get(doc.getId())
		
		if(docToSave == null){
			if(doc instanceof CnbvDgaOficio){
				docToSave = new CnbvDgaOficio()
			}
			else if(doc instanceof DocumentoPoder){
				docToSave = new DocumentoPoder()
			}
			else if(doc instanceof DocumentoSustentante){
				docToSave = new DocumentoSustentante()
			}
			else if(doc instanceof FotoSustenante){
				docToSave = new FotoSustenante()
			}
			else{
				doc = new Documento()
			}
		}
		
		docToSave.dato = null
		docToSave.clave = doc.clave
		docToSave.mimetype = doc.mimetype
		docToSave.fechaModificacion = doc.fechaModificacion
		docToSave.fechaCreacion = doc.fechaCreacion
		
		docToSave.save(flush:true)
	}
		
	//Carga un archivo para determinado Documento
	void cargarArchivoDocumento(long id, byte[] archivo, String mimetype) {
		Documento docrep = Documento.get(id)
		
		docrep.dato = archivo
		docrep.mimetype = mimetype
		
		docrep.save(flush: true)
	}
	
}