var exerciseApp = angular.module("exerciseApp", []);

exerciseApp.controller("multipleChoiceController", function ($scope, $http) {
    $http.get("./api/list").success(function (multipleChoices) {

        var i = 0;
        $scope.multipleChoice = multipleChoices[i];

        $scope.nextMultipleChoice = function () {
            if (i == multipleChoices.length - 1) {
                alert("finish");
                return;
            }
            if (i == multipleChoices.length - 2) {
                $("a.btn").text("完成");
            }
            $scope.multipleChoice = multipleChoices[i++ + 1];
            $scope.userSelect.reset();
        };

    });

    $scope.userSelect = {
        selection: null,
        show: function () {
            return this.selection != null;
        },
        reset: function () {
            this.selection = null
        },
        isRight: function () {
            if (this.selection != null) {
                return this.selection.answer ? "right" : "wrong";
            }
        }
    };


});