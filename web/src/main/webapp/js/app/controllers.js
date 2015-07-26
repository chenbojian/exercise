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
            if (this.selection.answer) {
                $("span.glyphicon").attr("class", "glyphicon glyphicon-ok");
                this.rightOrWrong = "right";
            } else {
                $("span.glyphicon").attr("class", "glyphicon glyphicon-remove");
                this.rightOrWrong = "wrong";
            }
            this.show = true;
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
    $scope.quiz = {
        id: 0,
        name: "",
        multipleChoices: []
    };

    $scope.choose = function (multipleChoice) {
        var multipleChoices = $scope.quiz.multipleChoices;
        var idx = multipleChoices.indexOf(multipleChoice);
        if (idx == -1) {
            multipleChoices.push(multipleChoice);
        } else {
            multipleChoices.splice(idx, 1);
        }
    };

    $scope.submitQuiz = function () {
        if($scope.quiz.multipleChoices.length == 0){
            alert("至少应该选择一道题!");
            return;
        }
        $http.post("api/quiz/generate",$scope.quiz).
            success(function () {
                alert("success");
            });
    }
});

exerciseControllers.controller("listQuizController", function ($scope, $http) {
    $http.get("api/quiz/list").
        success(function (data) {
            $scope.quizes = data;
        })
});