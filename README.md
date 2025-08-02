
# 🛍️ E-Commerce Android App

This is a fully functional **E-Commerce Android App** built using **Java** and **Firebase Realtime Database**. It allows users to explore products, manage a shopping cart, view orders, and manage their profile — all in a clean and responsive UI.
## 🌐 App Flow Overview

1. **Welcome Screen**  
2. **Login / Register**  
3. **MainActivity** opens after successful login  
   - Shows:
     - **Admin Portal** button (for adding products)
     - **Customer Portal** button (to view product list)
     - **Bottom Navigation**: Home | Cart | Account
## ✅ Features

- 👋 **Welcome, Login, and Register screens**
  - User-friendly onboarding and secure authentication using Firebase
- 🏠 **Main Home Screen**
  - Admin Portal to add new products  
  - Customer Portal to view all added products
- 🛍️ **Admin Portal**
  - Add product with name, price, and image
  - Stores product data in Firebase Realtime Database
- 🛒 **Customer Portal**
  - View all admin-added products in list format
  - Show products with image and price
- 🃏 **Card View (Show Cart)**
  - Card-style layout of added products
  - Remove items from cart
  - Real-time **total amount** calculation
- 🧭 **Bottom Navigation Bar**
  - **Home:** Shows manual and admin-added products
  - **Cart:** Shows cart items with remove option and total amount
  - **Account:** User profile and order history
- 👤 **Account Page**
  - Displays user image, name, and country
  -  Section: **Your Orders**
  - If no orders: _“Hi, You have no recent orders”_
  - If orders exist:
    - Shows Product Name, Date/Time, and Price.
- Includes **Go To Home** button for easy navigation.

- ☁️ **Firebase Realtime Database Integration**
  - Live updates and data sync
- 🎯 Clean UI with Material Design principles
## 🛠️ Tech Stack

- **Language:** Java  
- **Backend:** Firebase Realtime Database  
- **IDE:** Android Studio  
- **UI:** XML layout


## Demo


## 🚀 How to Run

1. Clone the repo:
   ```bash
   git clone https://github.com/Vaishnavipawar765/EcommerceApp
