var exerciseApp = angular.module("exerciseApp", ["ngRoute"]);

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
        show: false,
        rightOrWrong: "",
        reset: function () {
            this.selection = null;
            this.show = false;
            this.rightOrWrong = "";
        },
        select: function () {
            this.show = true;
            if (this.selection.answer) {
                $("span.glyphicon").attr("class", "glyphicon glyphicon-ok");
                this.rightOrWrong = "right";
            }else {
                $("span.glyphicon").attr("class", "glyphicon glyphicon-remove");
                this.rightOrWrong = "wrong";
            }
        }
    };


});

exerciseApp.config(["$routeProvider",
    function ($routeProvider) {
        $routeProvider.
            when('/', {
                templateUrl: "partials/multiple-choice.html",
                controller: "multipleChoiceController"
            }).
            otherwise({
                redirectTo: "/"
            })
    }]);
