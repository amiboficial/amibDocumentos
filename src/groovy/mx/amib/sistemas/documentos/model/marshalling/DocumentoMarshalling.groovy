package mx.amib.sistemas.documentos.model.marshalling

import java.util.Date;

import grails.converters.JSON
import mx.amib.sistemas.documentos.model.CnbvDgaOficio
import mx.amib.sistemas.documentos.model.Documento
import mx.amib.sistemas.documentos.model.DocumentoPoder
import mx.amib.sistemas.documentos.model.DocumentoSustentante
import mx.amib.sistemas.documentos.model.FotoSustenante

class DocumentoMarshalling {
	void register(){
		JSON.registerObjectMarshaller(Documento){ Documento documentoRepositorio ->
			return [
				id: documentoRepositorio.id,
				uuid: documentoRepositorio.uuid,
				nombre: documentoRepositorio.nombre,
				clave: documentoRepositorio.clave,
				mimetype: documentoRepositorio.mimetype,
				fechaModificacion: documentoRepositorio.fechaModificacion,
				fechaCreacion: documentoRepositorio.fechaCreacion
			]
		}
	}
}

class CnbvDgaOficioMarshalling {
	void register(){
		JSON.registerObjectMarshaller(CnbvDgaOficio){ CnbvDgaOficio doc ->
			return [
				id: doc.id,
				uuid: doc.uuid,
				nombre: doc.nombre,
				clave: doc.clave,
				mimetype: doc.mimetype,
				datosAdicionales: doc.datosAdicionales,
				fechaModificacion: doc.fechaModificacion,
				fechaCreacion: doc.fechaCreacion
			]
		}
	}
}

class DocumentoPoderMarshalling {
	void register(){
		JSON.registerObjectMarshaller(DocumentoPoder){ DocumentoPoder doc ->
			return [
				id: doc.id,
				uuid: doc.uuid,
				nombre: doc.nombre,
				clave: doc.clave,
				mimetype: doc.mimetype,
				fechaModificacion: doc.fechaModificacion,
				fechaCreacion: doc.fechaCreacion,
				
				tipoDocumentoRespaldo: doc.tipoDocumentoRespaldo,
				representanteLegalNombre: doc.representanteLegalNombre,
				representanteLegalApellido1: doc.representanteLegalApellido1,
				representanteLegalApellido2: doc.representanteLegalApellido2,
				esRegistradoPorGrupoFinanciero: doc.esRegistradoPorGrupoFinanciero,
				numeroEscritura: doc.numeroEscritura,
				fechaApoderamiento: doc.fechaApoderamiento,
				jsonApoderados: doc.jsonApoderados,
				jsonNotario: doc.jsonNotario,
				jsonGrupoFinanciero: doc.jsonGrupoFinanciero,
				jsonInstitucion: doc.jsonInstitucion
			]
		}
	}
}

class FotoSustenanteMarshalling {
	void register(){
		JSON.registerObjectMarshaller(FotoSustenante){ FotoSustenante doc ->
			return [
				id: doc.id,
				uuid: doc.uuid,
				nombre: doc.nombre,
				clave: doc.clave,
				mimetype: doc.mimetype,
				numeroMatricula: doc.numeroMatricula,
				fechaModificacion: doc.fechaModificacion,
				fechaCreacion: doc.fechaCreacion
			]
		}
	}
}

class DocumentoSustentanteMarshalling {
	void register(){
		JSON.registerObjectMarshaller(DocumentoSustentante){ DocumentoSustentante doc ->
			return [
				id: doc.id,
				uuid: doc.uuid,
				nombre: doc.nombre,
				clave: doc.clave,
				mimetype: doc.mimetype,
				numeroMatricula: doc.numeroMatricula,
				tipoDocumentoSustentante: doc.tipoDocumentoSustentante,
				fechaModificacion: doc.fechaModificacion,
				fechaCreacion: doc.fechaCreacion
			]
		}
	}
}
