# Full Stack Flights
## A full-stack (React(HTML, CSS, JS)/Spring(Java)/MySQL), proof of concept app for registering flights

Completed in 2022 within a week as a final project for a bootcamp-esque pre-employment training program. Intended for desktop. Recommended for local testing by opening SpringBackend in Spring Tool Suite then following SQLInfo to create needed database and tables. Once backend is deployed on local port and db is accessible, react-frontend can be deployed via npm start on port 3000. Uses root and uncomplex password for db access (not intended to be secure, just a simple proof of concept app). 

## Contains the following features:

- Searchable flight travel API via Amadeus (Search may take up to a 10-15 seconds, preloaded with potential search)
- Table of results displated on internal scroll
- Alerts to user to indicate whether they are logged in and able to add flights
- User login/registration
- Form validation for username and password
- Axios API with React to interface with the backend
- ORM to relate received flights to model classes
- Internally written SQL queries for backend repository classes
- User adding and removing flights
- Admin mode w/ alternate theme by logging in with username:admin password:admin (again, for testing purposes)
- Navbar/routing via React 
- Font awesome icons
- Handdrawn buttons!

(A few more images than shown below of the app in use can be found in the FullStackFlightsImages folder)

## Login screen
![login screen for app](https://raw.githubusercontent.com/adambpena/Flight-Tracker/main/FullStackFlightsImages/login.PNG)

## Flight search results displayed in table
![Flight search results in table with the option to add flights](https://raw.githubusercontent.com/adambpena/Flight-Tracker/main/FullStackFlightsImages/flightSearch.PNG)

## Admin Login w/ Alternate Theme
![Admin view of app with black and green terminal esque coloring on navbar and footer](https://raw.githubusercontent.com/adambpena/Flight-Tracker/main/FullStackFlightsImages/adminLogin.PNG)

## User management screen (admin specific)
![Screen with table of registered users to view and delete](![Uploading image.png…](https://raw.githubusercontent.com/adambpena/Flight-Tracker/main/FullStackFlightsImages/userManage.PNG)

## Out of Bounds screen (Unrecognized path within host)
![gif of a skeleton with prompt informing user they are out of bounds](https://raw.githubusercontent.com/adambpena/Flight-Tracker/main/FullStackFlightsImages/oob.PNG)
