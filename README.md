 Library Management System

Spring Boot və PostgreSQL istifadə olunaraq hazırlanmış, qatlı arxitektura (layered architecture) prinsiplərinə əsaslanan, tam funksional kitabxana idarəetmə sistemi (RESTful API).

 🚀 Layihənin Xülasəsi və Proseslər
 
Bu sistem kitabxananın əsas əməliyyatlarını rəqəmsallaşdırmaq üçün nəzərdə tutulub. Layihədə əsasən aşağıdakı modullar və əlaqələr mövcuddur:
- Book (Kitab): Kitabların qeydiyyatı, məlumatlarının yenilənməsi, silinməsi və siyahılanması.
- Author (Müəllif): Kitabların müəllifləri ilə əlaqəli struktur və idarəetmə.
- Member (Üzv): Kitabxanadan istifadə edən oxucuların/üzvlərin qeydiyyatı və idarə olunması.

 🛠️ İstifadə Edilən Texnologiyalar
 - Java 17
 - Spring Boot
 - Spring Data JPA (Hibernate)
 - PostgreSQL
 - Springdoc OpenAPI (Swagger)
 - Maven

 ✨ Əsas Xüsusiyyətlər
- **Qatlı Arxitektura:** `Controller` → `Service` → `Repository` strukturu qorunub və birbaşa `Entity` əvəzinə `DTO` obyektlərindən istifadə edilib.
- **Tam CRUD Əməliyyatları:** Bütün strukturlar üçün GET, POST, PUT, DELETE sorğuları və düzgün HTTP status kodları (`201 Created`, `404 Not Found` və s.) tətbiq olunub.
- **Validasiya və Xəta İdarəetməsi:** `@NotNull`, `@Size` kimi validasiyalar və `@ControllerAdvice` ilə mərkəzləşdirilmiş səhv idarəetməsi qurulub.
- **Səhifələmə və Sıralama:** Çoxlu sayda məlumatların idarəsi üçün `Pageable` dəstəyi əlavə edilib.
- **API Sənədləşdirməsi:** Swagger (OpenAPI) vasitəsilə interaktiv sənəd interfeysi yaradılıb.
  
🗄️ Verilənlər Bazası (Database)

Layihənin işləməsi üçün PostgreSQL-də verilənlər bazası yaradılmalı və məlumatlar `application.yaml` faylında konfiqurasiya edilməlidir:
- Verilənlər bazası adı: `library_db` (və ya öz təyin etdiyiniz ad)
- Layihənin src/main/resources/application.yaml faylında verilənlər bazası məlumatlarını öz lokal mühitinizə uyğunlaşdırın:
  
  spring:
  
  datasource:
  
    url: jdbc:postgresql://localhost:5432/library_db
  
    username: your_db_user
  
    password: your_db_password
  
  jpa:
  
    hibernate:
  
      ddl-auto: update
  
    show-sql: true


  
📖 API Sənədləşdirməsi (Swagger UI)

Tətbiq işə düşdükdən sonra bütün endpointləri test etmək üçün aşağıdakı keçidə daxil ola bilərsiniz:
- `http://localhost:8080/swagger-ui/index.html`
