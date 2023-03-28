The project has 1000+ lines of codes.
Each file under the Test folder is conjoint with eachother, So please execute the test from TestNG.xml file

Web URL 	:https://testpages.herokuapp.com/styled/index.html

Automation  :Write automation test script for Drag and drop,alerts,events,Frames,HTML Tag Examples (Table test page, dynamic table test page)


TOOLS and FRAMEWORKS
--------------------

1) Eclipse IDE 
2) Selenium and Java
3) Webdriver
4) TestNG
5) Apache POI
6) Screenshot Interface
7) Extent Spark Reporter (HTML)



CLASS FILES CREATED
-------------------

---------------------------------------------------------------------------------------------------------------------------------------
|Category  |   Class FileName      |                      Description                                                                 |
---------------------------------------------------------------------------------------------------------------------------------------
|Base File | Base.class            | The funtions created to perform basic operations like opening and close the browser and 	        |
|	     |			     | navigating to the webpages												  |
|          ----------------------------------------------------------------------------------------------------------------------------
|	     |DataDriven.class       | To read the data stored in Excelsheets using Apache POI                                          |
|	     ----------------------------------------------------------------------------------------------------------------------------
|	     |prop.class		     | To read / write properties file (contains basic configuration for the project)	              |
| 	     ----------------------------------------------------------------------------------------------------------------------------
|	     |takeScreenshot.class   | To take screenshot and link to the HTML report in case of testcase failure				  |
---------------------------------------------------------------------------------------------------------------------------------------
|
|Testfile  |Alerts_DAD.class	     | Alerts, Fake alerts handling and drag and drop								        |
|	     ----------------------------------------------------------------------------------------------------------------------------
|(TestNG)  |Events.class	     | Event handling operations (JS): onpress, onclick,onhover, onmousedown, onmouseup, onkeydown,     |
|	     |                       |onkeyup, onleave, onkeypress, onfocus and so on                                                   |
|	     ----------------------------------------------------------------------------------------------------------------------------
|	     |Frames.class  	     | To switch into frames and to write the data into EXCEL file (Output folder)                      |
|	     ----------------------------------------------------------------------------------------------------------------------------
|	     |tableTags.class 	     | To write the table data into EXCEL file (Output folder)   			                          |
---------------------------------------------------------------------------------------------------------------------------------------
|XML	     | TestNG.xml		     | Configuration to the TestNG testfiles										  |
---------------------------------------------------------------------------------------------------------------------------------------
|Properties|configuration.property | Basic configuration for the project like browser name,URL							  |
---------------------------------------------------------------------------------------------------------------------------------------
|Spreadsheet|     |Test_Data.xlsx  | Stores all the locators. Access using Apache POI								  |
---------------------------------------------------------------------------------------------------------------------------------------

Note : Since individual Test files are created for every functionalities using TestNG, please Run the code from TestNG.xml file to run without hassle.


Created By: 
	LEELAKRISHNAN G (2163811)
	PAT,Cognizant.



















