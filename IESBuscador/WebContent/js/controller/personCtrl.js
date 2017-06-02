app.controller("personCtrl", ["$scope",  "personService", function personCtrl($scope, personService) {
	$scope.personForm={};
	$scope.personForm.id="";
	$scope.addPerson=function(personForm){
		if(personForm.password != personForm.confirmPassword){
			alert("Las contraseñas no coinciden");
		}
		else{		
		person={"id":personForm.id,"name": personForm.name,"email":personForm.email,"password":personForm.password};
			personService.addPerson(person).then(function(message){
				if(message.data == "OK"){
					alert("insertó al pelo");
				}
				else{
					alert("No se ha podido insertar");
				}
			})
		}
	}
}]);