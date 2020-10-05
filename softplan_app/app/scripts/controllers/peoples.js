'use strict';

var app = angular.module('softPlanApp')
	.controller('PeoplesCtrl', [ '$scope', '$sce', '$store', 'flash', 'PeopleListService', 'PeopleService', function ($scope, $sce, $store, flash, peopleListService, peopleService) {

    // Create newPeople
    $scope.newPeople = {};

    $scope.loadPeoples = function(){
        peopleListService.get(null, null, function(response){
          $scope.peoples = response.peoples;
        }, function(response) {
          showErrorMessages('Erro ao carregar usuários. ', response);
        });
    };

    $scope.savePeople = function() {
      if($scope.newPeople.id) {
        $scope.editPeople();
      } else {
        $scope.addPeople();
      }
    }

    $scope.addPeople = function() {

      peopleService.post(null, {
        name: $scope.newPeople.name,
        gender: $scope.newPeople.gender,
        email: $scope.newPeople.email,
        birthdate: formatDate($scope.newPeople.birthdate),
        placeOfBirth: $scope.newPeople.placeOfBirth,
        citizenship: $scope.newPeople.citizenship,
        federalIdentification: $scope.newPeople.federalIdentification,
        address: $scope.newPeople.address
      }, function(response){
        flash.success = $scope.newPeople.name + ' foi criado com sucesso.';

        // Close Modal (@todo find another 
        // way other than dom method in controller)
        // document.getElementById('restaurant-form').modal('hide');

        // clean scope from newPeople
        $scope.newPeople = {};

        $scope.loadPeoples();
      }, function(response){
        showErrorMessages('Erro ao criar usuário. ', response);
      });
    }

    function formatDate(date) {
      var d = new Date(date),
          month = '' + (d.getMonth() + 1),
          day = '' + d.getDate(),
          year = d.getFullYear();

      if (month.length < 2) 
          month = '0' + month;
      if (day.length < 2) 
          day = '0' + day;

      return [day, month, year].join('/');
    }

    var showErrorMessages = function(messageDefault, response) {
        console.log(response);

        var message = messageDefault;

        if(response.status == 401) {
          message += "Não autorizado";
        } else if(response.data && response.data.message) {
          message += response.data.message;
        } 


        if(response.data && response.data.errors && response.data.errors.length > 0) {
          response.data.errors.forEach(function(error) {
            message += "<br>" + error;
          });
        }

        flash.error = $sce.trustAsHtml(message);
    }

    $scope.editPeople = function() {     
      peopleService.put(null, {
        id: $scope.newPeople.id,
        name: $scope.newPeople.name,
        gender: $scope.newPeople.gender,
        email: $scope.newPeople.email,
        birthdate: formatDate($scope.newPeople.birthdate),
        placeOfBirth: $scope.newPeople.placeOfBirth,
        citizenship: $scope.newPeople.citizenship,
        federalIdentification: $scope.newPeople.federalIdentification,
        address: $scope.newPeople.address
      }, function(response){
        flash.success = $scope.newPeople.name + ' foi atualizado com sucesso.';

        // Close Modal (@todo find another 
        // way other than dom method in controller)
        // document.getElementById('restaurant-form').modal('hide');

        // clean scope from newPeople
        $scope.newPeople = {};

        $scope.loadPeoples();
      }, function(response){
        showErrorMessages('Erro ao editar usuário. ', response);
      });
    }



    $scope.selectPeopleToRemove = function(id) {
      $scope.selectedUserToRemove = id;
    }

    $scope.removePeople = function() {

      peopleService.delete({id: $scope.selectedUserToRemove}, null, function(response){
        flash.success = 'Removido com sucesso.';
        $scope.loadPeoples();
      }, function(response){
        showErrorMessages('Erro ao excluír usuário. ', response);
      });
    }

    $scope.loadPeoples();

  	/*
  	 * Generate new Id
  	 * @notes This shouldn't happen if using a webservice,
  	 * the webservice will assign new ids
  	 */
  	var newId = function () {
  		return $scope.peoples.length + 1;
  	};

  	/*
  	 * Edit restaurant by id 
  	 */
  	$scope.edit = function(id) {
  		
    	//search restaurants with given id
        for(var i in $scope.peoples) {
            if($scope.peoples[i].id == id) {
                //copy of originial object to scope object
                $scope.newPeople = angular.copy($scope.peoples[i]);
                if($scope.newPeople.birthdate) {
                  var dateStr = $scope.newPeople.birthdate.split("/");                  
                  $scope.newPeople.birthdate = new Date(dateStr[2], dateStr[1] - 1, dateStr[0]);

                }
            }
        }
    };
}]);