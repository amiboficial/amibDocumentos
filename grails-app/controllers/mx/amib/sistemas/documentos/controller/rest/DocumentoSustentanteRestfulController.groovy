package mx.amib.sistemas.documentos.controller.rest

import static org.springframework.http.HttpStatus.*
import grails.converters.JSON
import grails.rest.RestfulController
import grails.transaction.Transactional
import mx.amib.sistemas.documentos.model.DocumentoRevocacion;
import mx.amib.sistemas.documentos.model.DocumentoSustentante

@Transactional(readOnly = false)
class DocumentoSustentanteRestfulController extends RestfulController {

	static responseFormats = ['json', 'xml']
	
	DocumentoSustentanteRestfulController(){
		super(DocumentoSustentante)
	}
	
	def updateByUuid(DocumentoSustentante documentoSustentante){
		HashMap<String,String> responseMap = new HashMap<String,String>()
		DocumentoSustentante documentoSustentanteToUpdate = DocumentoSustentante.findByUuid(documentoSustentante.uuid)
		
		if(documentoSustentanteToUpdate != null){
			documentoSustentanteToUpdate.fechaModificacion = new Date()
			documentoSustentanteToUpdate.numeroMatricula = documentoSustentante.numeroMatricula
			documentoSustentanteToUpdate.tipoDocumentoSustentante = documentoSustentante.tipoDocumentoSustentante
			documentoSustentanteToUpdate.nombreCompleto = documentoSustentante.nombreCompleto
			
			try{
				documentoSustentanteToUpdate.save(flush:true)
				responseMap.put("status","OK")
			}
			catch(Exception e){
				responseMap.put("status","ERROR")
				responseMap.put("details",e.getMessage())
			}
		}
		else{
			responseMap.put("status","NOT_FOUND")
		}
		
		render responseMap as JSON
	}
}
