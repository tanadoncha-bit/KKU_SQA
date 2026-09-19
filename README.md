# Lab 5 - Equivalence Class Testing

**รายวิชา:** CP353201 Software Quality Assurance

โปรเจกต์นี้เป็นส่วนหนึ่งของ **Lab 5 เรื่อง Equivalence Class Testing** โดยมีวัตถุประสงค์เพื่อออกแบบ Test Case และเขียน Unit Test ด้วย **JUnit 6** โดยใช้ `@ParameterizedTest` สำหรับการทดสอบอัตโนมัติ

ภายใน Lab นี้ประกอบด้วย 2 กิจกรรม ได้แก่

1. **Lab 5.1 - Shift Cipher**
2. **Lab 5.2 - Competition Score**

---

## Project Structure

```text
SQA_Lab5/
│
├── Competition/
│   ├── src/
│   │   ├── main/
│   │   │   └── com/sqa/lab/
│   │   │       └── CompetitionScore.java
│   │   │
│   │   └── test/
│   │       └── com/sqa/lab/
│   │           └── CompetitionScoreTest.java
│   │
│   ├── .classpath
│   ├── .project
│   └── .settings/
│
├── ShiftCipher/
│   ├── src/
│   │   ├── main/
│   │   │   └── com/sqa/lab/
│   │   │       └── ShiftCipher.java
│   │   │
│   │   └── test/
│   │       └── com/sqa/lab/
│   │           ├── ShiftCipherEncryptionTest.java
│   │           └── ShiftCipherDecryptionTest.java
│   │
│   ├── .classpath
│   ├── .project
│   └── .settings/
│
├── [Ex]Lab5_EC_673380585-0.xlsx
└── README.md
```

---

# Lab 5.1 - Shift Cipher

## Description

**Shift Cipher** เป็นอัลกอริทึมสำหรับการเข้ารหัสและถอดรหัสข้อความ โดยทำการเลื่อนตำแหน่งของตัวอักษรตามค่า `key`

### Encryption

การเข้ารหัสใช้สมการ:

```text
Eₖ(x) = (x + k) mod 26
```

### Decryption

การถอดรหัสใช้สมการ:

```text
Dₖ(y) = (y - k) mod 26
```

### Input Requirements

* ข้อความต้องประกอบด้วยตัวอักษร `A-Z`
* `key` ต้องเป็นชนิด `Integer`
* `key` สามารถเป็นค่าบวกหรือค่าลบได้

### Example

```text
Plain Text: ATTACK
Key: 17

Cipher Text: RKKRTB
```

---

## Testing Strategy

ใช้ **Weak Robust Equivalence Class Testing**

โดยแบ่ง Input ออกเป็นกลุ่มที่เป็น **Valid** และ **Invalid Equivalence Classes**

### Valid Equivalence Classes

| ID | Equivalence Class               |
| -- | ------------------------------- |
| V1 | ข้อความประกอบด้วยตัวอักษร `A-Z` |
| V2 | `Key = 0`                       |
| V3 | `Key` เป็นจำนวนเต็มบวก          |
| V4 | `Key` เป็นจำนวนเต็มลบ           |

### Invalid Equivalence Classes

| ID | Equivalence Class             |
| -- | ----------------------------- |
| I1 | ข้อความมีตัวเลข               |
| I2 | ข้อความมีอักขระพิเศษ          |
| I3 | ข้อความว่าง                   |
| I4 | ข้อความมีตัวอักษรพิมพ์เล็ก    |
| I5 | Key มีตัวอักษร                |
| I6 | Key มีอักขระพิเศษ             |
| I7 | Key เป็นค่าว่าง               |
| I8 | Key มีค่าเกิน Maximum Integer |

---

## Test Classes

### Encryption

ไฟล์:

```text
ShiftCipherEncryptionTest.java
```

ใช้สำหรับทดสอบการเข้ารหัสข้อความด้วย Shift Cipher

### Decryption

ไฟล์:

```text
ShiftCipherDecryptionTest.java
```

ใช้สำหรับทดสอบการถอดรหัสข้อความด้วย Shift Cipher

ทั้งสอง Test Class ใช้ `@ParameterizedTest` เพื่อให้สามารถทดสอบหลาย Test Cases ด้วย Test Method เดียว

ตัวอย่าง:

