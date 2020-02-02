package com.java.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.java.handler.apigateway.RequestController;

public class ComponentHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent>{
	private static final String COMPONENT_NAME = "Component";
    private static final String API_VERSION = "v1";
    
    
	@Override
	public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
		RequestController controller =
	            new RequestController(
	                input,
	                context, COMPONENT_NAME + " " + API_VERSION);
	        return controller.handle();
	}

    
}
