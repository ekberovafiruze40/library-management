# 📚 Library Management System

Spring Boot və PostgreSQL istifadə edilərək hazırlanmış, **Layered Architecture** prinsiplərinə əsaslanan tam funksional **Library Management System RESTful API** layihəsidir.

Layihə kitabxana daxilində kitabların, müəlliflərin və üzvlərin idarə olunması üçün əsas CRUD əməliyyatlarını və əlavə API funksionallıqlarını təqdim edir.

---

## 🚀 Layihənin Xülasəsi

Sistem kitabxananın əsas idarəetmə proseslərini rəqəmsallaşdırmaq üçün hazırlanmışdır.

Layihədə aşağıdakı əsas modullar mövcuddur:

- **Book** – Kitabların əlavə edilməsi, məlumatlarının yenilənməsi, silinməsi və siyahılanması
- **Author** – Müəlliflərin qeydiyyatı və idarə olunması
- **Member** – Kitabxana üzvlərinin qeydiyyatı və idarə olunması

---

## 🛠️ İstifadə Edilən Texnologiyalar

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **PostgreSQL**
- **Springdoc OpenAPI (Swagger)**
- **Maven**

---

## ✨ Əsas Xüsusiyyətlər

### 🏗️ Layered Architecture

Layihədə aşağıdakı qatlı arxitektura strukturu tətbiq olunmuşdur:

**Controller → Service → Repository**

Kodun daha strukturlaşdırılmış, maintainable və genişləndirilə bilən olması üçün layihədə qatların məsuliyyətləri ayrılmışdır.

### 📦 DTO İstifadəsi

API sorğularında və cavablarında birbaşa Entity obyektlərindən istifadə edilməmiş, bunun əvəzinə **DTO (Data Transfer Object)** strukturlarından istifadə olunmuşdur.

### 🔄 CRUD Əməliyyatları

Book, Author və Member strukturları üçün tam CRUD əməliyyatları həyata keçirilmişdir:

- `GET` – Məlumatların əldə edilməsi
- `POST` – Yeni məlumatların əlavə edilməsi
- `PUT` – Mövcud məlumatların yenilənməsi
- `DELETE` – Məlumatların silinməsi

API response-larında uyğun HTTP status kodlarından istifadə olunmuşdur, məsələn:

- `200 OK`
- `201 Created`
- `204 No Content`
- `404 Not Found`

### ✅ Validasiya və Exception Handling

İstifadəçi tərəfindən daxil edilən məlumatların düzgünlüyünü yoxlamaq üçün Bean Validation annotasiyalarından, məsələn `@NotNull` və `@Size`, istifadə edilmişdir.

Xətaların mərkəzləşdirilmiş şəkildə idarə olunması üçün `@ControllerAdvice` ilə global exception handling mexanizmi tətbiq olunmuşdur.

### 📄 Pagination və Sorting

Çoxsaylı məlumatların daha effektiv idarə olunması üçün Spring Data-nın `Pageable` mexanizmindən istifadə edilərək **pagination və sorting** dəstəyi əlavə edilmişdir.

### 📖 API Documentation

API endpoint-lərinin rahat şəkildə görüntülənməsi və test edilməsi üçün **Swagger / OpenAPI** inteqrasiyası həyata keçirilmişdir.

---

## 🗄️ Database Configuration

Layihəni işlətmək üçün lokal mühitdə **PostgreSQL** verilənlər bazası yaradılmalıdır.

Default database adı:

```text
library_db
```

İstəyə uyğun olaraq fərqli database adı da istifadə edilə bilər.

`src/main/resources/application.yaml` faylında database məlumatlarını öz lokal mühitinizə uyğunlaşdırın:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/library_db
    username: your_db_user
    password: your_db_password

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

> **Qeyd:** `username` və `password` dəyərlərini öz PostgreSQL məlumatlarınızla əvəz edin.

---

## ▶️ Layihənin İşə Salınması

### 1. Repository-ni clone edin

```bash
git clone https://github.com/ekberovafiruze40/library-management.git
```

### 2. Layihə qovluğuna keçin

```bash
cd library-management
```

### 3. Database konfiqurasiyasını tənzimləyin

`application.yaml` faylında PostgreSQL bağlantı məlumatlarını qeyd edin.

### 4. Layihəni işə salın

Maven vasitəsilə:

```bash
mvn spring-boot:run
```

və ya layihəni **IntelliJ IDEA** üzərindən Spring Boot application olaraq başladın.

---

## 📖 Swagger UI

Tətbiqi lokalda işə saldıqdan sonra bütün API endpoint-lərini görüntüləmək və test etmək üçün Swagger UI-dan istifadə edə bilərsiniz:

**Swagger UI:**

```text
http://localhost:8080/swagger-ui/index.html
```

---

## 📌 Project Structure

```text
src
└── main
    ├── java
    │   └── az.edu.library.library_management
    │       ├── config
    │       ├── controllers
    │       ├── dtos
    │       │   ├── author
    │       │   ├── book
    │       │   └── member
    │       ├── models
    │       ├── repositories
    │       ├── services
    │       │   └── impls
    │       ├── GlobalExceptionHandler.java
    │       └── LibraryManagementApplication.java
    │
    └── resources
        ├── static
        ├── templates
        └── application.yaml
```

---

## 👩‍💻 Author

**Firuzə Əkbərova**

Java Backend Developer Intern
