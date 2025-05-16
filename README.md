
# HOW TO RUN
Note : Docker must installed and running in the system<br/>
cd [PATH TO PROJECT]<br/>
docker-compose down && docker-compose up<br/>

Note : I am learning about Software Development, Devops and AI from this book. Here is the book link : https://www.amazon.com/dp/B0F1Z4LDDH (50 microsaas startup ideas) <br/>

To design a system for calculating wasted food in a restaurant, we’ll create a model that takes grocery quantities and the number of plates sold as inputs. The goal is to compare the quantity of food ordered with the quantity of food actually used, calculating the waste based on any discrepancies. <br/>

Here's a software design approach to achieve this: <br/>

1. Requirements Analysis <br/>
Functional Requirements <br/>
Accept user input for groceries ordered (type and quantity). <br/>
Track the number of plates sold. <br/>
Calculate and display the quantity of wasted food. <br/>
Provide reporting and analytics, including summaries by day, week, or month. <br/>
Non-Functional Requirements <br/>
Usability: Interface should be simple and intuitive for restaurant staff to input data. <br/>
Scalability: Design should support multiple restaurants or outlets. <br/>
Performance: Calculations should be quick and responsive. <br/>
Security: Data should be secured as it may contain sensitive information about food costs. <br/>

2. Data Model <br/>
Define the entities and their relationships. <br/>

# GroceryOrder <br/>

Fields: orderId, item, quantityOrdered, date <br/>
Description: Represents an order of groceries, including item name, quantity ordered, and order date. <br/>
PlateSales <br/>

Fields: salesId, plateType, quantitySold, date <br/>
Description: Represents the number of plates sold for each plate type on a particular date. <br/>
WastedFood <br/>

Fields: wasteId, item, quantityWasted, date <br/>
Description: Stores the calculated amount of food waste per item on each date. <br/>
FoodUsageRate (optional, configurable) <br/>

Fields: item, averageUsagePerPlate <br/>
Description: Contains predefined values indicating the average usage of a specific item per plate. Used for estimating expected food usage. <br/>

3. System Workflow <br/>
Input Data: <br/>

Staff inputs daily grocery quantities ordered (by item). <br/>
Staff inputs daily sales data (number of plates sold by type). <br/>
Calculate Expected Food Usage: <br/>

Multiply the number of plates sold by the average quantity of each grocery item expected per plate. <br/>
For example, if each plate uses 100g of rice and 50 plates are sold, the expected rice usage is 50 * 100g = 5000g. <br/>
Calculate Wasted Food: <br/>

Compare the quantityOrdered (from GroceryOrder) with quantityUsed (calculated from PlateSales and FoodUsageRate). <br/>
Waste is calculated as: <br/>
quantityWasted <br/>
=
quantityOrdered <br/>
−
quantityUsed <br/>
quantityWasted=quantityOrdered−quantityUsed <br/>
Save Waste Data:

Store the calculated waste data in the WastedFood entity. <br/>
Generate Reports: <br/>

Generate reports to view wasted food by date, item, or period (e.g., weekly, monthly). <br/>
Optional: Display trends in waste reduction over time. <br/>
4. High-Level Architecture <br/>
Components: <br/>

User Interface (UI): Provides forms for inputting grocery orders and plate sales, as well as a dashboard for waste reporting. <br/>
Backend Service: A REST API built with Java Spring Boot or FastAPI to handle CRUD operations and calculations. <br/>
Database: A relational database (e.g., PostgreSQL) to store GroceryOrder, PlateSales, WastedFood, and FoodUsageRate tables. <br/>
Analytics and Reporting: Basic reporting views and charts (using libraries like Chart.js) or more complex reporting through Grafana. <br/>
5. Data Flow Diagram <br/>
Here’s a basic data flow: <br/>

Data Entry: Staff enters GroceryOrder and PlateSales data via the UI. <br/>
Data Processing: <br/>
Backend service retrieves daily data and performs the Expected Food Usage calculation.<br/>
Backend service computes WastedFood and stores the results. <br/>
Display Results: The system displays waste metrics on the UI, with daily/weekly/monthly breakdowns. <br/>
6. Tech Stack <br/>
Backend: Java Spring Boot (or Python FastAPI) <br/>
Database: PostgreSQL or MySQL <br/>
Frontend: React or Angular for user interface and reporting dashboard <br/>
Reporting: Chart.js for visualizations, Grafana for advanced analytics <br/>
Hosting: Docker and Kubernetes for deployment in a cloud environment like AWS or Azure <br/>
7. Sample API Endpoints <br/>
Grocery Orders <br/>

POST /api/groceries: Add a grocery order <br/>
GET /api/groceries/{date}: Get grocery orders for a specific date <br/>
Plate Sales <br/>

POST /api/sales: Record plates sold <br/>
GET /api/sales/{date}: Retrieve plate sales data for a specific date <br/>
Waste Calculation <br/>

GET /api/waste/{date}: Retrieve calculated waste for a given date <br/>
GET /api/waste/report?start={date}&end={date}: Retrieve waste report over a range of dates <br/>
8. Example Calculation <br/>
Input:

Grocery Order: Rice = 6000g <br/>
Plates Sold: 50 <br/>
Average Rice Per Plate: 100g <br/>
Expected Usage: <br/>

50 plates * 100g = 5000g <br/>
Waste Calculation: <br/>

Waste = 6000g - 5000g = 1000g <br/>
This data is stored in the WastedFood table and can be reported daily or periodically to help the restaurant track and minimize waste over time. <br/>
