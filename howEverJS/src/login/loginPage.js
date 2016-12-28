/**
 * Java Script que valida el login
 */
// ngResource. Modulo para la invocacion de servicios REST.
var myApp = angular.module('hwvr-app', []);
myApp.controller('loginController', [ '$scope', '$http', loginController ]);

// Debe ser la funcion principal y está asociada al ng-controller
function loginController($scope, $http) {
	$scope.hideShowPassword = function() {
		alert("===================================================");
		if ($scope.passType == 'glyphicon glyphicon-eye-open') {
			$scope.passIcon = 'glyphicon glyphicon-eye-close';
			$scope.passType = 'text';
		} else {
			$scope.passIcon = 'glyphicon glyphicon-eye-open';
			$scope.passType = 'password';
		}
	};

	$scope.login = function() {
		// El sistema deberá crear el usuario en el sistema.
		// if($scope.isGoogle) {
		// alert("el Sistema deberá validar contra google...");
		// }else {
				var user = {'login':'benauca2',
						  'email':'jbenavente74@gmail.com',
						  'password':'12344',
						  'fullName':'Jesús Benaventessss'};
				var config = {
						headers:{
			                'Access-Control-Allow-Origin': '*',
			                'Access-Control-Allow-Methods': 'GET, POST, PUT, DELETE, OPTIONS',
			                'Access-Control-Allow-Headers': 'Content-Type, X-Requested-With',
			                'X-Random-Shit':'123123123'
			            }
		            }
		//return $http.get('http://localhost:8080/user/validateUser',user,config);
		$http.get('http://jsonplaceholder.typicode.com/posts')
		.then(function(data) {
			console.log(data)
		});
		$http.get('http://localhost:8080/user/validateUser',user,config).then(function(user) {
			console.log(user)
		});
		
	}
}
;