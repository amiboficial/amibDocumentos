package mx.amib.sistemas.documentos.controller.rest

import static org.springframework.http.HttpStatus.*
import grails.rest.RestfulController
import grails.transaction.Transactional
import mx.amib.sistemas.documentos.model.DocumentoPoder

@Transactional(readOnly = false)
class DocumentoPoderRestfulController extends RestfulController {

	static responseFormats = ['json', 'xml']
	
	DocumentoPoderRestfulController(){
		super(DocumentoPoder)
	}
	
}
