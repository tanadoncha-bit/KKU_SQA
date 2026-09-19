# Lab #8 – Integration Testing: Universal Converter

วิชา CP353201 Software Quality Assurance — Lab 8.1 / 8.2 / 8.3

## ภาพรวม

`UniversalConverter` เป็นโปรแกรมแปลงหน่วยที่รับค่ามาแล้วส่งต่อ (delegate)
ไปยังคลาสแปลงหน่วยที่เหมาะสมตามประเภทที่เลือก ได้แก่ **Distance**
(ระยะทาง), **Weight** (นํ้าหนัก), และ **Temperature** (อุณหภูมิ)
โปรเจกต์นี้ทำ Integration Testing ทั้งแบบ **Top-down (Depth-First)**
และ **Bottom-up** โดยใช้ JUnit 5

## โครงสร้างโปรแกรม (Program Structure)

```
Driver.main()
    └── UniversalConverter.convert()
            ├── DistanceConverter.convert()
            │       └── DistanceConverter.getMultiplier()
            ├── WeightConverter.convert()
            │       └── WeightConverter.getMultiplier()
            └── TemperatureConverter.convert()
```

ดูภาพ tree แบบเต็มได้ที่ `program_structure.png` หรือในเอกสาร
`Lab8_TestCase_Filled.docx`

## โครงสร้างไฟล์ในโปรเจกต์

```
src/
├── sqa/main/                        โค้ดโปรแกรมจริง (ของเดิมที่อาจารย์ให้)
│   ├── DistanceConverter.java
│   ├── WeightConverter.java
│   ├── TemperatureConverter.java
│   └── UniversalConverter.java
│
└── sqa/test/                        โค้ดทดสอบ + stub/driver ทั้งหมด
    ├── Driver.java                  (ของเดิม) จุดเริ่มโปรแกรมจริง เรียก UniversalConverter
    ├── Stub.java                    (ของเดิม) ตัวอย่าง stub สำหรับ DistanceConverter.getMultiplier
    ├── testWithStub.java            (ของเดิม) ตัวอย่าง test ที่ใช้ Stub.java
    │
    ├── StubDistanceConverter.java   สตับ DistanceConverter.getMultiplier() สำหรับ Top-down
    ├── StubWeightConverter.java     สตับ WeightConverter.getMultiplier() สำหรับ Top-down
    ├── TopDownIntegrationTest.java  ชุดทดสอบแบบ Top-down / Depth-First
    │
    ├── DistanceConverterDriver.java    Driver เรียก DistanceConverter.getMultiplier() ก่อนใคร
    ├── WeightConverterDriver.java      Driver เรียก WeightConverter.getMultiplier() ก่อนใคร
    ├── TemperatureConverterDriver.java Driver เรียก TemperatureConverter.convert() ก่อนใคร
    ├── UniversalConverterDriver.java   Driver จำลองการเรียกก่อนที่ UniversalConverter จะพร้อม
    └── BottomUpIntegrationTest.java    ชุดทดสอบแบบ Bottom-up
```

## ลำดับการทำ Integration

**Top-down (Depth-First):**
`UniversalConverter.convert()` → `DistanceConverter.convert()` →
`DistanceConverter.getMultiplier()` → `WeightConverter.convert()` →
`WeightConverter.getMultiplier()` → `TemperatureConverter.convert()`

**Bottom-up:**
`DistanceConverter.getMultiplier()` → `WeightConverter.getMultiplier()` →
`TemperatureConverter.convert()` → `DistanceConverter.convert()` →
`WeightConverter.convert()` → `UniversalConverter.convert()`

## ข้อจำกัดที่ควรทราบ

`UniversalConverter.convert()` สร้างอินสแตนซ์ของ `DistanceConverter`,
`WeightConverter`, และ `TemperatureConverter` ขึ้นมาเองโดยตรง
(`new ...()`) แทนที่จะรับเข้ามาผ่าน constructor หรือ setter ทำให้ไม่มี
"จุดฉีด" (injection point) ให้สลับเป็น stub object ได้จริงเมื่อทดสอบ
`UniversalConverter` เอง ดังนั้นชุดทดสอบระดับบนสุดใน
`TopDownIntegrationTest` จึงทดสอบโดยใช้ตัว collaborator จริง
และมีการยืนยันผลซ้ำอีกครั้งหลังจากแต่ละสาขาด้านล่างถูก integrate
และผ่านการทดสอบแล้ว ซึ่งสอดคล้องกับหลักการของ depth-first ที่จะเชื่อถือ
สาขาใดสาขาหนึ่งได้ก็ต่อเมื่อทุกอย่างที่อยู่ใต้สาขานั้นผ่านการทดสอบแล้ว

## วิธีรันเทสต์

ต้องมี JUnit 5 (Jupiter) อยู่ใน classpath

```bash
# ใช้ Maven (เพิ่ม junit-jupiter เป็น test dependency ใน pom.xml)
mvn test

# หรือใช้ JUnit Console launcher
javac -cp junit-platform-console-standalone.jar -d out $(find src -name "*.java")
java -jar junit-platform-console-standalone.jar -cp out --scan-classpath
```

หรือเปิดโปรเจกต์ด้วย IDE (Eclipse / IntelliJ) ที่มีปลั๊กอิน JUnit 5
แล้วรันคลาสทดสอบได้โดยตรง

## ไฟล์อื่นที่เกี่ยวข้อง (อยู่นอกโฟลเดอร์นี้)

- `Lab8_TestCase_Filled.docx` — เอกสาร template ที่กรอกครบแล้ว
  (ภาพ program structure, ตาราง top-down, ตาราง bottom-up)
- `program_structure.png` — ภาพ tree ของโครงสร้างโปรแกรม
