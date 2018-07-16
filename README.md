
<h2>This project is test work for JazzTeam</h1>
<hr>
<h2>Description:</h2>
Allows to convert integer to its word representation.<br>
<hr>
<h2>Usage:</h2>
<pre>
NumberConverter nc = new NumberConverter();
String s = nc.asWords(987654321);
System.out.println(s);
</pre>
<br>
Output:
<pre>
девятьсот восемьдесят семь миллионов шестьсот пятьдесят четыре тысячи триста двадцать один
</pre>
<hr>
<h2>DDT Testing:</h2>
file testData.lst looks like:<br>
<pre>
0 = ноль
1 = один
-1 = минус один
2 = два
11 = одинадцать
15 = пятнадцать
164 = сто шестьдесят четыре
1000 = одна тысяча
2000 = две тысячи
2018 = две тысячи восемнадцать
10000 = десять тысяч
-65243 = минус шестьдесят пять тысяч двести сорок три
70000001 = семьдесят миллионов один
61888030084 = шестьдесят один миллиард восемьсот восемьдесят восемь миллионов тридцать тысяч восемьдесят четыре
</pre>
To add your test cases just add lines in format:<br>
<pre>
[number] = [word representation of number]
</pre>
to end of this file.<br>
<br>
<hr>
<h2>Testing framework:</h2>
JUnit 4.12 
<hr>
