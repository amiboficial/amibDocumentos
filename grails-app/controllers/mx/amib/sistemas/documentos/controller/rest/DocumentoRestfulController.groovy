package mx.amib.sistemas.documentos.controller.rest

import static org.springframework.http.HttpStatus.*
import grails.rest.RestfulController
import grails.transaction.Transactional
import mx.amib.sistemas.documentos.model.Documento

@Transactional(readOnly = false)
class DocumentoRestfulController extends RestfulController {

	static responseFormats = ['json', 'xml']
	
	DocumentoRestfulController(){
		super(Documento)
	}
	
}
