package com.raremile.tutorial.restinvoker;

import java.lang.reflect.Type;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SpringRestInvoker {

	public static void invokeRest(String urlStr) {

		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject(urlStr, String.class);

		System.out.println("Response : " + response);

		Gson gson = new Gson();
		Type stringStringMap = new TypeToken<Map<String, String>>() {
		}.getType();
		Map<String, String> map = gson.fromJson(response, stringStringMap);
		System.out.println("Response map : "+map);

	}

	public static void main(String args[]) {

		System.out.println("Invoking rest...");

		SpringRestInvoker.invokeRest("http://graph.facebook.com/balaji.mx");

	}

}
