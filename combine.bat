set catalina_home=d:\tomcat
set path=%path%;d:\Java64\jdk1.8.0_101\bin

set currentpath=.\
if "%OS%"=="Windows_NT" set currentpath=%~dp0%

set src=%currentpath%src
set dest=%currentpath%WebContent\WEB-INF\classes
set classpath=%catalina_home%\lib\servlet-api.jar;%catalina_home%\lib\jsp-api.jar

javac -sourcepath %src% -d %dest% %src%\mypack\DispatcherServlet.java
javac -sourcepath %src% -d %dest% %src%\mypack\HelloTag.java