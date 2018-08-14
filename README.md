###Localstack and list version issue

####Start localstack
git clone https://github.com/localstack/localstack.git

cd localstack

docker-compose up

####Create bucket and upload objects
./createBucketExample.sh

####Launch application
mvn clean package

java -jar target/demo-0.0.1-SNAPSHOT.jar

####Error message
You should see the following error message : 

    DEBUG [com.amazonaws.services.s3.internal.S3ErrorResponseHandler] Failed in parsing the error response : <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
    <title>500 Internal Server Error</title>
    <h1>Internal Server Error</h1>
    <p>The server encountered an internal error and was unable to complete your request.  Either the server is overloaded or there is an error in the application.</p>
 
    javax.xml.stream.XMLStreamException: ParseError at [row,col]:[1,55]
    Message: Des espaces sont obligatoires entre les ID publicId et systemId.
	at com.sun.org.apache.xerces.internal.impl.XMLStreamReaderImpl.next(XMLStreamReaderImpl.java:604)
	at com.amazonaws.services.s3.internal.S3ErrorResponseHandler.createException(S3ErrorResponseHandler.java:115)
	at com.amazonaws.services.s3.internal.S3ErrorResponseHandler.handle(S3ErrorResponseHandler.java:64)
	at com.amazonaws.services.s3.internal.S3ErrorResponseHandler.handle(S3ErrorResponseHandler.java:51)
	at com.amazonaws.http.AwsErrorResponseHandler.handleAse(AwsErrorResponseHandler.java:50)
	at com.amazonaws.http.AwsErrorResponseHandler.handle(AwsErrorResponseHandler.java:38)
	at com.amazonaws.http.AwsErrorResponseHandler.handle(AwsErrorResponseHandler.java:24)
	

Would there be any issue will the following URL? 

    DEBUG [org.apache.http.wire] http-outgoing-0 >> "GET /my-example/?versions&prefix=example%2Fexample0.txt&encoding-type=url HTTP/1.1[\r][\n]" 
    DEBUG [org.apache.http.wire] http-outgoing-0 >> "Host: localhost:4572[\r][\n]" 