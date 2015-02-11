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
	
	def findAllByUuid(){
		String uuid = params.uuid?:''
		
		Integer max = 1
		Integer offset = 0
		String sort = "id"
		String order = "desc"
		
		HashMap<String,String> responseMap = new HashMap<String,String>()
		
		responseMap.put("max",max)
		responseMap.put("offset",offset)
		responseMap.put("sort",sort)
		responseMap.put("order",order)
		
		def result = documentoService.findAllByUuid(uuid)
		responseMap.put("count",result.count)
		responseMap.put("list",result.list)
		
		render responseMap as JSON
	}
	
	def findAllByMatricula(){
		Integer matricula = Integer.parseInt(params.matricula?:'-1')
		
		Integer max = Math.min(Integer.parseInt(params.max?:'10'), 100)
		Integer offset = Integer.parseInt(params.offset?:'0')
		String sort = params.sort?:"id"
		String order = params.order?:"desc"
		
		HashMap<String,String> responseMap = new HashMap<String,String>()
		
		responseMap.put("max",max)
		responseMap.put("offset",offset)
		responseMap.put("sort",sort)
		responseMap.put("order",order)
		
		def result = documentoService.findAllByMatricula(matricula,max,offset,sort,order)
		responseMap.put("count",result.count)
		responseMap.put("list",result.list)
		
		render responseMap as JSON
	}
	
	def findAllLikeNombreArchivo(){
		String nombreArchivo = params.nombreArchivo?:''
		
		Integer max = Math.min(Integer.parseInt(params.max?:'10'), 100)
		Integer offset = Integer.parseInt(params.offset?:'0')
		String sort = params.sort?:"id"
		String order = params.order?:"desc"
		
		HashMap<String,String> responseMap = new HashMap<String,String>()
		
		responseMap.put("max",max)
		responseMap.put("offset",offset)
		responseMap.put("sort",sort)
		responseMap.put("order",order)
		
		def result = documentoService.findAllLikeNombreArchivo(nombreArchivo,max,offset,sort,order)
		responseMap.put("count",result.count)
		responseMap.put("list",result.list)
		
		render responseMap as JSON
	}
	
	def findAllLikeDescripcion(){
		String descripcion = params.descripcion?:''
		
		Integer max = Math.min(Integer.parseInt(params.max?:'10'), 100)
		Integer offset = Integer.parseInt(params.offset?:'0')
		String sort = params.sort?:"id"
		String order = params.order?:"desc"
		
		HashMap<String,String> responseMap = new HashMap<String,String>()
		
		responseMap.put("max",max)
		responseMap.put("offset",offset)
		responseMap.put("sort",sort)
		responseMap.put("order",order)
		def result = documentoService.findAllLikeDescripcion(descripcion,max,offset,sort,order)
		responseMap.put("count",result.count)
		responseMap.put("list",result.list)
		
		render responseMap as JSON
	}
	
	def getByUuid(){
		String uuid = params.uuid
		render documentoService.obtenerDocumento(uuid) as JSON
	}
	
	def deleteByUuid(){
		String uuid = params.uuid
		HashMap<String,String> responseMap = new HashMap<String,String>()
		try
		{
			documentoService.eliminarDocumento(uuid)
			responseMap.put("status","OK")
		}
		catch(Exception e){
			responseMap.put("status","ERROR")
			responseMap.put("details",e.getMessage())
		}

		render responseMap as JSON
	}
	
}
