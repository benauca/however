// ngResource. Modulo para la invocacion de servicios REST.
var myApp = angular.module('hwvr-app', []);
myApp.controller('registerController', [ '$scope', '$http', registerController ]);
// Debe ser la funcion principal y está asociada al ng-controller
function registerController($scope, $http) {
	$scope.Text01 = "Crea tu cuenta HowEver Gratis";

	$scope.createUser = function() {
		var user = {
			'login' : 'jbenavente74',
			'email' : 'jbenavente74@gmail.com',
			'fullName' : 'Jesus Benavente',
			'password' : '1234',
			'isAdmin' : '0',
			'authType' : '0'
		};
		alert(user.login);
		//No funciona localhots
//		$http.post('http://127.0.0.1:8080/however/user/new', JSON.stringify(user)).then(function(data) {
//			console.log(data)
//		});
//		
		$http.post('http://127.0.0.1:8080/however/user/get', JSON.stringify({idUser:"1"})).then(function(data) {
			console.log(data)
		});
		

	}
}
;