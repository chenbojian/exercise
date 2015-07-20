var exerciseApp = angular.module("exerciseApp", []);

exerciseApp.controller("multipleChoiceController",function($scope,$http) {
    $http.get("./api/list").success(function (multipleChoices) {

        var i = 0;
        $scope.multipleChoice = multipleChoices[i];

        $scope.next_multiple_choice = function () {
            i++;
            $scope.multipleChoice = multipleChoices[i];
            if(i == multipleChoices.length - 1){
                $("a.btn").text("完成");
                $scope.isFinish = true;
            }
        }
        $scope.finish = function () {
            alert("finish");
        }
    });


});