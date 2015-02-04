package mx.amib.sistemas.documentos.controller.rest

import static org.springframework.http.HttpStatus.*

import java.util.Date;

import grails.converters.JSON
import grails.rest.RestfulController
import grails.transaction.Transactional
import mx.amib.sistemas.documentos.model.DocumentoPoder

@Transactional(readOnly = false)
class DocumentoPoderRestfulController extends RestfulController {

	static responseFormats = ['json', 'xml']
	
	DocumentoPoderRestfulController(){
		super(DocumentoPoder)
	}
	
	def updateByUuid(DocumentoPoder documentoPoder){
		HashMap<String,String> responseMap = new HashMap<String,String>()
		DocumentoPoder documentoPoderToUpdate = DocumentoPoder.findByUuid(documentoPoder.uuid)
		
		if(documentoPoderToUpdate != null){
			documentoPoderToUpdate.fechaModificacion = new Date()
			documentoPoderToUpdate.tipoDocumentoRespaldo = documentoPoder.tipoDocumentoRespaldo
			documentoPoderToUpdate.representanteLegalNombreCompleto = documentoPoder.representanteLegalNombreCompleto
			documentoPoderToUpdate.numeroEscritura = documentoPoder.numeroEscritura 
			documentoPoderToUpdate.fechaApoderamiento = documentoPoder.fechaApoderamiento
			documentoPoderToUpdate.matriculasApoderados = documentoPoder.matriculasApoderados
			documentoPoderToUpdate.nombresApoderados = documentoPoder.nombresApoderados
			documentoPoderToUpdate.notario = documentoPoder.notario
			documentoPoderToUpdate.grupoFinanciero = documentoPoder.grupoFinanciero
			documentoPoderToUpdate.institucion = documentoPoder.institucion
			try{
				documentoPoderToUpdate.save(flush:true)
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
