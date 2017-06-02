var app= angular.module("FrontEndIESBuscador", ["ngRoute"]);
app.config(function($routeProvider){
	$routeProvider
	.when("/",{
		templateUrl:"/resources/partials/page4.html"
	})
	.when("/page1",{
		templateUrl:"/resources/partials/page1.html"
	});
});