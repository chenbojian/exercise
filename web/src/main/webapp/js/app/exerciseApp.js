var exerciseApp = angular.module("exerciseApp", ["ngRoute"]);

exerciseApp.controller("multipleChoiceController", function ($scope, $http) {
    $http.get("./api/multiple-choice/list").success(function (multipleChoices) {
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
            } else {
                $("span.glyphicon").attr("class", "glyphicon glyphicon-remove");
                this.rightOrWrong = "wrong";
            }
        }
    };
});

exerciseApp.controller("inputMultipleChoiceController", function ($scope, $http) {
    var Selection = function () {
        this.content = "";
        this.answer = false;
        this.description = "";
    };

    $scope.multipleChoice = {
        content: "",
        multipleChoiceSelections: [
            new Selection(),
            new Selection(),
            new Selection()
        ]
    };
    $scope.addSelection = function () {
        $scope.multipleChoice.multipleChoiceSelections.push(new Selection());
    };
    $scope.chooseRightAnswer = function ($index) {
        $scope.multipleChoice.multipleChoiceSelections
            .forEach(function (value, index) {
                value.answer = index == $index;
            });
    };
    $scope.submit = function () {
        $http.post("./api/multiple-choice/submit", $scope.multipleChoice);
    }
});

exerciseApp.filter("toABCD", function () {
    return function (data) {
        return String.fromCharCode(data + 65);
    };
});

exerciseApp.config(["$routeProvider",
    function ($routeProvider) {
        $routeProvider.
            when('/', {
                templateUrl: "partials/multiple-choice.html",
                controller: "multipleChoiceController"
            }).
            when('/input-multiple-choice', {
                templateUrl: "partials/input-multiple-choice-data.html",
                controller: "inputMultipleChoiceController"
            }).
            otherwise({
                redirectTo: "/"
            })
    }]);