```java
@ParameterizedTest
@CsvSource({
    "ABC, 0, ABC",
    "BOOM, 17, SFFD"
})
void testEncryption(String input, int key, String expected) {
    // Test implementation
}
```

---

# Lab 5.2 - Competition Score

## Description

โปรแกรม `CompetitionScore` ใช้สำหรับหาคะแนนสูงสุดจากการทำข้อสอบ 3 ครั้ง

คะแนนที่เป็นไปได้ในแต่ละรอบคือ:

```text
0 - 500 คะแนน
```

โปรแกรมรองรับการเรียกใช้ 2 รูปแบบ:

```java
findMaxScore(int[] scores)
```

และ

```java
findMaxScore(int score1, int score2, int score3)
```

ทั้งสอง Method มีหน้าที่หาคะแนนสูงสุดจากคะแนนสอบทั้ง 3 ครั้ง

### Example

```text
Input:
100, 200, 300

Output:
300
```

---

## Testing Strategy

ใช้ **Strong Robust Equivalence Class Testing**

โดยแบ่ง Input ออกเป็น **Valid** และ **Invalid Equivalence Classes**

### Valid Equivalence Classes

| ID | Equivalence Class         |
| -- | ------------------------- |
| V1 | `score1` อยู่ในช่วง 0–500 |
| V2 | `score2` อยู่ในช่วง 0–500 |
| V3 | `score3` อยู่ในช่วง 0–500 |
| V4 | Array มีสมาชิก 3 ค่า      |

### Invalid Equivalence Classes

| ID | Equivalence Class            |
| -- | ---------------------------- |
| I1 | `score1 < 0`                 |
| I2 | `score2 < 0`                 |
| I3 | `score3 < 0`                 |
| I4 | `score1 > 500`               |
| I5 | `score2 > 500`               |
| I6 | `score3 > 500`               |
| I7 | Array มีสมาชิกน้อยกว่า 3 ค่า |
| I8 | Array มีสมาชิกมากกว่า 3 ค่า  |

---

# Testing Framework

โปรเจกต์นี้ใช้เทคโนโลยีและเครื่องมือดังต่อไปนี้:

* **Java**
* **JUnit 6**
* **Eclipse IDE**
* **Parameterized Test**
* `@ParameterizedTest`
* `@CsvSource`

ตัวอย่าง:

```java
@ParameterizedTest
@CsvSource({
    "ABC, 0, ABC",
    "BOOM, 17, SFFD"
})
void testEncryption(String input, int key, String expected) {
    // Test implementation
}
```

---

# Test Result Summary

| Project                  | Test Cases |   Pass |  Fail | No Run |
| ------------------------ | ---------: | -----: | ----: | -----: |
| ShiftCipher - Encryption |         10 |      6 |     2 |      2 |
| ShiftCipher - Decryption |         10 |      6 |     2 |      2 |
| CompetitionScore         |         16 |     16 |     0 |      0 |
| **Total**                |     **36** | **28** | **4** |  **4** |

---

# Defect Found

## D001 - Lowercase Character Validation

### Description

พบว่าโปรแกรมยอมรับข้อความที่มีตัวอักษรพิมพ์เล็ก เช่น:

```text
abc
```

และสามารถเข้ารหัสเป็น:

```text
JKL
```

ได้

อย่างไรก็ตาม Requirement ระบุว่าข้อความต้องประกอบด้วยตัวอักษร `A-Z` เท่านั้น ดังนั้น Input ที่มีตัวอักษรพิมพ์เล็กควรถูกจัดเป็น **Invalid Input**

โปรแกรมควรโยน Exception:

```java
IllegalArgumentException
```

### Expected Behavior

```text
Input:
abc

Expected:
IllegalArgumentException
```

### Actual Behavior

```text
Input:
abc

Actual:
JKL
```

### Severity

**Medium**

### Priority

**Medium**

### Status

**New**

---

# Test Documentation

ไฟล์:

```text
[Ex]Lab5_EC_673380585-0.xlsx
```

ใช้สำหรับบันทึกข้อมูลเกี่ยวกับการทดสอบ ได้แก่:

* Equivalence Class Design
* Test Case Design
* Test Results
* Defect Report
* Test Summary

---

# Author

**Name:** ธนดล ไชยศิลา

**Student ID:** 673380585-0

**Course:** CP353201 Software Quality Assurance
