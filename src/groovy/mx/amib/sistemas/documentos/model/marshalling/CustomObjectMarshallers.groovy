package mx.amib.sistemas.documentos.model.marshalling

import java.util.List;

class CustomObjectMarshallers {
	List marshallers = []
	
	def register() {
		marshallers.each{ it.register() }
	}
}
