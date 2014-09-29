package mx.amib.sistemas.documentos.controller.rest

import static org.springframework.http.HttpStatus.*
import grails.rest.RestfulController
import grails.transaction.Transactional
import mx.amib.sistemas.documentos.model.DocumentoSustentante

@Transactional(readOnly = false)
class DocumentoSustentanteRestfulController extends RestfulController {

	static responseFormats = ['json', 'xml']
	
	DocumentoSustentanteRestfulController(){
		super(DocumentoSustentante)
	}
	
}
