# ui-automation-framework-base

UI Test Automation frameworks are very popular, but when it comes to the quality of code,
scarcity of OOP concepts, the code tightly coupled with the automation framework's keywords
and lack of simplicity emerged.

In this project, I have separated the testing logic away from the third party library (Selenium), mainly from its keywords. 
This will ease the integration of other UI test automation frameworks with the same testing logic or replace 
the existing one.
In a nut shell, Your UI testing logic is portable among any UI automation frameworks, if you use this code initially.

###[Setup Guide]
Change driver location here:- java.framework.mappings.SeleniumWebDriver.openWebBrowser()
