# JAX-WS-Tomcat
JAX-WS Gradle Example

Most of the times we want to deploy our services on a servlet container. So today we will learn how to create a web service and deploy it on Apache Tomcat server and then test it out with the client application.

**Steps**
1. Clone Project using below Github Project Link
2. Take Gradle Build, but if you see compile error for Client project then you have to create Client Stub with below steps
<pre>
a) Import the project into STS/Eclipse
b) Run Class  SOAPPublisher(com.java.webservice.jaxws.utils) from JAX-WS-ServiceProvider project. 
It will publish the service and create WSDL file under client/wsdl.
c) Run gradle task 'wsimport' which will create client stub classes under build/generated folder
d) Finally run gradle task 'genClientStub' which will generate client jar and copy it to JAX-WS-TomcatClient/ClientStub
</pre>
3. Deploy the war on Tomcat using generated under JAX-WS-ServiceProvider/build/lib directory
4. If all loos good, fire URL through browser -http://localhost:8080/JAX-WS-ServiceProvider/employeeWS



# GitHub Project
git@github.com:ImJavaDeveloper/JAX-WS-Tomcat.git
