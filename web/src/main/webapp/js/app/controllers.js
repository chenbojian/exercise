var exerciseControllers = angular.module("exerciseControllers", []);

exerciseControllers.controller("quizController", function ($scope, $http, $routeParams) {
    $http.get("./api/quiz/" + $routeParams.quizId).success(function (quiz) {
        var i = 0;
        var multipleChoices = quiz.multipleChoices;
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

exerciseControllers.controller("inputMultipleChoiceController", function ($scope, $http) {
    var Selection = function () {
        this.content = null;
        this.answer = false;
        this.description = null;
    };

    var MultipleChoice = function () {
        this.content = null;
        this.multipleChoiceSelections = [
            new Selection(),
            new Selection(),
            new Selection(),
            new Selection()
        ];
    };

    $scope.multipleChoice = new MultipleChoice();

    $scope.addSelection = function () {
        $scope.multipleChoice.multipleChoiceSelections.push(new Selection());
    };
    $scope.removeSelection = function () {
        $scope.multipleChoice.multipleChoiceSelections.pop();
    };
    $scope.chooseRightAnswer = function ($index) {
        $scope.multipleChoice.multipleChoiceSelections
            .forEach(function (value, index) {
                value.answer = index == $index;
            });
    };
    $scope.submit = function () {
        $http.post("./api/multiple-choice/submit", $scope.multipleChoice)
            .success(function () {
                $scope.multipleChoice = new MultipleChoice();
            });

    }
});

exerciseControllers.controller("generateQuizController", function ($scope, $http) {
    $http.get("api/quiz/list-multiple-choice").
        success(function (data) {
            $scope.multipleChoices = data;
        });
    var chooses = [];
    $scope.choose = function (multipleChoice) {
        var idx = chooses.indexOf(multipleChoice);
        if (idx == -1) {
            chooses.push(multipleChoice);
            console.log(multipleChoice.content);
        } else {
            chooses.splice(idx, 1);
            console.log(multipleChoice.content + "--remove");
        }
    }
});