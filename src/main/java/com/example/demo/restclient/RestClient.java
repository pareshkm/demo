package com.example.demo.restclient;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.dto.server.DeepRedLabelsServerDto;
import com.example.demo.dto.server.ItemServerDto;
import com.example.demo.dto.server.ProductDescriptionServerDto;
import com.example.demo.dto.server.ProductServerDto;

@Component
public class RestClient {
	
	public ProductServerDto fetchProductNameById(long id) {
		RestTemplate rest = new RestTemplate();
		ProductServerDto productDto = null;
		String url = "http://redsky.target.com/v1/pdp/tcin/{id}";
		
		// Adding Path parameters
		Map<String, String> uriParams = new HashMap<String, String>();
		// TODO: Remove hard coding of id after done with testing
		// uriParams.put("id", id+"");
		uriParams.put("id", "13860428");
		
		// Query parameters
		String queryParam = "taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
		        // Adding query parameters
		        .queryParam("excludes", queryParam);

		System.out.println("URL="+builder.buildAndExpand(uriParams).toUri());
		
		productDto = rest.getForObject(builder.buildAndExpand(uriParams).toUri(), ProductServerDto.class);
		if ( productDto == null ) {
			System.out.println("In RestClient productDto is null");
		} else {
			System.out.println("In RestClient productDto is not null");
			ItemServerDto item = productDto.getItem();
			if ( item == null ) {
				System.out.println("Item is null");
			} else {
				System.out.println("Item is not null");
				ProductDescriptionServerDto product_description = item.getProduct_description();
				String title = product_description.getTitle();
				if ( title == null ) {
					System.out.println("title is null");
				} else {
					System.out.println("title is not null, title="+title);
				}
			}
			
		}
		System.out.println("**************************");
		System.out.println("**************************");
		return productDto;
	}

}
