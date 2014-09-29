<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>Subir archivo a documento</title>
</head>
<body>
  <div class="body">
  <g:uploadForm action="subirArchivoDocumento" id="1">
  	<input type="file" name="archivo" />
  	<fieldset class="buttons">
		<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
	</fieldset>
  </g:uploadForm>
  
  </div>
</body>
</html>