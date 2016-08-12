# Define rest servlet in web.xml
## Enable the Rest support in web.xml
	Register the servlet com.sun.jersey.spi.container.servlet.ServletContainer
	

## Define the package which content the rest resource
		<init-param>
			<param-name>com.sun.jersey.config.property.packages</param-name>
			<param-value>com.sudhir.service</param-value>
		</init-param>
		

## Uas jackson based json to java marshling(as opposed to JAXB)
		<init-param>
			<param-name>com.sun.jersey.api.json.POJOMappingFeature</param-name>
			<param-value>true</param-value>
		</init-param>
## Declare the Service as rest using @Path