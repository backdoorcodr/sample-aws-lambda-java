package com.java.handler.apigateway;

import java.util.Collections;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.java.handler.util.HttpResponseStatus;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class RequestController {
	  private final APIGatewayProxyRequestEvent input;
	  private final Context context;
	  private final String dummyInput;
	  
	  public APIGatewayProxyResponseEvent handle() {
		    return execute();
		  }

	private APIGatewayProxyResponseEvent execute() {
		log.info("request : {}", input);
		log.info("context : {}", context);
		String dummyBodyContent = context.getAwsRequestId() + " " + input.getBody() + " " + dummyInput;
		APIGatewayProxyResponseEvent apiGatewayProxyResponseEvent = buildResponse(HttpResponseStatus.OK.getStatusCode(), 
				dummyBodyContent);
		return apiGatewayProxyResponseEvent;
	}
	
	  private <U> APIGatewayProxyResponseEvent buildResponse(int status, String bodyContent) {
		    return new APIGatewayProxyResponseEvent()
		        .withStatusCode(status)
		        .withBody(bodyContent)
		        .withHeaders(Collections.emptyMap());
		  }

}
