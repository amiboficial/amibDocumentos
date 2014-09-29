class BootStrap {

    def init = { servletContext ->
		// Get spring
		def springContext = org.springframework.web.context.support.WebApplicationContextUtils.getWebApplicationContext( servletContext );
		springContext.getBean( "customObjectMarshallers" ).register();
    }
    def destroy = {
    }
}
