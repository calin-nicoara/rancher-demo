(function(angular) {
  angular.module('app', [
    'ngAnimate',
    'ngResource',
    'ngSanitize',
    'ui.router',
    'ui.mask',
    'ngCookies',
    'ngDraggable',
    'ngTable',
    'uiSwitch',
    'oitozero.ngSweetAlert',
    'ui.bootstrap',
    'toastr',
    'ui.multiselect',
    'ngMaterial',
    'ngMessages',
    'jkuri.timepicker',
    'angularMoment',
    'ngProgress'
  ])
  .config(configure);

  function configure($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/');
    $urlRouterProvider.when('/','/clients');

    $stateProvider.state('clients', {
      url: '/clients',
      templateUrl: 'views/clients.html',
      controller: 'ClientsController',
      controllerAs: 'clientsCtrl',
      title: 'Clients List'
    });

    $stateProvider.state('doctors', {
      url: '/doctors',
      templateUrl: 'views/doctors.html',
      controller: 'DoctorsController',
      controllerAs: 'doctorsCtrl',
      title: 'Doctors List'
    });

    $stateProvider.state('schedule', {
      url: '/schedules',
      templateUrl: 'views/schedules.html',
      controller: 'SchedulesController',
      controllerAs: 'schedulesCtrl',
      title: 'Schedule List'
    });
  }

  angular.module('app').controller('ClientsController', function(clientService) {
    var vm = this;
    clientService.getClients()
      .then(function(data) {
        console.log(data);
      });
  });

  angular.module('app').controller('DoctorsController', function() {

  });

  angular.module('app').controller('SchedulesController', function() {

  });

  angular.module('app').factory('clientService', function($http) {
    var service = {};

    var makeCall = function (verb, url, data, params) {
      return $http({
                     method: verb,
                     data: data,
                     url: url,
                     params: params
                   })
        .then(function (reply) {
          return reply.data;
        });
    };

    service.getClients = function() {
      return makeCall('GET', 'api/client/clients');
    };

    return service;
  })

}(angular));