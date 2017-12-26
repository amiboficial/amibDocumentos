package mx.amib.sistemas.documentos.service

import grails.transaction.Transactional
import mx.amib.sistemas.documentos.model.TipoDocumento
import mx.amib.sistemas.documentos.model.Documento
import mx.amib.sistemas.documentos.model.CnbvDgaOficio
import mx.amib.sistemas.documentos.model.DocumentoBlob
import mx.amib.sistemas.documentos.model.DocumentoPoder
import mx.amib.sistemas.documentos.model.DocumentoRevocacion
import mx.amib.sistemas.documentos.model.DocumentoSustentante
import mx.amib.sistemas.documentos.model.FotoSustenante
import mx.amib.sistemas.documentos.model.readonly.DocumentoDescripciones
import mx.amib.sistemas.documentos.model.readonly.DocumentoMatricula

@Transactional
class DocumentoService {
	class SearchResult {
		def list
		def count
	}
	
	SearchResult findAllByUuid(String uuid){
		SearchResult sr = new SearchResult()
		sr.count = 1
		sr.list = Documento.findAllByUuid(uuid)
		return sr
	}
	
	SearchResult findAllByUuidList(List<String> uuids){
		SearchResult sr = new SearchResult()
		
		sr.list = Documento.findAllByUuidInList(uuids)
		sr.count = sr.list.size()
		
		return sr
	}
	
	SearchResult findAllGeneric(Integer max, Integer offset, String sort, String order){
		SearchResult sr = new SearchResult()
		
		if(sort == null || sort == ""){
			sort = "id"
		}
		else if(["id","nombre","mimetype","fechaModificacion","fechaCreacion"].find{ sort == it } == null){
			sort = "id"
		}
		if(order == null || order == ""){
			order = "asc"
		}
		else if(order != "desc" && order != "asc"){
			order = "asc"
		}

		sr.count = DocumentoMatricula.executeQuery("select count(d) from Documento as d where d.idTipo = :idTipo",[idTipo:TipoDocumento.NOT_TYPE.getId()])[0]
		sr.list = Documento.findAllByIdTipo(TipoDocumento.NOT_TYPE.getId(),[max: max, offset: offset, sort:sort, order:order])
		
		return sr
	}
	
	SearchResult findAllByType(Integer idTipo,Integer max, Integer offset, String sort, String order){
		TipoDocumento td = TipoDocumento.getMap().get(idTipo)
		SearchResult sr = new SearchResult()
		
		if(sort == null || sort == ""){
			sort = "id"
		}
		else if(["id","nombre","mimetype","fechaModificacion","fechaCreacion"].find{ sort == it } == null){
			sort = "id"
		}
		if(order == null || order == ""){
			order = "asc"
		}
		else if(order != "desc" && order != "asc"){
			order = "asc"
		}

		sr.count = DocumentoMatricula.executeQuery("select count(d) from Documento as d where d.idTipo = :idTipo",[idTipo:td.getId()])[0]
		sr.list = Documento.findAllByIdTipo(td.getId(),[max: max, offset: offset, sort:sort, order:order])
		
		return sr
	}
	
	SearchResult findAllByMatricula(Integer numeroMatricula, Integer max, Integer offset, String sort, String order){
		SearchResult sr = new SearchResult()
		String matriculaToFind = "%" + numeroMatricula + ";%"
		
		if(sort == null || sort == ""){
			sort = "id"
		}
		else if(["id","nombre","mimetype","fechaModificacion","fechaCreacion"].find{ sort == it } == null){
			sort = "id"
		}
		if(order == null || order == ""){
			order = "asc"
		}
		else if(order != "desc" && order != "asc"){
			order = "asc"
		}

		sr.count = DocumentoMatricula.executeQuery("select count(dm) from DocumentoMatricula as dm where dm.matriculas like :matricula",[matricula:matriculaToFind])[0]
		def idList = DocumentoMatricula.executeQuery("select dm.id from DocumentoMatricula as dm where dm.matriculas like :matricula",[matricula:matriculaToFind])
		sr.list = Documento.findAllByIdInList(idList,[max: max, offset: offset, sort:sort, order:order])
		
		return sr
	}
	
	SearchResult findAllLikeNombreArchivo(String nombreArchivo, Integer max, Integer offset, String sort, String order){
		SearchResult sr = new SearchResult()
		String nombreToFind = "%" + nombreArchivo + "%"
		
		if(sort == null || sort == ""){
			sort = "id"
		}
		else if(["id","nombre","mimetype","fechaModificacion","fechaCreacion"].find{ sort == it } == null){
			sort = "id"
		}
		if(order == null || order == ""){
			order = "asc"
		}
		else if(order != "desc" && order != "asc"){
			order = "asc"
		}
				
		sr.count = Documento.executeQuery("select count(d) from Documento as d where d.nombre like :nombre",[nombre:nombreToFind])[0]
		sr.list = Documento.findAllByNombreLike(nombreToFind,[max:max,offset:offset,sort:sort,order:order])
		
		return sr
	}
	
