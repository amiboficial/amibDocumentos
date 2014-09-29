package mx.amib.sistemas.documentos.controller.rest

import static org.springframework.http.HttpStatus.*
import grails.rest.RestfulController
import grails.transaction.Transactional
import mx.amib.sistemas.documentos.model.FotoSustenante

@Transactional(readOnly = false)
class FotoSustenanteRestfulController extends RestfulController {

	static responseFormats = ['json', 'xml']
	
	FotoSustenanteRestfulController(){
		super(FotoSustenante)
	}
	
}
