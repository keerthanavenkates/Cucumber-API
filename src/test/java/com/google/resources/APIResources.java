package com.google.resources;

public enum APIResources {
	
	//collection of constants or collection of methods
	
	addPlaceapi("/maps/api/place/add/json"),
	getPlaceapi("/maps/api/place/get/json"),
	deletePlaceapi("/maps/api/place/delete/json");
	
	private String resources;
	
	APIResources(String resources){
		this.resources = resources;
		
	}	public String getResource(){
			return resources;
			
			
		}
		
}
