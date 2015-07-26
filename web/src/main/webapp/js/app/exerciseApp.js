var exerciseApp = angular.module("exerciseApp", [
    "ngRoute",
    "exerciseControllers"
]);
exerciseApp.controller("mainController", function () {
    $('.nav a').on("click",function () {
        $('.nav li').removeClass("active");
        $(this).parent().addClass("active");
    });
});

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
            });
    }]);
