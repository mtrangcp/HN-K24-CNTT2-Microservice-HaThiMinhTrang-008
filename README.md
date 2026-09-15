## I. HƯỚNG DẪN KHỞI CHẠY

### 1. Khởi chạy `config-server` (Cổng 8888)
### 2. Khởi chạy `eureka-server` (Cổng 8761)
### 3. Khởi chạy `api-gateway` (Cổng 8080)
### 4. Khởi chạy `category-service` (Cổng 8081)
### 5. Khởi chạy `product-service` (Cổng 8082)

## II. DANH SÁCH API 

### 1. Tạo mới danh mục (Category)
- **HTTP Method**: `POST`
- **URL**: `http://localhost:8080/api/categories`
- **Header**: `Content-Type: application/json`
- **Body**:
  ```json
  {
    "name": "Điện thoại",
    "description": "Các thiết bị di động thông minh"
  }
  ```
- **Response**: `201 Created`

### 2. Lấy thông tin danh mục theo ID
- **HTTP Method**: `GET`
- **URL**: `http://localhost:8080/api/categories/1`
- **Response**: `200 OK`

---

### 3. Thêm mới sản phẩm THÀNH CÔNG (categoryId hợp lệ)
- **HTTP Method**: `POST`
- **URL**: `http://localhost:8080/api/products`
- **Header**: `Content-Type: application/json`
- **Body**:
  ```json
  {
    "name": "Sản phẩm A",
    "price": 15000000,
    "categoryId": 1
  }
  ```
- **Response**: `201 Created`
  ```json
  {
    "id": 1,
    "name": "Sản phẩm A",
    "price": 15000000.0,
    "categoryId": 1
  }
  ```

---

### 4. Thêm mới sản phẩm THẤT BẠI (categoryId không tồn tại)
- **HTTP Method**: `POST`
- **URL**: `http://localhost:8080/api/products`
- **Header**: `Content-Type: application/json`
- **Body**:
  ```json
  {
    "name": "Sản phẩm B",
    "price": 20000000,
    "categoryId": 9999
  }
  ```
- **Response**: `404 Not Found`
- **Body Response**:
  ```json
  {
    "status": 404,
    "message": "Danh mục không tồn tại hoặc không hợp lệ.",
    "error": "Category Not Found"
  }
  ```

---

### 5. Lấy danh sách sản phẩm THÀNH CÔNG
- **HTTP Method**: `GET`
- **URL**: `http://localhost:8080/api/products`
- **Response**: `200 OK`
  ```json
  [
    {
      "id": 1,
      "name": "Sản phẩm A",
      "price": 15000000.0,
      "categoryId": 1
    }
  ]
  ```

