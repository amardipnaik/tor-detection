<h2>Check TOR</h2>

Enter IP Address:
     <input type="text" placeholder="Enter IP Address" name="ipAddress" id="ipAddress" />
     <button ng-click="torCheck()">Check</button>
     <br>
     <ul>
    <li ng-repeat='(key, value) in resultData'>
        <h4><span>RESULT: {{value}}</span></h4>
    </li>
</ul>