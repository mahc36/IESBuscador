app.factory("personService", function($q, $http) {
	return {
		addPerson: function(person){			
			return $http.put('http://localhost:8080/IESBuscador/rest/personServices/addPerson/', person).then(function(data){
				var received=angular.fromJson(data);				
				return received;
			}).catch(function(data){
				console.log(data);
			});
		}
	}
	
});