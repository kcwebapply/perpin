<img src="https://imgur.com/lmDUg4B.png" align="right" width = "100" height = "100"> 

# perpin


perpin is java performance measure tool between code and code.


## about

you can measure application performance between code on code by perpin.

`Perpin.setPin` starts measuring .

`Perpin.getPin` finish measuring and show results.


## usage

1. call  `Perpin.setPin(#id)` . Perpin measure performance internally. 

2. you can write code that you want to measure.

3. call `Perpin.getPin(#id)` to show result.

```Java

Perpin.setPin(1);

// implementation that you want to measure.
int i;
int sum = 0;
for(i = 0;i < 10000; i++){
  Mock mock = new Mock(i);
  System.out.println(mock);
  sum += i;
}

// view result of performance measurance between `Perpin.setPin(1)` and `Perpin.getPin(1)`
Perpin.getPin(1);

```


when `Perpin.getPin(#id);` called,  `Perpin` stopped performance measurance and show results.


```terminal
2019-05-19 20:16:22.143  INFO 51804 --- [           main] j.s.perpin.view.PerPinView               : 
{ 'id': 1, 'time':'0 ms', 'memory' : {'used':'86102 KB','max':'223744 KB','used percentage':'38.482373 %'},'cpu percentage':'0.000000 %'}
{ 'id': 1, 'time':'105 ms', 'memory' : {'used':'88754 KB','max':'223744 KB','used percentage':'39.667656 %'},'cpu percentage':'55.749825 %'}
{ 'id': 1, 'time':'206 ms', 'memory' : {'used':'90080 KB','max':'223744 KB','used percentage':'40.260297 %'},'cpu percentage':'13.720317 %'}
{ 'id': 1, 'time':'310 ms', 'memory' : {'used':'92733 KB','max':'223744 KB','used percentage':'41.446028 %'},'cpu percentage':'21.916147 %'}
{ 'id': 1, 'time':'414 ms', 'memory' : {'used':'96711 KB','max':'223744 KB','used percentage':'43.223952 %'},'cpu percentage':'25.226762 %'}
{ 'id': 1, 'time':'514 ms', 'memory' : {'used':'100689 KB','max':'223744 KB','used percentage':'45.001877 %'},'cpu percentage':'24.126667 %'}
{ 'id': 1, 'time':'616 ms', 'memory' : {'used':'103342 KB','max':'223744 KB','used percentage':'46.187607 %'},'cpu percentage':'19.413637 %'}
{ 'id': 1, 'time':'716 ms', 'memory' : {'used':'107320 KB','max':'223744 KB','used percentage':'47.965532 %'},'cpu percentage':'36.593352 %'}
{ 'id': 1, 'time':'817 ms', 'memory' : {'used':'111298 KB','max':'223744 KB','used percentage':'49.743457 %'},'cpu percentage':'24.857900 %'}
{ 'id': 1, 'time':'918 ms', 'memory' : {'used':'113951 KB','max':'223744 KB','used percentage':'50.929187 %'},'cpu percentage':'22.478443 %'}
{ 'id': 1, 'time':'1019 ms', 'memory' : {'used':'117929 KB','max':'223744 KB','used percentage':'52.707112 %'},'cpu percentage':'24.801722 %'}
{ 'id': 1, 'time':'1120 ms', 'memory' : {'used':'121907 KB','max':'223744 KB','used percentage':'54.485036 %'},'cpu percentage':'24.886078 %'}
{ 'id': 1, 'time':'1155 ms', 'memory' : {'used':'123234 KB','max':'223744 KB','used percentage':'55.078125 %'},'cpu percentage':'23.788227 %'}
overall:{{ 'id': 1, 'time':'1155 ms','memoryMaxpercentage':'55.078125 %','cpuMaxPercentage':'55.7498 %','cpuAverage':'24.427621 %'}

```


## installation

```xml
<dependency>
	<groupId>jp.spring-boot-reference</groupId>
	<artifactId>perpin</artifactId>
	<version>1.0.0</version>
</dependency>

```



