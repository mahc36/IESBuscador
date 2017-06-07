app.controller("iesCtlr",  ["$scope",  "iesService", function iesCtlr($scope, iesService) {
	$scope.Ies={};
	$scope.answer="";
	$scope.getList = function(){				
		iesService.getList().then(function (message) {	
			$scope.answer="Todas las IES";
			$scope.Ies=message.data;			
        	if($scope.Ies === {}){
        		alert("No hay ninguna IES registrada");
        	}
        });
	}
	$scope.findIES=function(nameSearch){		
		if(nameSearch == null){
			alert("Debe indicar el nombre de la IES a buscar");
		}	
		else{
			iesService.findIES(nameSearch).then(function(message){
				if(message.data.length == 0){
					alert("No hay ninguna IES con este nombre");
				}else{
					$scope.answer=nameSearch;
					$scope.Ies=message.data;
				}
			});
		}
	}
}]);