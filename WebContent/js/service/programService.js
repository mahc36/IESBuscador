app.factory("programService", function($q, $http) {
	return {
		filter : function(){
			return $http.get('http://localhost:8080/IESBuscador/rest/services/filter').then(function(data){
				var receiveddata = angular.fromJson(data);			
				return receiveddata;
			}).catch(function(data){
				console.log(data);
			});
		},
		
		nameArea : 'ciencias'
	}
});
	