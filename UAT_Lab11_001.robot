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

    Select From List By Label    id=make    BMW
    Input Text    id=engineperformance    110
    Input Text    id=dateofmanufacture    09/09/2020
    Select From List By Label    id=numberofseats    5
    Select From List By Label    id=fuel    Electric Power
    Input Text    id=listprice    30000
    Input Text    id=licenseplatenumber    CKK1234
    Input Text    id=annualmileage    10000

    Click Element    id=nextenterinsurantdata

TC 03 - Enter Insurance Data
    # Test Case 3
    Input Text    id=firstname    Wichai
    Input Text    id=lastname     Sandee
    Input Text    id=birthdate    01/31/1990
    Click Element    xpath=//label[.//input[@id='gendermale']]
    Input Text    id=streetaddress    KKU
    Select From List By Label    id=country    Thailand
    Input Text    id=zipcode     40002
    Input Text    id=city        Khon Kaen
    Select From List By Label    id=occupation    Employee
    Click Element    xpath=//label[.//input[@id='other']]

    Click Element    id=nextenterproductdata

TC 04 - Enter Product Data
    # Test Case 4
    Input Text    id=startdate    10/12/2026
    Select From List By Label    id=insurancesum     7.000.000,00
    Select From List By Label    id=meritrating      Bonus 1
    Select From List By Label    id=damageinsurance  No Coverage
    Click Element    xpath=//label[.//input[@id='EuroProtection']]
    Select From List By Label    id=courtesycar      Yes

    Click Element    id=nextselectpriceoption

TC 05 - Select Price Option
    # Test Case 5
    Click Element    xpath=//label[.//input[@id='selectsilver']]
    
    Sleep   0.5s

    Click Element    id=nextsendquote

TC 06 - Send Quote
    # Test Case 6
    Input Text    id=email    wichai.sandee@gmail.com
    Input Text    id=phone    0049201123456
    Input Text    id=username    wichai.sandee
    Input Password    id=password    SecretPassword123!
    Input Password    id=confirmpassword    SecretPassword123!
    Input Text    id=Comments    contact via email only

    Click Element    id=sendemail