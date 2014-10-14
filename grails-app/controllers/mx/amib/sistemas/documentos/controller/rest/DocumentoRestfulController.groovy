package mx.amib.sistemas.documentos.controller.rest

import static org.springframework.http.HttpStatus.*
import grails.converters.JSON
import grails.rest.RestfulController
import grails.transaction.Transactional
import mx.amib.sistemas.documentos.model.Documento

@Transactional(readOnly = false)
class DocumentoRestfulController extends RestfulController {

	static responseFormats = ['json', 'xml']
	
	def documentoService
	
	DocumentoRestfulController(){
		super(Documento)
	}
	
	def getByUuid(){
		String uuid = params.uuid
		render documentoService.obtenerDocumento(uuid) as JSON
	}
	
	def deleteByUuid(){
		String uuid = params.uuid
		HashMap<String,String> responseMap = new HashMap<String,String>()
		
		eliminarDocumento(uuid)
		
		documentoService.responseMap.put("status","OK")
		
		render responseMap as JSON
	}
	
}
