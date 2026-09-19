# \# Lab 5 - Equivalence Class Testing

# 

# รายวิชา \*\*CP353201 Software Quality Assurance\*\*

# 

# โปรเจกต์นี้เป็นส่วนหนึ่งของ Lab #5 เรื่อง \*\*Equivalence Class Testing\*\* โดยมีวัตถุประสงค์เพื่อออกแบบ Test Case และเขียน Unit Test ด้วย \*\*JUnit 6\*\* โดยใช้ `@ParameterizedTest` สำหรับการทดสอบอัตโนมัติ

# 

# ภายใน Lab นี้ประกอบด้วย 2 กิจกรรม ได้แก่

# 

# 1\. \*\*Lab 5.1 - Shift Cipher\*\*

# 2\. \*\*Lab 5.2 - Competition Score\*\*

# 

# \---

# 

# \## Project Structure

# 

# ```text

# SQA\_Lab5/

# │

# ├── Competition/

# │   ├── src/

# │   │   ├── main/

# │   │   │   └── com/sqa/lab/

# │   │   │       └── CompetitionScore.java

# │   │   │

# │   │   └── test/

# │   │       └── com/sqa/lab/

# │   │           └── CompetitionScoreTest.java

# │   │

# │   ├── .classpath

# │   ├── .project

# │   └── .settings/

# │

# ├── ShiftCipher/

# │   ├── src/

# │   │   ├── main/

# │   │   │   └── com/sqa/lab/

# │   │   │       └── ShiftCipher.java

# │   │   │

# │   │   └── test/

# │   │       └── com/sqa/lab/

# │   │           ├── ShiftCipherEncryptionTest.java

# │   │           └── ShiftCipherDecryptionTest.java

# │   │

# │   ├── .classpath

# │   ├── .project

# │   └── .settings/

# │

# ├── \[Ex]Lab5\_EC\_673380585-0.xlsx

# └── README.md

# ```

# 

# \---

# 

# \# Lab 5.1 - Shift Cipher

# 

# \## Description

# 

# Shift Cipher เป็นอัลกอริทึมสำหรับการเข้ารหัสและถอดรหัสข้อความ โดยทำการเลื่อนตำแหน่งของตัวอักษรตามค่า `key`

# 

# การเข้ารหัสใช้สมการ:

# 

# ```text

# Eₖ(x) = (x + k) mod 26

# ```

# 

# การถอดรหัสใช้สมการ:

# 

# ```text

# Dₖ(y) = (y - k) mod 26

# ```

# 

# โดย:

# 

# \* ข้อความต้องประกอบด้วยตัวอักษร `A-Z`

# \* `key` ต้องเป็นชนิด `Integer`

# \* `key` สามารถเป็นค่าบวกหรือค่าลบได้

# 

# ตัวอย่าง:

# 

# ```text

# Plain Text: ATTACK

# Key: 17

# 

# Cipher Text: RKKRTB

# ```

# 

# \---

# 

# \## Testing Strategy

# 

# ใช้ \*\*Weak Robust Equivalence Class Testing\*\*

# 

# โดยแบ่ง Input ออกเป็นกลุ่มที่เป็น:

# 

# \### Valid Equivalence Classes

# 

# \* ข้อความประกอบด้วยตัวอักษร A-Z

# \* Key = 0

# \* Key เป็นจำนวนเต็มบวก

# \* Key เป็นจำนวนเต็มลบ

# 

# \### Invalid Equivalence Classes

# 

# \* ข้อความมีตัวเลข

# \* ข้อความมีอักขระพิเศษ

# \* ข้อความว่าง

# \* ข้อความมีตัวอักษรพิมพ์เล็ก

# \* Key มีตัวอักษร

# \* Key มีอักขระพิเศษ

# \* Key เป็นค่าว่าง

# \* Key มีค่าเกิน Maximum Integer

# 

# \---

# 

# \## Test Classes

# 

# \### Encryption

# 

# ```text

# ShiftCipherEncryptionTest.java

# ```

# 

# ใช้สำหรับทดสอบการเข้ารหัสข้อความ

# 

# \### Decryption

# 

# ```text

# ShiftCipherDecryptionTest.java

# ```

# 

# ใช้สำหรับทดสอบการถอดรหัสข้อความ

# 

# การทดสอบใช้ `@ParameterizedTest` เพื่อให้สามารถทดสอบหลาย Test Cases ด้วย Test Method เดียว

# 

# \---

# 

