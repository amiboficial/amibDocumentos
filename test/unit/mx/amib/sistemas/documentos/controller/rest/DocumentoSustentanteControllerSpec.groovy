package mx.amib.sistemas.documentos.controller.rest

import static org.springframework.http.HttpStatus.*
import grails.rest.RestfulController
import grails.transaction.Transactional
import mx.amib.sistemas.documentos.model.DocumentoSustentante

@Transactional(readOnly = false)
class DocumentoSustentanteController extends RestfulController {

	static responseFormats = ['json', 'xml']
	
	DocumentoSustentanteController(){
		super(DocumentoSustentante)
	}
	
}
