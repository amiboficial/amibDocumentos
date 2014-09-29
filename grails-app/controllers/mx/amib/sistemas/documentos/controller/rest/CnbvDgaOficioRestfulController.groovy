package mx.amib.sistemas.documentos.controller.rest

import static org.springframework.http.HttpStatus.*
import grails.rest.RestfulController
import grails.transaction.Transactional
import mx.amib.sistemas.documentos.model.CnbvDgaOficio

@Transactional(readOnly = false)
class CnbvDgaOficioRestfulController extends RestfulController {

	static responseFormats = ['json', 'xml']
	
	CnbvDgaOficioRestfulController(){
		super(CnbvDgaOficio)
	}
	
}
