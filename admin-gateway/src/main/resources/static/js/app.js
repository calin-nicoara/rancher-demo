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

    $stateProvider.state('schedules', {
      url: '/schedules',
      templateUrl: 'views/schedules.html',
      controller: 'SchedulesController',
      controllerAs: 'schedulesCtrl',
      title: 'Schedule List'
    });
  }

  angular.module('app').directive('customNavBar', navbarDirective);

  function navbarDirective() {
    return {
      restrict: 'E',
      templateUrl: 'views/directives/navBar.html',
      controller: navbarController,
      controllerAs: 'navCtrl'
    };

    function navbarController($state) {
      var vm = this;

      vm.getLink = getLink;

      function getLink() {
        return $state.current.url;
      }

      return vm;
    }
  }

  angular.module('app').controller('ClientsController', function(clientService, $q) {
    var vm = this;

    vm.modelSave = {};

    var resetTable = function() {
      clientService.getClients().then(function(data) {
        vm.data = data['_embedded']['clients'];
      });
    };

    resetTable();

    vm.isClientFormVisible = false;

    vm.toggleClientForm = function() {
      vm.isClientFormVisible = !vm.isClientFormVisible;
    };

    vm.addClient = function(saveModel){
      clientService.saveClient(saveModel)
        .then(function() {
          resetTable();
          vm.isClientFormVisible = false;
          vm.modelSave = {};
        });
    };

    vm.deleteClient = function(client) {
      clientService.deleteItem(client['_links']['self']['href'])
        .then(function() {
          resetTable();
        });
    };

    return vm;
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

    service.saveClient = function(saveModel) {
      return makeCall('POST', 'api/client/clients', saveModel);
    };

    service.deleteItem = function(link) {
      return makeCall('DELETE', link);
    };

    return service;
  });

  angular.module('app').controller('DoctorsController', function(doctorService) {
    var vm = this;

    vm.modelSave = {};

    var resetTable = function() {
      doctorService.getDoctors().then(function(data) {
        vm.data = data['_embedded']['doctors'];
      });
    };

    resetTable();

    vm.isDoctorFormVisible = false;

    vm.toggleDoctorForm = function() {
      vm.isDoctorFormVisible = !vm.isDoctorFormVisible;
    };

    vm.addDoctor = function(saveModel){
      doctorService.saveDoctor(saveModel)
        .then(function() {
          resetTable();
          vm.isDoctorFormVisible = false;
          vm.modelSave = {};
        });
    };

    vm.deleteDoctor = function(doctor) {
      doctorService.deleteItem(doctor['_links']['self']['href'])
        .then(function() {
          resetTable();
        });
    };

    return vm;
  });

  angular.module('app').factory('doctorService', function($http) {
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

    service.getDoctors = function() {
      return makeCall('GET', 'api/doctor/doctors');
    };

    service.saveDoctor = function(saveModel) {
      return makeCall('POST', 'api/doctor/doctors', saveModel);
    };

    service.deleteItem = function(link) {
      return makeCall('DELETE', link);
    };

    return service;
  });


  angular.module('app').controller('SchedulesController', function(scheduleService) {
    var vm = this;

    vm.modelSave = {};

    var resetTable = function() {
      scheduleService.getAppointments().then(function(data) {
        vm.data = data;
      });
    };

    resetTable();

    vm.isAppointmentFormVisible = false;

    vm.toggleAppointmentForm = function() {
      vm.isAppointmentFormVisible = !vm.isAppointmentFormVisible;
    };

    vm.addAppointment = function(saveModel){
      saveModel.clientLink = "/api/client/clients/2";
      saveModel.doctorLink = "/api/doctor/doctors/1";
      scheduleService.saveAppointment(saveModel)
        .then(function() {
          resetTable();
          vm.isAppointmentFormVisible = false;
          vm.modelSave = {};
        });
    };

    return vm;
  });

  angular.module('app').factory('scheduleService', function($http) {
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

    service.getAppointments = function() {
      return makeCall('GET', 'api/scheduling/appointments');
    };

    service.saveAppointment = function(saveModel) {
      return makeCall('POST', 'api/scheduling/appointments', saveModel);
    };

    return service;
  });


}(angular));