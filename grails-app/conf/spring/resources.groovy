import mx.amib.sistemas.documentos.model.marshalling.DocumentoMarshalling

// Place your Spring DSL code here
beans = {
	customObjectMarshallers( mx.amib.sistemas.documentos.model.marshalling.CustomObjectMarshallers ) {
		marshallers = [
				new mx.amib.sistemas.documentos.model.marshalling.DocumentoMarshalling(),
				new mx.amib.sistemas.documentos.model.marshalling.CnbvDgaOficioMarshalling(),
				new mx.amib.sistemas.documentos.model.marshalling.DocumentoPoderMarshalling(),
				new mx.amib.sistemas.documentos.model.marshalling.DocumentoRevocacionMarshalling(),
				new mx.amib.sistemas.documentos.model.marshalling.FotoSustenanteMarshalling(),
				new mx.amib.sistemas.documentos.model.marshalling.DocumentoSustentanteMarshalling()
		]
	}
}
