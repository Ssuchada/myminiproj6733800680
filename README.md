###  การรันโปรเจกต์

ใช้ คำสั่ง Maven บน Terminal

```bash
mvn spring-boot:run
```

เมื่อรันสำเร็จ Server จะทำงานที่ http://localhost:8080

---

### การเรียก API บน POSTMAN

### 1. ดูเมนูทั้งหมด

**GET**

```
http://localhost:8080/coffees
```

ตัวอย่าง Response

```json
[
  {
    "id": 1,
    "name": "Espresso",
    "price": 45.0
  },
  {
    "id": 2,
    "name": "Latte",
    "price": 55.0
  }
]
```

---

### 2. ดูเมนูตาม ID

**GET**

```
http://localhost:8080/coffees/1
```

ตัวอย่าง Response

```json
{
  "id": 1,
  "name": "Espresso",
  "price": 45.0
}
```

---

### 3. เพิ่มเมนู

**POST**

```
http://localhost:8080/coffees
```

Body

```json
{
  "name": "Cappuccino",
  "price": 60.0
}
```

ตัวอย่าง Response

```json
{
  "id": 3,
  "name": "Cappuccino",
  "price": 60.0
}
```

---

### 4. แก้ไขเมนู

**PUT**

```
http://localhost:8080/coffees/2
```

Request Body

```json
{
  "name": "Latte",
  "price": 50.0
}
```

ตัวอย่าง Response

```json
{
  "id": 2,
  "name": "Latte",
  "price": 50.0
}
```

---

### 5. ลบเมนู

**DELETE**

```
http://localhost:8080/coffees/3
```

หลังจากลบแล้วจะเหลือเมนู 2 รายการ
```json
[
  {
    "id": 1,
    "name": "Espresso",
    "price": 45.0
  },
  {
    "id": 2,
    "name": "Latte",
    "price": 50.0
  }
]
```
---
