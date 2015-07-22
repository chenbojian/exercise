var exerciseControllers = angular.module("exerciseControllers",[]);

exerciseControllers.controller("multipleChoiceController", function ($scope, $http) {
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
                console.log( value.answer);
            });
        console.log("----------------");
    };
    $scope.submit = function () {
        $http.post("./api/multiple-choice/submit", $scope.multipleChoice)
            .success(function () {
                $scope.multipleChoice = new MultipleChoice();
            });

    }
});