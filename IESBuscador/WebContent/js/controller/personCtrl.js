app.controller("personCtrl", ["$scope","personService","$cookieStore", function personCtrl($scope, personService, $cookieStore) {
	
	//Register
	$scope.personForm={};
	$scope.personForm.id="";
	$scope.hideInformation = true;
	$scope.addPerson=function(personForm){
		var getCookie = $cookieStore.get('cookiePersonSession');
		if(!angular.isUndefined(getCookie)){
			alert("Right now there's a session with id:"+getCookie.id+" name: "+getCookie.name);
			alert("So, we're going to Logout it");
			$cookieStore.remove('cookiePersonSession');
			return;
		}
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
						alert("Here, we have go to home page");
					}
					else if(message.data == "EMAILERROR"){
						alert("The email is already in use");
					}
					else{
						alert("It couldn't be insert ");
					}
				})
			}
		}
	}
	
	//Login
	$scope.personFormLogin={};
	$scope.logIn=function(personFormLogin){
		var personSession={};
		if(angular.isUndefined(personFormLogin.email) || angular.isUndefined(personFormLogin.password)){
			alert("Complete all fields");
			return;
		}
		else{
			personService.findByEmail(personFormLogin.email).then(function(message){
				if(message.data.id == 0 ||message.data.name == null || message.data.email == null || message.data.password == null){
					alert("You aren't in our database");
				}
				else{
					if(message.data.password == personFormLogin.password){
						personSession.id = message.data.id;
						personSession.name = message.data.name;
						personSession.email= message.data.email;
						personSession.password = message.data.password;
						$cookieStore.put('cookiePersonSession',personSession);
						alert("You're login now");
					}
					else{
						alert("The password is wroooong");
					}
				}
			})
		}
	}
}]);