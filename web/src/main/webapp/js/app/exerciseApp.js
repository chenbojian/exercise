var exerciseApp = angular.module("exerciseApp", [
    "ngRoute",
    "exerciseControllers"
]);


exerciseApp.filter("toABCD", function () {
    return function (data) {
        return String.fromCharCode(data + 65);
    };
});

exerciseApp.config(["$routeProvider",
    function ($routeProvider) {
        $routeProvider.
            when('/',{
                templateUrl: "partials/quiz-list.html",
                controller: "listQuizController"
            }).
            when('/quiz/:quizId', {
                templateUrl: "partials/quiz.html",
                controller: "quizController"
            }).
            when('/input-multiple-choice', {
                templateUrl: "partials/input-multiple-choice.html",
                controller: "inputMultipleChoiceController"
            }).
            when('/generate-quiz',{
                templateUrl: "partials/generate-quiz.html",
                controller: "generateQuizController"
            }).
            otherwise({
                redirectTo: "/"
            })
    }]);
