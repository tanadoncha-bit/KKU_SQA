*** Settings ***
Library  SeleniumLibrary
Suite Setup    Set Selenium Speed    ${DELAY}

*** Variables ***
${HOMEPAGE}    http://sampleapp.tricentis.com/
${BROWSER}     Edge
${DELAY}       0.1s

*** Test Cases ***
TC 01 - Open Insurance Main Page
    # Test Case 1
    Open Browser  ${HOMEPAGE}  ${BROWSER}
    Maximize Browser Window

TC 02 - Enter Vehicle Data for Automobile
    # Test Case 2
    Click Element    id=nav_automobile

    Select From List By Label    id=make    audi
    Input Text    id=engineperformance    abc
    Input Text    id=dateofmanufacture    99/99/2020
    Select From List By Label    id=numberofseats    9
    Select From List By Label    id=fuel    Electric Power
    Input Text    id=listprice    -5000
    Input Text    id=licenseplatenumber    @@@###
    Input Text    id=annualmileage    -1000

    Click Element    id=nextenterinsurantdata

TC 03 - Enter Insurance Data
    # Test Case 3
    Input Text    id=firstname    12345
    Input Text    id=lastname     @@@
    Input Text    id=birthdate    99/99/2000
    Click Element    xpath=//label[.//input[@id='genderfemale']]
    Input Text    id=streetaddress    !!!
    Select From List By Label    id=country    Thailand
    Input Text    id=zipcode     abcde
    Input Text    id=city        123456
    Select From List By Label    id=occupation    Employee
    Click Element    xpath=//label[.//input[@id='other']]

    Click Element    id=nextenterproductdata

TC 04 - Enter Product Data
    # Test Case 4
    Input Text    id=startdate    99/99/2026
    Select From List By Label    id=insurancesum     7.000.000,00
    Select From List By Label    id=meritrating      Bonus 1
    Select From List By Label    id=damageinsurance  No Coverage
    Click Element    xpath=//label[.//input[@id='EuroProtection']]
    Select From List By Label    id=courtesycar      Yes

    Click Element    id=nextselectpriceoption

    