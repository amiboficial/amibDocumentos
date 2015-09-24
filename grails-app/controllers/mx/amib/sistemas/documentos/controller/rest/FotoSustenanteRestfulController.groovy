package mx.amib.sistemas.documentos.controller.rest

import static org.springframework.http.HttpStatus.*
import grails.converters.JSON
import grails.rest.RestfulController
import grails.transaction.Transactional
import mx.amib.sistemas.documentos.model.FotoSustenante;
import mx.amib.sistemas.documentos.model.FotoSustenante

@Transactional(readOnly = false)
class FotoSustenanteRestfulController extends RestfulController {

	static responseFormats = ['json', 'xml']
	
	FotoSustenanteRestfulController(){
		super(FotoSustenante)
	}
	
	def updateByUuid(FotoSustenante fotoSustenante){
		HashMap<String,String> responseMap = new HashMap<String,String>()
		FotoSustenante fotoSustenanteToUpdate = FotoSustenante.findByUuid(fotoSustenante.uuid)
		
		if(fotoSustenanteToUpdate != null){
			fotoSustenanteToUpdate.fechaModificacion = new Date()
			fotoSustenanteToUpdate.numeroMatricula = fotoSustenante.numeroMatricula
			fotoSustenanteToUpdate.nombreCompleto = fotoSustenante.nombreCompleto
			
			try{
				fotoSustenanteToUpdate.save(flush:true)
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
