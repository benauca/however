/**
 * Java Script que valida el login
 */
// ngResource. Modulo para la invocacion de servicios REST.
var myApp = angular.module('hwvr-app', []);
		myApp.controller('loginController', [ '$scope','$http',loginController ]);
// Debe ser la funcion principal y está asociada al ng-controller
function loginController($scope, $http) {

	$scope.hideShowPassword = function() {
		alert("===================================================");
		if ($scope.passType == 'glyphicon glyphicon-eye-open') {
			$scope.passIcon = 'glyphicon glyphicon-eye-close';
			$scope.passType = 'text';
		}

		else {
			$scope.passIcon = 'glyphicon glyphicon-eye-open';
			$scope.passType = 'password';
		}
	};

	$scope.createUser = function() {
		// El sistema deberá crear el usuario en el sistema.
		// if($scope.isGoogle) {
		// alert("el Sistema deberá validar contra google...");
		// }else {
		var user = {'login':'benauca2',
				  'email':'jbenavente74222@gmail.com',
				  'fullName':'Jesús Benaventessss'};
		var config = {
                headers : {
                	'accept': 'application/json',
                	'accept-encoding': 'gzip, deflate',
                	'accept-language': 'en-US,en;q=0.8',
                	'content-type': 'application/json',
                	'user-agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36'
                }
            }
		return $http.post('http://localhost:8080/user/new',user,config);
	}
};
