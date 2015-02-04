package mx.amib.sistemas.documentos.controller.rest

import java.util.Date;

import grails.converters.JSON
import grails.rest.RestfulController
import grails.transaction.Transactional
import mx.amib.sistemas.documentos.model.DocumentoPoder
import mx.amib.sistemas.documentos.model.DocumentoRevocacion

@Transactional(readOnly = false)
class DocumentoRevocacionRestfulController  extends RestfulController {

	static responseFormats = ['json', 'xml']
	
	DocumentoRevocacionRestfulController(){
		super(DocumentoRevocacion)
	}
	
	def updateByUuid(DocumentoRevocacion documentoRevocacion){
		HashMap<String,String> responseMap = new HashMap<String,String>()
		DocumentoRevocacion documentoRevToUpdate = DocumentoRevocacion.findByUuid(documentoRevocacion.uuid)
		
		if(documentoRevToUpdate != null){
			documentoRevToUpdate.fechaModificacion = new Date()
			documentoRevToUpdate.tipoDocumentoRespaldo = documentoRevocacion.tipoDocumentoRespaldo
			documentoRevToUpdate.representanteLegalNombreCompleto = documentoRevocacion.representanteLegalNombreCompleto
			documentoRevToUpdate.numeroEscritura = documentoRevocacion.numeroEscritura
			documentoRevToUpdate.fechaRevocacion = documentoRevocacion.fechaRevocacion
			documentoRevToUpdate.matriculasRevocados = documentoRevocacion.matriculasRevocados
			documentoRevToUpdate.nombresRevocados = documentoRevocacion.nombresRevocados
			documentoRevToUpdate.notario = documentoRevocacion.notario
			documentoRevToUpdate.grupoFinanciero = documentoRevocacion.grupoFinanciero
			documentoRevToUpdate.institucion = documentoRevocacion.institucion

			try{
				documentoRevToUpdate.save(flush:true)
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
