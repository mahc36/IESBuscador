app.controller("personCtrl", ["$scope","personService","$cookieStore", function personCtrl($scope, personService, $cookieStore) {
	
	//Register
	$scope.personForm={};
	$scope.personForm.id="";
	var contador = 1;
	$scope.addPerson=function(personForm){
		//alert('Esto es lo que colocaron en Register' + JSON.stringify(personForm));
		var getCookie = $cookieStore.get('cookiePersonSession');
		if(!angular.isUndefined(getCookie)){
			alert("Ahora mismo hay una sesión activa, para registrar cierra sesión primero");
			return;
		}
		if(angular.isUndefined(personForm.name) || angular.isUndefined(personForm.email) || angular.isUndefined(personForm.password) || angular.isUndefined(personForm.confirmPassword)){
			alert("Completa todos los campos");
			return;
		}
		else{
			if(personForm.password != personForm.confirmPassword){
				alert("Las contraseñas no son las mismas");
				return;
			}
			else{		
				person={"id":personForm.id,"name": personForm.name,"email":personForm.email,"password":personForm.password};
				personService.addPerson(person).then(function(message){
					if(message.data == "OK"){
						alert("Aquí debemos de ir a la pagina principal");
					}
					else if(message.data == "EMAILERROR"){
						alert("El correo ya esta en uso");
					}
					else{
						alert("No se ha podido registrar en nuestra base de datos");
					}
				})
			}
		}
	}
	
	$scope.logOut=function(){
		alert("vamos a cerrar la sesión");
		var getCookie = $cookieStore.get('cookiePersonSession');
		alert("get cookie: "+getCookie);
		if(!angular.isUndefined(getCookie)){
			alert("Hasta luego "+getCookie.name);
			$cookieStore.remove('cookiePersonSession');
		}
	}
		
	$scope.checkCookie=function(){
//		var getCookie = $cookieStore.get('cookiePersonSession');
//		alert("El hijodeputa nombre es: "+getCookie.name);
//		if(!angular.isUndefined(getCookie)){
//			alert("Hay una sesión");
//			return false;
//		}
//		else{
//			alert("No hay una sesión");
//			return true	
//		}
//		alert("contador "+contador);
//		contador=contador+1;
	}
	
	//Login
	$scope.personFormLogin={};
	$scope.logIn=function(personFormLogin){
		var personSession={};
		if(angular.isUndefined(personFormLogin.email) || angular.isUndefined(personFormLogin.password)){
			alert("Completa todos los campos");
			return;
		}
		else{
			personService.findByEmail(personFormLogin.email).then(function(message){
				if(message.data.id == 0 ||message.data.name == null || message.data.email == null || message.data.password == null){
					alert("No reconocemos ese correo");
				}
				else{
					if(message.data.password == personFormLogin.password){
						alert("Dio todo bien y ya vamos a insertar en la cookie");
						personSession.id = message.data.id;
						personSession.name = message.data.name;
						personSession.email= message.data.email;
						personSession.password = message.data.password;
						$cookieStore.put('cookiePersonSession',personSession);
						var getCookie = $cookieStore.get('cookiePersonSession');
						alert("Bienvenido "+getCookie.name);
					}
					else{
						alert("El correo y/o la contraseña están incorrectas");
					}
				}
			})
		}
	}
}]);