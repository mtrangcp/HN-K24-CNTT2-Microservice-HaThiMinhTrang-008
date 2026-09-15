## I. HƯỚNG DẪN KHỞI CHẠY

### 1. Khởi chạy `config-server` (Cổng 8888)
### 2. Khởi chạy `eureka-server` (Cổng 8761)
### 3. Khởi chạy `api-gateway` (Cổng 8080)
### 4. Khởi chạy `category-service` (Cổng 8081)
### 5. Khởi chạy `product-service` (Cổng 8082)

## II. DANH SÁCH API 

### 1. Tạo mới Tổ chức
- **HTTP Method**: `POST`
- **URL**: `http://localhost:8080/api/organizers`
- **Header**: `Content-Type: application/json`
- **Body**:
  ```json
  {
    "name": "FPT",
    "description": "To chua su kien FPT"
  }
  ```
- **Response**: `201 Created`

### 2. Lấy thông tin tổ chức theo ID
- **HTTP Method**: `GET`
- **URL**: `http://localhost:8080/api/organizers/1`
- **Response**: `200 OK`

---

### 3. Thêm mới event THÀNH CÔNG 
- **HTTP Method**: `POST`
- **URL**: `http://localhost:8080/api/events`
- **Header**: `Content-Type: application/json`
- **Body**:
  ```json
  {
    "name": "Su kien 20/11 PTIT 222",
    "description": "Su kien chao mung 20/11 tai PTIT 222",
    "organizerId": 1
  }
  ```
- **Response**: `201 Created`
  ```json
  {
    "id": 1,
    "name": "Su kien 20/11 PTIT 222",
    "description": "Su kien chao mung 20/11 tai PTIT 222",
    "organizerId": 1
  }
  ```

---

### 4. Thêm mới event THẤT BẠI 
- **HTTP Method**: `POST`
- **URL**: `http://localhost:8080/api/events`
- **Header**: `Content-Type: application/json`
- **Body**:
  ```json
  {
    "name": "Su kien 20/11 PTIT 222",
    "description": "Su kien chao mung 20/11 tai PTIT 222",
    "organizerId": 99
  }
  ```
- **Response**: `404 Not Found`
- **Body Response**:
  ```json
  {
    "status": 404,
    "message": "Tổ chưức không tồn tại hoặc không hợp lệ.",
    "error": "Organizer Not Found"
  }
  ```

---

### 5. Lấy danh sách event THÀNH CÔNG
- **HTTP Method**: `GET`
- **URL**: `http://localhost:8080/api/events`
- **Response**: `200 OK`


