package mx.amib.sistemas.documentos.archivo.controller

import org.springframework.web.multipart.commons.CommonsMultipartFile
import mx.amib.sistemas.documentos.model.Documento
import mx.amib.sistemas.documentos.model.TipoDocumento
import mx.amib.sistemas.documentos.service.DocumentoService

class ArchivoDocumentoController {

	DocumentoService documentoService
	
	def testSubirArchivoDocumento()
	{
		
	}
	
    def subirArchivoDocumento(long id)
	{
		CommonsMultipartFile uploadFile = params.archivo
		documentoService.cargarArchivoDocumento(id, uploadFile.getBytes(), uploadFile.getContentType())
		render(status: 201, text: 'Se a cargado el archivo al documento con id: ${id}')
	}
	
	def subirArchivoDocumentoUuid()
	{
		CommonsMultipartFile uploadFile = params.archivo
		String uuid = params.uuid
		
		println "AQUI ENTRO #1"
		
		documentoService.cargarArchivoDocumento(uuid, uploadFile.getBytes(), uploadFile.getContentType())
		render(status: 201, text: 'Se a cargado el archivo al documento con uuid: ${uuid}')
	}
	
	def descargarArchivoDocumento(long id) {
		Documento docrep = documentoService.obtenerDocumento(id)
		
		if(docrep != null) {
			//response.setHeader("Content-disposition", "attachment; filename=tipoDocArchivo")
			response.contentType = docrep.getMimetype()
			response.outputStream << docrep.getDato()
			response.outputStream.flush()
			return
		}
	}
	
	def descargarArchivoDocumentoUuid() {
		String uuid = params.uuid
		Documento docrep = documentoService.obtenerDocumento(uuid)
		
		if(docrep != null) {
			//response.setHeader("Content-disposition", "attachment; filename=tipoDocArchivo")
			response.contentType = docrep.getMimetype()
			response.outputStream << docrep.getDato()
			response.outputStream.flush()
			return
		}
	}
	
}
