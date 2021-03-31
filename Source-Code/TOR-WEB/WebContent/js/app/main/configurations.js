app.config(function($routeProvider, $locationProvider)
{
	/*alert("config called");*/
	$routeProvider.when('/', {
		templateUrl : 'views/torCheck.jsp',
		controller : 'detailsControllers'
	}).when('/checktor.htm', {
		templateUrl : 'views/torCheck.jsp',
		controller : 'detailsControllers'
	}).when('/addIp.htm', {
		templateUrl : 'views/addIp.jsp',
		controller : 'detailsControllers'
	}).when('/viewIp.htm', {
		templateUrl : 'views/viewIp.jsp',
		controller : 'detailsControllers'
	})
	.when('/viewIpTor.htm', {
		templateUrl : 'views/viewIpTor.jsp',
		controller : 'detailsControllers'
	})
	.when('/about.htm', {
		templateUrl : 'views/about.jsp',
		controller : 'detailsControllers'
	}).when('/scanAll.htm', {
		templateUrl : 'views/scanAll.jsp',
		controller : 'detailsControllers'
	})

});

