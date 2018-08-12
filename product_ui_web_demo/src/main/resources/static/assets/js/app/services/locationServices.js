/**
 * @author manikanta.nsk
 */

productApp.service("locationService",['$http',function($http){
	
	this.getAllLocations = function() { 
		return new Promise(function(resolve,reject){
			
			$http.get('https://inmardemo.cfapps.io/api/v1/location').then(
				function(response){
					resolve(response.data);
					
				},
				function(error){
					console.log("No data found / Connection error");
					reject([]);
				});
		});
		}
	
	
	this.getLocationById = function(id){
		
		return new Promise(function(resolve,reject){
			
			$http.get('https://inmardemo.cfapps.io/api/v1/location/{'+id+'}/department').then(
				function(response){
					resolve(response.data);
				},
				function(error){
					console.log("No data found / Connection error");
					reject([]);
				});
			
		});
		
	}
	//save locations
	this.postLocations = function(data){
		
		return new Promise(function(resolve,reject){
			
			$http.post('https://inmardemo.cfapps.io/api/v1/location/addLocations',data).then(
				function(response){
					resolve(response.data);
				},
				function(error){
					console.log("Unable to insert data / Connection error");
					reject([]);
				});
			
		});
		
	}
	
	
	//update locations
		this.updateLocations = function(data){
			
			return new Promise(function(resolve,reject){
				
				$http.post('https://inmardemo.cfapps.io/api/v1/location/updateLocations',data).then(
					function(response){
						resolve(response.data);
					},
					function(error){
						console.log("Unable to insert data / Connection error");
						reject([]);
					});
				
			});
			
		}
		
		
		//delete locations
				this.deleteLocation = function(id){
					
					return new Promise(function(resolve,reject){
						
						$http.delete('https://inmardemo.cfapps.io/api/v1/location/'+id+'/department').then(
							function(response){
								resolve(response.data);
							},
							function(error){
								console.log("Unable to insert data / Connection error");
								reject([]);
							});
						
					});
					
				}
	

}]);