	SearchResult findAllLikeDescripcion(String descripcion, Integer max, Integer offset, String sort, String order){
		SearchResult sr = new SearchResult()
		String descripcionToFind = "%" + descripcion + "%"
		
		if(sort == null || sort == ""){
			sort = "id"
		}
		else if(["id","nombre","mimetype","fechaModificacion","fechaCreacion"].find{ sort == it } == null){
			sort = "id"
		}
		if(order == null || order == ""){
			order = "asc"
		}
		else if(order != "desc" && order != "asc"){
			order = "asc"
		}
		
		sr.count = DocumentoDescripciones.executeQuery("select count(dd) from DocumentoDescripciones as dd where lower(dd.descripcion1) like lower(:desc) or lower(dd.descripcion2) like lower(:desc) or lower(dd.descripcion3) like lower(:desc) or lower(dd.descripcion4) like lower(:desc) or lower(dd.descripcion5) like lower(:desc) or lower(dd.descripcion6) like lower(:desc)",[desc:descripcionToFind])[0]
		def idList = DocumentoDescripciones.executeQuery("select dd.id from DocumentoDescripciones as dd where lower(dd.descripcion1) like lower(:desc) or lower(dd.descripcion2) like lower(:desc) or lower(dd.descripcion3) like lower(:desc) or lower(dd.descripcion4) like lower(:desc) or lower(dd.descripcion5) like lower(:desc) or lower(dd.descripcion6) like lower(:desc)",[desc:descripcionToFind])
		sr.list = Documento.findAllByIdInList(idList,[max: max, offset: offset, sort:sort, order:order])

		return sr
	}
	
	//Obtiene instancia de documento
    Documento obtenerDocumento(long id) {
		return Documento.get(id)
    }
	
	//Obtiene instancia de documento usando UUID
	Documento obtenerDocumento(String uuid) {
		return Documento.findByUuid(uuid)
	}
	
	//Obtiene instancia de documento con datos binarios
	DocumentoBlob obtenerDocumentoBlob(long id) {
		return DocumentoBlob.get(id)
	}
	
	//Obtiene instancia de documento usando UUID con datos binarios
	DocumentoBlob obtenerDocumentoBlob(String uuid) {
		return DocumentoBlob.findByUuid(uuid)
	}
	
	
	//Guarda los metadatos de un documento (independientemente del tipo)
	void guardarMetadatosDocumento(Documento doc){
		Documento docToSave = Documento.get(doc.getId())
		
		if(docToSave == null){
			if(doc instanceof CnbvDgaOficio){
				docToSave = new CnbvDgaOficio()
				docToSave.idTipo = TipoDocumento.CNBV_DGA_OFICIO.getId()
			}
			else if(doc instanceof DocumentoPoder){
				docToSave = new DocumentoPoder()
				docToSave.idTipo = TipoDocumento.DOC_PODER.getId()
			}
			else if(doc instanceof DocumentoRevocacion){
				docToSave = new DocumentoPoder()
				docToSave.idTipo = TipoDocumento.DOC_REV.getId()
			}
			else if(doc instanceof FotoSustenante){
				docToSave = new FotoSustenante()
				docToSave.idTipo = TipoDocumento.FOTO_SUSTNT.getId()
			}
			else if(doc instanceof DocumentoSustentante){
				docToSave = new DocumentoSustentante()
				docToSave.idTipo = TipoDocumento.DOC_SUSTNT.getId()
			}
			
			else{
				doc = new Documento()
				docToSave.idTipo = TipoDocumento.NOT_TYPE.getId()
			}
		}
		docToSave.clave = doc.clave
		docToSave.mimetype = doc.mimetype
		docToSave.fechaModificacion = doc.fechaModificacion
		docToSave.fechaCreacion = doc.fechaCreacion
		
		docToSave.save(flush:true)
	}
		
	void eliminarDocumento(String uuid){
		Documento docInstance = Documento.findByUuid(uuid)
		docInstance.delete flush:true
	}
	
	//Carga un archivo para determinado Documento
	void cargarArchivoDocumento(long id, byte[] archivo, String mimetype) {
		DocumentoBlob docrep = DocumentoBlob.get(id)
		if(docrep == null){
			docrep = new DocumentoBlob()
		}
		docrep.dato = archivo
		//docrep.mimetype = mimetype
		
		docrep.save(flush: true)
	}
	
	//Carga un archivo para determinado Documento usando UUID
	void cargarArchivoDocumento(String uuid, byte[] archivo, String mimetype) {
		DocumentoBlob docrep = DocumentoBlob.findByUuid(uuid)
		if(docrep == null){
			docrep = new DocumentoBlob()
		}
		docrep.dato = archivo
		//docrep.mimetype = mimetype
		
		docrep.save(flush: true)
	}
	
}