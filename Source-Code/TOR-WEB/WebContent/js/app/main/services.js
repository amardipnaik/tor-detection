app.factory(
				"mainService",
				function($http, $log, toaster, $location) {
					var isDisabled = "";

					return {
						setDisableButtonsOnRowClick : function(data) {
							isDisabled = data;
						},
						getDisableButtonsOnRowClick : function() {
							return isDisabled;
						},
						fetchRoleList : function(data) {

							/*console.log("-------In role Service-------",data);*/
							var promise = $http({
								url : "role/getChildRole",
								method : "POST",
								data : JSON.stringify(data)
							}).success(
									function(data, status, header, config,
											statusText) {
									}).error(
									function(data, status, header, config,
											statusText) {
										if (!status === 901)
											toaster.pop('error', status,
													statusText);
									}).then(function(response) {
								/*console.log("-------In role Service Reponce-------",response);*/
								return response.data;
							})
							return promise;
						},
						checkTor : function(data) {

							/*console.log("-------In role Service-------",data);*/
							var promise = $http({
								url : "checkTor",
								method : "POST",
								data : JSON.stringify(data)
							}).success(
									function(data, status, header, config,
											statusText) {
									}).error(
									function(data, status, header, config,
											statusText) {
										if (!status === 901)
											toaster.pop('error', status,
													statusText);
									}).then(function(response) {
								
								return response.data;
							})
							return promise;
						},
						addTor : function(data) {

						
							var promise = $http({
								url : "addTor",
								method : "POST",
								data : JSON.stringify(data)
							}).success(
									function(data, status, header, config,
											statusText) {
									}).error(
									function(data, status, header, config,
											statusText) {
										if (!status === 901)
											toaster.pop('error', status,
													statusText);
									}).then(function(response) {
								/*console.log("-------In role Service Reponce-------",response);*/
								return response.data;
							})
							return promise;
						},
						viewIp : function(data) {

							
							var promise = $http({
								url : "viewIp",
								method : "POST",
								data : JSON.stringify(data)
							}).success(
									function(data, status, header, config,
											statusText) {
									}).error(
									function(data, status, header, config,
											statusText) {
										if (!status === 901)
											toaster.pop('error', status,
													statusText);
									}).then(function(response) {
								/*console.log("-------In role Service Reponce-------",response);*/
								return response.data;
							})
							return promise;
						},
                         viewIpTor : function(data) {

							
							var promise = $http({
								url : "viewIp",
								method : "POST",
								data : JSON.stringify(data)
							}).success(
									function(data, status, header, config,
											statusText) {
									}).error(
									function(data, status, header, config,
											statusText) {
										if (!status === 901)
											toaster.pop('error', status,
													statusText);
									}).then(function(response) {
								/*console.log("-------In role Service Reponce-------",response);*/
								return response.data;
							})
							return promise;
						},
						scanAll : function(data) {

							
							var promise = $http({
								url : "scanAll",
								method : "GET"
								
							}).success(
									function(data, status, header, config,
											statusText) {
									}).error(
									function(data, status, header, config,
											statusText) {
										if (!status === 901)
											toaster.pop('error', status,
													statusText);
									}).then(function(response) {
								/*console.log("-------In role Service Reponce-------",response);*/
								return response.data;
							})
							return promise;
						},
						blockTor : function(data) {

							
							var promise = $http({
								url : "blockTor",
								method : "POST",
								data : JSON.stringify(data)
							}).success(
									function(data, status, header, config,
											statusText) {
									}).error(
									function(data, status, header, config,
											statusText) {
										if (!status === 901)
											toaster.pop('error', status,
													statusText);
									}).then(function(response) {
								/*console.log("-------In role Service Reponce-------",response);*/
								return response.data;
							})
							return promise;
						}
		        		
					}
				});

				
app.factory("sharedProperties", function($http, $log, toaster, $location) {
	var property = null;

	return {
		getProperty : function() {
			return property;
		},
		setProperty : function(value) {
			property = value;
		}
	};
});