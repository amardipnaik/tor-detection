
<h2>Add IP Address</h2>


     Hostname:
     <input type="text" placeholder="Enter Hostname" name="hostname" id="hostname" /><br>
     IP Addres :
     <input type="text" placeholder="Enter IP Address" name="ipAddress" id="ipAddress" /><br>
          Remarks    :
     <input type="text" placeholder="remarks" name="remarks" id="remarks" /><br>
    <!--  <input type="radio" ng-model='istor' ng-value='"no"' name="istor">Not Tor Ip<br>
     <input type="radio" ng-model='istor' ng-value='"yes"' name="istor">Tor Ip<br> -->
     <!--  <input type="checkbox" name="istor" value="no" id="istor"> Not Tor Ip<br>
     <input type="checkbox" name="istor" value="yes" id="istor">Tor Ip<br> -->
     
     <button ng-click="addIp()">Add IP Address</button>
     <br>
      <ul>
    <li ng-repeat='(key, value) in resultData'>
       <h4> <span>RESULT: {{value}}</span></h4>
    </li>
</ul>