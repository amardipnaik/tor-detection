app.controller("detailsControllers", [
		"$scope", '$location', 'mainService', '$log', 'localStorageService', "$timeout", "toaster", "$rootScope",
		function($scope, $location, mainService, $log, localStorageService, $timeout, toaster, $rootScope)
		{
			
			$log.info("---Inside detailsControllers---");
			
			$scope.torCheck = function()
			{
				$scope.IpAddressBean = {
						ipAddress : '',
						port:'',
						isTor:''
						
					}

				$scope.IpAddressBean.ipAddress=document.getElementById("ipAddress").value;
				console.info("In detailsControllers ",$scope.IpAddressBean.ipAddress);
				
				
				
				mainService.checkTor($scope.IpAddressBean)
				.then(
						function(result) {
							
							
							
							$scope.resultData=result;
							$log.info("---Inside $scope.status---"+$scope.resultData);
							localStorageService.set('resultData',$scope.resultData)
							
							

							
						
							});

			}
			
			
			$scope.addIp = function()
			{
				$scope.IpAddressBean = {
						ipAddress : '',
						port:'',
						isTor:'',
						hostname:'',
						remarks:''
						
					}

				$scope.IpAddressBean.ipAddress=document.getElementById("ipAddress").value;
				$scope.IpAddressBean.remarks=document.getElementById("remarks").value;
				$scope.IpAddressBean.hostname=document.getElementById("hostname").value;

				
			/*	$scope.IpAddressBean.isTor=$scope.istor;*/
				console.info("In detailsControllers ",$scope.IpAddressBean.ipAddress);
				
				
				
				mainService.addTor($scope.IpAddressBean)
				.then(
						function(result) {
							
							
							
							$scope.resultData=result;
							$log.info("---Inside $scope.status---"+$scope.resultData);
							localStorageService.set('resultData',$scope.resultData)
							
							

							
						
							});

			}
			
		
		/*	viewIp();
			viewIpTor();*/
			
			$scope.viewIp = function()
			{
				$scope.IpAddressBean = {
						ipAddress : '',
						port:'',
						isTor:'',
						hostname:'',
						remarks:''
						
					}

				
				$scope.IpAddressBean.isTor='no';
				console.info("In detailsControllers ",$scope.IpAddressBean.ipAddress);
				
				
				
				mainService.viewIp($scope.IpAddressBean)
				.then(
						function(result) {
							$scope.resultDataIP=result;
							$log.info("---Inside $scope.resultDataIP---"+$scope.resultDataIP);
							});

			}
			
			$scope.viewIpTor = function()
			{
				$scope.IpAddressBean = {
						ipAddress : '',
						port:'',
						isTor:'',
						hostname:'',
						remarks:''
						
					}

				
				$scope.IpAddressBean.isTor='yes';
				console.info("In detailsControllers ",$scope.IpAddressBean.ipAddress);
				
				
				
				mainService.viewIpTor($scope.IpAddressBean)
				.then(
						function(result) {
							$scope.resultDataIPTor=result;
						
							});

			}
			
			
			$scope.scanAll = function()
			{
				
				
				mainService.scanAll()
				.then(
						function(result) {
							$scope.resultDataScan=result;
							
							});

			}
			
			
			$scope.blockTor = function(ipAddress)
			{
				
				$scope.IpAddressBean = {
						ipAddress : ''
						
						
					}
				$scope.IpAddressBean.ipAddress=ipAddress;
				/*alert(ipAddress);*/
				mainService.blockTor($scope.IpAddressBean)
				.then(
						function(result) {
							$scope.updateResult=result;
							
							if(updateResult="success")
								{
								alert("BLOCKED IP Successfully")
								}
							else
								{
								alert("Failure.. Kindly Check With DB ")
								}
							
							});

			}
			
			
			
			$scope.viewIp();
			$scope.viewIpTor();
			

			
		}
		
		
		

		

			
])
