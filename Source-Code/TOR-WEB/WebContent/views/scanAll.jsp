
<style>
table, th , td  {
  border: 1px solid grey;
  border-collapse: collapse;
  padding: 5px;
}
table tr:nth-child(odd) {
  background-color: #f1f1f1;
}
table tr:nth-child(even) {
  background-color: #ffffff;
}
</style>

<body>
<h2>Scan All IP</h2>

<h4>Note:</h4>
<h5>Scanning All IPs Will Take Time. Click To Proceed...</h5>
<button ng-click="scanAll()">Scan All</button>

 <table ng-if="resultDataScan !=null && resultDataScan.length != 0" >
 
<th>IP Address</th>
<th>Result</th>
<tr  ng-repeat='(key, value) in resultDataScan'>
  <td>{{ key}}</td>
    <td>{{value}}</td>
   <td ng-if="value=='TOR IP'" > <button ng-click="blockTor(key)">Block Tor</button></td>
     </tr>
     </table>
    
 
</body>
