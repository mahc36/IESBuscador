app.controller("personCtrl", ["$scope",  "personService", function personCtrl($scope, personService) {
	
	$scope.personForm={};
	$scope.personForm.id="";
	$scope.addPerson=function(personForm){
		if(angular.isUndefined(personForm.name) || angular.isUndefined(personForm.email) || angular.isUndefined(personForm.password) || angular.isUndefined(personForm.confirmPassword)){
			return;
		}
		else{
			if(personForm.password != personForm.confirmPassword){
				alert("The passwords aren't the same, try again please");
				return;
			}
			else{		
			person={"id":personForm.id,"name": personForm.name,"email":personForm.email,"password":personForm.password};
				personService.addPerson(person).then(function(message){
					if(message.data == "OK"){
						alert("Insertó al pelo");
					}
					else if(message.data == "EMAILERROR"){
						alert("El correo ya está en uso");
					}
					else{
						alert("No se ha podido insertar");
					}
				})
			}
		}
	}
}]);