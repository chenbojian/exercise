var exerciseApp = angular.module("exerciseApp", []);

exerciseApp.controller("multipleChoiceController",function($scope,$http) {
    $http.get("./api/list").success(function (data) {
        $scope.multipleChoices = data;
    });
});