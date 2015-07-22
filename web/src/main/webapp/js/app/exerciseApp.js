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
            when('/', {
                templateUrl: "partials/multiple-choice.html",
                controller: "multipleChoiceController"
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
