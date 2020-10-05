'use strict';

/**
 * @ngdoc overview
 * @name softPlanApp
 * @description
 * # softPlanApp
 *
 * Main module of the application.
 */
angular
  .module('softPlanApp', [
    /*'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'*/
    'ngResource',
    'ngRoute',
    'ngAnimate',
    'angular-flash.service', 
    'angular-flash.flash-alert-directive',
    'AppServices'
  ])
  .config(function ($routeProvider,$locationProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
      .when('/peoples', {
        templateUrl: 'views/peoples/peoples.html',
        controller: 'PeoplesCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });

    // Set HTML5 Styles Urls.
    // $locationProvider
    //   .html5Mode(true);

    $locationProvider.hashPrefix('');
  });
