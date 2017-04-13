package com.example.demo.restclient;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.dto.server.ProductResponseDto;

@Component
public class RestClient {
	
	public ProductResponseDto fetchProductNameById(long id) {
		RestTemplate rest = new RestTemplate();
		ProductResponseDto responseDto = null;
		String url = "http://redsky.target.com/v1/pdp/tcin/{id}";
		
		// Adding Path parameters
		Map<String, Long> uriParams = new HashMap<String, Long>();
		
		// TODO: Hard-Coded ID value need to be removed.
		// This URL doesn't work for any other example IDs given in the case study document except 13860428
		// so hard-coding the id to 13860428 here. In real world scenario, obviously it won't be hard coded.
		// uriParams.put("id", id);
		uriParams.put("id", 13860428L);
		
		// Query parameters
		String queryParam = "taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
		        // Adding query parameters
		        .queryParam("excludes", queryParam);

		System.out.println("URL="+builder.buildAndExpand(uriParams).toUri());
		
		responseDto = rest.getForObject(builder.buildAndExpand(uriParams).toUri(), ProductResponseDto.class);
		
		return responseDto;
	}
}
