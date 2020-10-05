'use strict';

var appServices = angular.module("AppServices", ['ngResource', 'ngRoute']);
var domainURL = "http://localhost:5000/api/v1";

appServices.run(['$http', function(http) {
	http.defaults.headers.common['Authorization'] = 'Basic YWRtaW46MTIzNDU2';
}]);

appServices.factory('RestaurantListService', ['$resource', function(resource) {
	return resource(domainURL + '/restaurant/list', null, {
		get: { method:'GET'}
	});
}]);

appServices.factory('RestaurantService', ['$resource', function(resource) {
	return resource(domainURL + '/restaurant', null, {
		post: { method:'POST'},
		put: {method: 'PUT'},
		delete: {method: 'DELETE'}
	});
}]);

appServices.factory('ProductListService', ['$resource', function(resource) {
	return resource(domainURL + '/product/list', null, {
		get: { method:'GET'}
	});
}]);

appServices.factory('ProductService', ['$resource', function(resource) {
	return resource(domainURL + '/product', null, {
		post: { method:'POST'},
		put: {method: 'PUT'},
		delete: {method: 'DELETE'}
	});
}]);

// Peoples

appServices.factory('PeopleListService', ['$resource', function(resource) {
	return resource(domainURL + '/people', null, {
		get: { method:'GET'}
	});
}]);

appServices.factory('PeopleService', ['$resource', function(resource) {
	return resource(domainURL + '/people', null, {
		post: { method:'POST'},
		put: {method: 'PUT'},
		delete: {method: 'DELETE'}
	});
}]);


appServices.factory('OrderListService', ['$resource', function(resource) {
	return resource(domainURL + '/order/list', null, {
		get: { method:'GET'}
	});
}]);

appServices.factory('OrderService', ['$resource', function(resource) {
	return resource(domainURL + '/order', null, {
		post: { method:'POST'},
		put: {method: 'PUT'},
		delete: {method: 'DELETE'}
	});
}]);

appServices.factory('OrderUpdateService', ['$resource', function(resource) {
	return resource(domainURL + '/order/update', null, {
		post: { method:'POST'}
	});
}]);