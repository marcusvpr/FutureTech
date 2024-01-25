Primefaces Pandora - SaudeMedidaCerta
=====================================
. Author: Marcus VPR (FUTURE TECH) ;
. Level: Consultor TI (Lider Técnico) ;
. Technologies: JSF Primefaces Premium Pandora + DB H2 + IA ;
. Summary: Aplicativo para auxiliar pessoas gestoras de Idodos/Dependentes Físicos ;  
. Target Product: Tomcat ;
. Read more: https://www.futuretech-coop.com.br/web/primefaces/ftSaudeCerta.html/ ;
. Primefaces Theme Preminum Padora: https://www.primefaces.org/pandora/documentation.xhtml ;
	(sass --update src/main/webapp/resources:src/main/webapp/resources --no-source-map)

Access the application 
----------------------
. The application will be running at the following URL: <http://localhost:8080/>. 
. Gerar jar : mvn clean package
. java -jar mpSaudeMedidaCerta-1.0.0.jar

Docker 
----------------------
docker container run -p 80:80 ngix 