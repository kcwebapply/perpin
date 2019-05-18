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

2019-05-18 11:46:20.877  INFO 28922 --- [           main] j.s.perpin.view.PerPinView               : 
####################################### 
contextId:1
time:1189 ms
memory:
   used:30467 KB
   max :401920 KB
   used percentage:7.580364 %
cpu percentage:27.220122 %
####################################### 

```


## installation

```xml
<dependency>
		<groupId>jp.spring-boot-reference</groupId>
		<artifactId>perpin</artifactId>
		<version>1.0.0</version>
</dependency>

```