# \# Lab 5.2 - Competition Score

# 

# \## Description

# 

# โปรแกรม `CompetitionScore` ใช้สำหรับหาคะแนนสูงสุดจากการทำข้อสอบ 3 ครั้ง

# 

# คะแนนสูงสุดที่เป็นไปได้ในแต่ละรอบคือ:

# 

# ```text

# 0 - 500 คะแนน

# ```

# 

# โปรแกรมรองรับการเรียกใช้ 2 รูปแบบ:

# 

# ```java

# findMaxScore(int\[] scores)

# ```

# 

# และ

# 

# ```java

# findMaxScore(int score1, int score2, int score3)

# ```

# 

# ทั้งสอง Method มีหน้าที่หาคะแนนสูงสุดจากคะแนนสอบทั้ง 3 ครั้ง

# 

# ตัวอย่าง:

# 

# ```text

# Input:

# 100, 200, 300

# 

# Output:

# 300

# ```

# 

# \---

# 

# \## Testing Strategy

# 

# ใช้ \*\*Strong Robust Equivalence Class Testing\*\*

# 

# โดยแบ่ง Input ออกเป็น Valid และ Invalid Equivalence Classes

# 

# \### Valid Equivalence Classes

# 

# \* score1 อยู่ในช่วง 0–500

# \* score2 อยู่ในช่วง 0–500

# \* score3 อยู่ในช่วง 0–500

# \* Array มีสมาชิก 3 ค่า

# 

# \### Invalid Equivalence Classes

# 

# \* score1 < 0

# \* score2 < 0

# \* score3 < 0

# \* score1 > 500

# \* score2 > 500

# \* score3 > 500

# \* Array มีสมาชิกน้อยกว่า 3 ค่า

# \* Array มีสมาชิกมากกว่า 3 ค่า

# 

# \---

# 

# \# Testing Framework

# 

# โปรเจกต์นี้ใช้:

# 

# \* \*\*Java\*\*

# \* \*\*JUnit 6\*\*

# \* \*\*Eclipse IDE\*\*

# \* `@ParameterizedTest`

# 

# ตัวอย่างรูปแบบการทดสอบ:

# 

# ```java

# @ParameterizedTest

# @CsvSource({

# &#x20;   "ABC, 0, ABC",

# &#x20;   "BOOM, 17, SFFD"

# })

# void testEncryption(String input, int key, String expected) {

# &#x20;   // Test implementation

# }

# ```

# 

# \---

# 

# \# Test Result Summary

# 

# | Project                  | Test Cases |   Pass |  Fail | No Run |

# | ------------------------ | ---------: | -----: | ----: | -----: |

# | ShiftCipher - Encryption |         10 |      6 |     2 |      2 |

# | ShiftCipher - Decryption |         10 |      6 |     2 |      2 |

# | CompetitionScore         |         16 |     16 |     0 |      0 |

# | \*\*Total\*\*                |     \*\*36\*\* | \*\*28\*\* | \*\*4\*\* |  \*\*4\*\* |

# 

# \---

# 

# \# Defect Found

# 

# \## D001 - Lowercase Character Validation

# 

# \### Description

# 

# ระบบยอมรับข้อความที่มีตัวอักษรพิมพ์เล็ก เช่น:

# 

# ```text

# abc

# ```

# 

# และสามารถเข้ารหัสเป็น:

# 

# ```text

# JKL

# ```

# 

# ได้

# 

# แต่ตาม Requirement ข้อความต้องประกอบด้วยตัวอักษร `A-Z` เท่านั้น ดังนั้น Input ที่มีตัวอักษรพิมพ์เล็กควรเป็น Invalid และควรโยน:

# 

# ```text

# IllegalArgumentException

# ```

# 

# \### Severity

# 

# Medium

# 

# \### Priority

# 

# Medium

# 

# \### Status

# 

# New

# 

# \---

# 

# \# Test Documentation

# 

# ไฟล์:

# 

# ```text

# \[Ex]Lab5\_EC\_673380585-0.xlsx

# ```

# 

# ใช้สำหรับบันทึก:

# 

# \* Equivalence Class Design

# \* Test Case Design

# \* Test Results

# \* Defect Report

# \* Test Summary

# 

# \---

# 

# \# Author

# 

# \*\*Name:\*\* ธนดล ไชยศิลา

# 

# \*\*Student ID:\*\* 673380585-0

# 

# \*\*Course:\*\* CP353201 Software Quality Assurance



