rem this is just a normal batch file
rem you just have to set path bin path and run wsimport command

rem actual command is
rem set path="your bin path"
rem wsimport -p teamsC -keep http://localhost:8888/teams?wsdl

rem actual thing starts now..

@echo off
echo[
echo java path will be set
echo[
set path="C:\Program Files\Java\jdk1.8.0_202\bin"
echo java path has been set
echo[

echo[
echo wsimport is doing it's work
echo[
wsimport -p teamsC -keep http://localhost:8888/teams?wsdl
echo[
echo wsimport has done it's work
echo[
echo[

echo now drag and drop these files in netbeans content
echo[
echo you can also make your file here itself and code the normal way
pause