<img src="https://imgur.com/lmDUg4B.png" align="right" width = "100" height = "100"> 

# perpin

![apache licensed](https://img.shields.io/badge/License-Apache_2.0-d94c32.svg)
![Java](https://img.shields.io/badge/Language-Java-f88909.svg)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/jp.spring-boot-reference/perpin/badge.svg)](https://maven-badges.herokuapp.com/maven-central/jp.spring-boot-reference/perpin)


perpin is java performance record tool between code and code.


## about

you can record application performance between code on code by perpin.

perpin run on background thread Asynchronously and continue to record performance until you stop .


## usage

1. call  `Perpin.setPin(#id)` . Perpin record performance internally. 

2. you can write code that you want to record.

3. call `Perpin.getPin(#id)` to show result.

```Java

Perpin.setPin(1);

// implementation that you want to measure.
int i;
int sum = 0;
for(i = 0;i < 10000; i++){
  System.out.println(new Object());
  sum += i;
}

// view result of performance measurance between `Perpin.setPin(1)` and `Perpin.getPin(1)`
Perpin.getPin(1);
```


when `Perpin.getPin(#id);` called,  `Perpin` stopped performance record and show results with `Json Format`.


```terminal
2019-05-19 22:41:54.908  INFO 53736 --- [           main] j.s.perpin.view.PerPinView               : { 
"units":{"time":"ms","used":"KB","percentage:":"%"},  "statuses":
[{ "id": 1, " time ":0 ,  "memory" : {"used" : 86547 , "max" : 224768 , "used percentage" : 38.505036 } , "cpu percentage" : 0.000000 },
{ "id": 1, " time ":103 ,  "memory" : {"used" : 87873 , "max" : 224768 , "used percentage" : 39.094978 } , "cpu percentage" : 53.550941 },
{ "id": 1, " time ":207 ,  "memory" : {"used" : 91851 , "max" : 224768 , "used percentage" : 40.864803 } , "cpu percentage" : 41.293298 },
{ "id": 1, " time ":309 ,  "memory" : {"used" : 94503 , "max" : 224768 , "used percentage" : 42.044686 } , "cpu percentage" : 24.509929 },
{ "id": 1, " time ":410 ,  "memory" : {"used" : 98482 , "max" : 224768 , "used percentage" : 43.814956 } , "cpu percentage" : 21.132665 },
{ "id": 1, " time ":511 ,  "memory" : {"used" : 102460 , "max" : 224768 , "used percentage" : 45.584781 } , "cpu percentage" : 24.673425 },
{ "id": 1, " time ":611 ,  "memory" : {"used" : 105112 , "max" : 224768 , "used percentage" : 46.764664 } , "cpu percentage" : 24.784887 },
{ "id": 1, " time ":712 ,  "memory" : {"used" : 107764 , "max" : 224768 , "used percentage" : 47.944547 } , "cpu percentage" : 34.039377 },
{ "id": 1, " time ":816 ,  "memory" : {"used" : 111743 , "max" : 224768 , "used percentage" : 49.714817 } , "cpu percentage" : 24.486800 },
{ "id": 1, " time ":918 ,  "memory" : {"used" : 115721 , "max" : 224768 , "used percentage" : 51.484642 } , "cpu percentage" : 24.512454 },
{ "id": 1, " time ":1018 ,  "memory" : {"used" : 119700 , "max" : 224768 , "used percentage" : 53.254912 } , "cpu percentage" : 24.196307 },
{ "id": 1, " time ":1120 ,  "memory" : {"used" : 122352 , "max" : 224768 , "used percentage" : 54.434795 } , "cpu percentage" : 24.329219 },
{ "id": 1, " time ":1156 ,  "memory" : {"used" : 123678 , "max" : 224768 , "used percentage" : 55.024737 } , "cpu percentage" : 24.683728 }] , 
"overall":{ "id": 1, "time":1156,"memoryMaxpercentage":55.024737,"cpuMaxPercentage":53.550941,"cpuAverage":26.630233} }

```


## installation

```xml
<dependency>
	<groupId>jp.spring-boot-reference</groupId>
	<artifactId>perpin</artifactId>
	<version>1.0.1</version>
</dependency>

```



