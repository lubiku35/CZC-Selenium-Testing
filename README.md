
<br>

# CZC - Selenium Website Testing | Semester Project


> **Author** | Ľuboslav Motošický, @lubiku35
>
> **Subject** | Software Testing
>
> **Project Name** | CZC - Selenium Website Testing 

<br>

# Project Introduction

Welcome to my Selenium Website Testing project! In this endeavor, I have undertaken the task of ensuring the quality and reliability of the website https://www.czc.cz/. I have chosen this website as the target for my testing efforts due to its popularity and the diverse functionalities it offers.

Throughout this project, I have conducted a comprehensive range of tests, starting from basic ones like accepting cookies and verifying the page title, and progressing towards more sophisticated scenarios such as user registration, login functionality, and adding products to the cart. By covering various aspects of the website, I aim to identify and address any potential issues, ensuring a seamless and satisfying user experience.

> As a little bonus, I also tried to test a subpage of this website, which operates as a blog at the url [https://www.czc.cz/geek](https://www.czc.cz/geek), subpage 'geek' contains a search form to find articles which was another attractive object to test | see more in [Blog Search Values Test](#blog-search-values-test)

<br>

# Navigation

- [Selected Technologies](#selected-technologies)
- [Application Functionalities](#application-functionalities)
  - [Product Catalog](#product-catalog)
  - [Registration and Login](#registration-and-login)
  - [Favorites](#favorites)
  - [Wishlist](#wishlist)
  - [Shopping Cart and Checkout](#shopping-cart-and-checkout)
  - [Discussions and Reviews](#discussions-and-reviews)
- [Project Tests Prioritization](#project-tests-prioritization)
- [Processes, Tests and Requirements](#processes-tests-and-requirements)
- [Differentiation of Allowed Features for Various Users](#differentiation-of-allowed-features-for-various-users)
- [Tests Overview](#tests-overview)
  - [Demo Tests](#demo-tests)
    - [Accept Cookies Test](#accept-cookies-test)
    - [Browse Through Website Test](#browse-through-website-test)
    - [Create New Account Test](#create-new-account-test)
    - [Login Test](#login-test)
    - [Page Title Test](#page-title-test)
    - [Search Test](#search-test)
    - [Parameterized Search Test](#parameterized-search-test)
    - [Shopping Cart Test](#shopping-cart-test)
    - [Subscribe to Action Offers Test](#subscribe-to-action-offers-test)
    - [Subscribe to Action Offers Wrong Values Test](#subscribe-to-action-offers-wrong-values-test)
    - [Footer Links Test](#footer-links-test)
  - [Registered Customer Test](#registered-customer-test)
    - [Test Diagram](#test-diagram)
  - [Not Registered Customer Test](#not-registered-customer-test)
    - [Test Diagram](#test-diagram-1)
  - [Blog Search Values Test](#blog-search-values-test)
    - [Test Diagram](#test-diagram-2)




<br>

# Selected Technologies

> Java, Selenium, Selenide, Allure, Allure JUnit, Allure Selenide, WebDriverManager, JUnit Jupiter API and JUnit Jupiter Engine, SLF4J Simple

- **Selenium**: A popular open-source framework for automating web browsers.
- **Selenide**: A wrapper framework built on top of Selenium that provides a more concise and expressive syntax for writing UI tests.
- **Allure**: A test reporting framework that generates visually appealing and informative reports.
- **Allure JUnit 5**: The Allure integration for JUnit 5, which allows seamless integration with Allure reporting in JUnit 5 tests.
- **Allure Selenide**: An extension for Allure that captures Selenide-specific logs and integrates them into the Allure reports.
- **WebDriverManager**: A library that automates the management of WebDriver binaries, making it easier to set up and use different web browsers for testing.
- **JUnit Jupiter API and JUnit Jupiter Engine**: The JUnit 5 framework for writing and executing tests.
- **SLF4J Simple**: A simple implementation of the Simple Logging Facade for Java (SLF4J) API, which provides basic logging functionality for tests.

To accomplish my testing goals, I have utilized the Selenium framework in combination with the powerful Selenide library. Selenide provides a user-friendly and concise syntax for writing automated tests, allowing me to efficiently interact with web elements, simulate user actions, and validate the expected behaviors of the website.

As part of my testing strategy, I have incorporated the Allure reporting framework, which generates comprehensive and visually appealing reports. With Allure, I can present my test results in a professional manner, providing detailed insights into the test execution, including step-by-step logs, screenshots, and overall test outcomes. This enhances my ability to track and analyze test failures, making it easier to identify and resolve any potential issues.

<br>

# Application Functionalities

CZC web application is an e-commerce platform specializing in the sale of gaming, electronic, and various other accessories. The primary purpose of this application is to provide users with a seamless and enjoyable shopping experience for their desired products.

## Product Catalog

The application provides a comprehensive product catalog featuring gaming, electronic, and accessory items. Users can browse through different categories, view detailed product information, and add items to their favorites.

## Registration and Login

Users can create an account by registering with their relevant information, including name, email address, and password. Once registered, they can securely log in to their accounts to access personalized features and preferences.

## Favorites

The favorites functionality allows users to mark specific products as their favorites for quick access and future reference. By adding items to their favorites list, users can easily keep track of products they are interested in or plan to purchase later.

## Wishlist

In addition to favorites, the application also offers a wishlist feature. Users can add products to their wishlist to create a curated collection of items they aspire to own. The wishlist provides a convenient way to organize and save desired products.

## Shopping Cart and Checkout

Users can add products to their shopping cart and proceed to checkout when ready to make a purchase. The application offers a streamlined and secure checkout process, allowing users to review their cart, apply discounts or promo codes, select shipping options, and complete the transaction.

## Discussions and Reviews

The application includes a discussion platform where users can engage with others, ask questions, share experiences, and provide feedback or reviews on products. This feature promotes user interaction and helps users make informed purchase decisions.


<br>

# Project Tests Prioritization

When comes to prioritizing tests for the web application, it's essential to focus on critical areas and features that have a significant impact on the overall functionality and user experience. Here you can find my suggested prioritization for this project:

| **Priority**    | **Test Area**                     |
|-----------------|-----------------------------------|
| Low             | `Accept Cookies`                  |
| Low             | `Login and Registration`          |
| Low             | `HomePage and Navigation`         |
| Medium          | `Product Catalog`                 |
| Medium          | `Blog Subpage`                    |
| Medium          | `Favorites and Wishlist`          |
| High            | `Add to Cart`                     |
| High            | `Checkout Process`                |

<br>

# Processes, Tests and Requirements



| **Process**           | **Test**                    | **Requirement**                                             |
|-----------------------|-----------------------------|-------------------------------------------------------------|
| Accept Cookies        | `AcceptCookiesTest`         | The user must be able to accept cookies in order to continue|
| Website Navigation    | `BrowseThroughWebsiteTest`  | The user must be able to browse the web page without error limitations|
| Registration of New User   | `CreateNewAccountTest`      | The user must be able to register with the correct data                   |
| Login to Website      | `LoginTest`                 | The registered user must be able to log in correctly                   |
| Correct Page Title    | `PageTitleTest`             | The system must return the correct web page title                  |
| Search Through Website Single | `SearchTest`    | The user must be able to find a specific product with appropriate return value                   |
| Search Through Website Parametrized | `ParametrizedSearchTest`               | The user must be able to search for various products with adequate return value                   |
| Usage of Shopping Cart| `ShoppingCartTest`          | The user must be able to add a product to the shopping cart and then work with the shopping cart                   |
| Subscribe to Action Offers | `SubscribeToActionOffersTest` / `SubscribeToActionOffersWrongValuesTest`     | The user must be able to subscribe to action offers with a correct email address|
| Website Footer Navigation | `FooterLinksTest`          | The user must be able to click individually between the links in the footer section of the web page                  |

> By combining these test cases, we can perform more sophisticated tests and ensure comprehensive coverage of the website's functionality and user experience.

<br>

# Differentiation of Allowed Features for Various Users

| **Feature**                | **Registered User** | **Non-Registered User** |
|----------------------------|-----------------|---------------------|
| **Add to Wish List**       | Allowed         | Not Allowed         |
| **Add to Favorite**        | Allowed         | Not Allowed         |
| **Search**                 | Allowed         | Allowed             |
| **Buy Items**              | Allowed         | Allowed             |
| **Subscribe to Offers**    | Allowed         | Allowed             |

<br>

# Tests Overview

## Demo Tests

<br>

---

### Accept Cookies Test

This test case validates the functionality of accepting cookies on the website. It ensures that the user can successfully click on the "Accept Cookies" button to acknowledge and accept the use of cookies on the website.

**Test Scenario**:

1. Navigate to the website URL.
2. Click on the "Accept Cookies" button.

**Expected Result**: The user should be able to accept cookies and continue using the website without any issues.

---

### Browse Through Website Test

This test case verifies the functionality of browsing through various elements on the website. It uses parameterized testing to iterate over a set of elements and clicks on each element to navigate to the corresponding page.

**Test Scenario**:

1. Navigate to the website URL.
2. Accept cookies by clicking on the "Accept Cookies" button.
3. Click on the main page link to ensure you start from the homepage.
4. Parameterized Test: Iterate over a stream of elements.
5. For each element, click on it to navigate to the corresponding page.
6. After each iteration, return to the main page to reset the state for the next iteration.

**Expected Result**: The user should be able to browse the web page without any errors or limitations and experience smooth navigation throughout the website.

---

### Create New Account Test

This test case verifies the functionality of creating a new account on the website.

**Test Scenario**:

1. Navigate to the website URL.
2. Accept cookies by clicking on the "Accept Cookies" button.
3. Find and Click on the "Create Account" button to navigate to the registration form.
4. Verify that the registration heading contains the expected text.
5. Verify the visibility of all necessary components on the registration form.
6. Verify if the "Register" button is visible.

| Field       | Correct Data        | Wrong Data                 |
|-------------|---------------------|----------------------------|
| Email       | ^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$ | empty field / not in match of regular expression              |
| Phone       | +421 123 456 789       | empty field |
| Name        | John                | empty field |
| Surname     | Doe                 | empty field |
| Nickname    | johndoe             | empty field |
| Password    | P@ssw0rd            | empty field |
| Street      | 123 Main St         | not valid address type (only numbers / only special characters) / empty field               |
| City        | New York            | not valid city (only numbers / only special characters) / empty field|
| ZipCode     | 10001               | not valid zipcode (only special characters) / empty field |

Explanation of the regular expression for email address:

> **^** asserts the start of the string.
>
> **[a-zA-Z0-9_.+-]+** matches one or more of the allowed characters in the email username part, which can include letters (both uppercase and lowercase), digits, underscore, dot, plus, and hyphen.
>
> **@** matches the literal "@" symbol.
>
> **[a-zA-Z0-9-]+** matches one or more of the allowed characters in the email domain name part, which can include letters (both uppercase and lowercase), digits, and hyphen.
>
> **\.** matches the literal dot (.) used to separate the domain name from the top-level domain.
>
> **[a-zA-Z0-9-.]+** matches one or more of the allowed characters in the email top-level domain part, which can include letters (both uppercase and lowercase), digits, hyphen, and dot.
>
> **$** asserts the end of the string.

![register](assets/register.png)

---

![table](assets/table.png)

**Expected Result**: The user should be able to register with the correct data and successfully create a new account.

---

### Login Test

This test case verifies the functionality of the login process on the website.

**Test Scenario**:

1. Navigate to the website URL.
2. Accept cookies by clicking on the "Accept Cookies" button.
3. Click on the "Login" button to navigate to the login form.
4. Verify the visibility of the login input fields (username and password).
5. Check if the labels for the username and password inputs are visible.
6. Verify the visibility of the login button and the button to accept the login terms.

**Expected Result**: The registered user should be able to log in correctly and access their account without any issues.

---

### Page Title Test

This test case checks the title of the webpage and verifies that it matches the expected title.

**Test Scenario**:

1. Navigate to the website URL.
2. Retrieve the actual page title using Selenide's title() method.
3. Compare the actual page title with the expected page title.
4. Assert that the actual page title is equal to the expected page title.

**Expected Result**: The system should return the correct web page title, which should match the expected title.

---

### Search Test

This test case searches for a specific value (in my case, "Iphone") on the website and verifies the search results. 

**Test Scenario**:

1. Accept cookies if necessary by clicking on the accept cookies button.
2. Locate the search input element and set its value to the searched value ("Iphone").
3. Click on the search button.
4. Set the timeout for element search to 6000 milliseconds.
5. Verify that the search heading is visible and contains the searched value.
6. Retrieve the first three search results and store them in a list of SelenideElements.
7. Iterate over the first three search results and verify that each result has a button to add the item to the shopping cart.

**Expected Result**: The user should be able to find a specific product through the search feature, and the returned results should match the expected search criteria.

---

### Parameterized Search Test

This test case performs a search on the website using different search values. It uses parameterized testing, where the search values are provided through a CSV source.

**Test Scenario**:

1. Set up the test environment by opening the website and accepting cookies.
2. Locate the search input element and set its value to the current search value.
3. Click on the search button.
4. Set the timeout for element search to 6000 milliseconds.
5. Verify that the search heading is visible and contains the current search value.
6. Retrieve the first three search results and store them in a list of SelenideElements.
7. Iterate over the first three search results and verify that each result has a button to add the item to the shopping cart.

**Expected Result**: The user should be able to search for various products using different parameterized search queries, and the returned results should match the expected search criteria for each query.

---

### Shopping Cart Test

This test ensures that the shopping cart functionality is working correctly by adding items to the cart, navigating to the cart page, and performing necessary actions.

**Test Scenario**:

1. Set up the test environment by opening the website, accepting cookies, and locating the shopping cart button.
2. Click on the shopping cart button.
3. Verify that the empty shopping cart heading is visible.
4. Click on the "Back to Shop" button to return to the main shop page.
5. Locate an element selected for user in the carousel and click on its button.
6. Click on the shopping cart button again.
7. Verify that the "Proceed to Checkout" button is visible.

**Expected Result**: The user should be able to add a product to the shopping cart, view the shopping cart contents, and perform various actions on the shopping cart without any issues.

---

### Subscribe to Action Offers Test

The SubscribeToActionOffersTest is a parameterized test case that verifies the functionality of subscribing to action offers on the website with accepted email values.

**Test Scenario**:

1. Set up the test environment by opening the website, accepting cookies, and locating the subscribe input field and button.
2. For each parameterized input value (email address) in the CSV source, perform the following steps:
- Set the value of the subscribe input field to the current email value.
- Click on the subscribe button.
3. After each test iteration, click on the main page link to navigate back to the main page.

**Expected Result**: The user should be able to subscribe to action offers using a correct email address and receive a confirmation message or email.

---

### Subscribe to Action Offers Wrong Values Test

The SubscribeToActionOffersWrongValuesTest is a parameterized test case that verifies the functionality of subscribing to action offers on the website with not accepted email values.

**Test Scenario**:

1. Set up the test environment by opening the website, accepting cookies, and locating the subscribe input field and button.
2. For each parameterized input value (email address) in the CSV source, perform the following steps:
- Set the value of the subscribe input field to the current email value.
- Click on the subscribe button.
3. After each test iteration, page throws an error about wrong email address, then clear the already set value and back to step 2.

---

### Footer Links Test

This test focuses on validating the functionality of multiple links in the footer navigation of a web page.

The test performs the following checks for each link:

- It locates the link element and ensures its visibility.
- It clicks on the link.
- It verifies the visibility of a specific element on the resulting page (e.g., a heading element).

> Each link is individually tested, including links for "About Us," "About Mall Group," "Contact Form," "Shipping and Payment," "Complaints," "Stores," "ISIC," "Services," "Affiliate Program," and "Documents for Download."

**Expected Result**: The user should be able to click on each link in the footer section and navigate to the intended page or perform the expected action without any issues.

---

<br>

## Registered Customer Test

The RegisteredCustomerTest represents a comprehensive test scenario that simulates a user's who is already a member of the website and his interaction with the website. Here's a description of the test scenario:

> This test scenario simulates the user's 'journey' on the website. 

The user performs the following steps:

1. **Accept Cookies** :

- The user accepts the cookies by clicking on the "Accept" button.

2. **Navigate to Create New Account** :

- The user clicks on the "Login" button to initiate the registration process.
- The user verifies that the registration heading contains the expected text.
- The user clicks on the registration button to navigate to the registration form.
- The user verifies the visibility of all necessary components in the registration form.

3. **Create New Account** :

- The user fills in the registration form with the provided user details.
- The user clicks on the "Register" button to create a new account.
- The user clicks on the main page link to navigate back to the main page.

4. **Login to Already Created Account** :

- The user clicks on the "Login" button.
- The user enters the login credentials (username and password) for the already created account.
- The user clicks on the "Accept" button to log in.
- The user clicks on the main page link to navigate back to the main page.

5. **Preview My Current Orders** :

- The user clicks on the user's profile link.
- The user triggers the menu by moving the mouse cursor over the user's profile menu.
- The user clicks on the "My Orders" link from the menu.
- The user checks that "My Orders" section is empty and clicks on the main page link to navigate back to the main page.

6. **Preview Empty Shopping Cart** :

- The user clicks on the shopping cart button.
- The user verifies the visibility of the empty shopping cart heading.
- The user clicks on the "Back to Shop" button to navigate back to the main page.

7. **Make Random Choice from Selected Items and Add It to the Shopping Cart** :

- The user makes a random choice from the selected items carousel and adds it to the shopping cart.
- The user clicks on the shopping cart button to view the shopping cart.

8. **Navigate Through the Shopping Cart Menu** :

- The user proceeds with the order by clicking on the confirmation buttons.
- The user clicks on the "Close the Order" button and navigates back to the shopping cart.
- The user removes the current item from the shopping cart.
- The user clicks on the "Navigate Back to the Shop" button to return to the main page.

9. **Make Random Choice from Selected Items and Add It to the Wishlist**:

- The user makes a random choice from the selected items carousel and adds it to the wishlist.
- The user clicks on the main page link to navigate back to the main page.

10. **Search Products** :

- The user performs a search for various products using the provided search values.
- The user verifies the search results and the visibility of the "Add to Cart" buttons for the first three results.
- The user clicks on the main page link to navigate back to the main page.

> This comprehensive test scenario covers various user actions on the website, including registration, login, cart management, wishlist management, and product search.

### Test Diagram

![registeredCustomerTest](assets/registeredCustomerTest.png)


<br>


## Not Registered Customer Test

This test simulates the behavior of a not registered customer who has certain restrictions, such as the inability to add products to their wishlist or favorites.

The user performs the following steps:

1. **Accept Cookies** :

- The user accepts the cookies by clicking on the "Accept" button.

2. **Pefrorms Search Action on Website** :

- Enter a search term 
- Click the search button.
- Verify that the search heading displays the searched value.
- Locate the product tiles and select the first tile.
- Click on the product link to view its details.

3. **Demonstration - Add to Favourites** :

- The user waits until the product details are all loaded
- Tries to add corresponding product to his "favourites"
- Website returns Error Message - 'Not registered...'
- The user returns back to main page and then repeats step 2. with another search value

### Test Diagram

![notRegisteredCustomerTest](assets/notRegisteredCustomerTest.png)


<br>

## Blog Search Values Test

This test focuses on the functionality of searching for values on a website's blog subpage. It navigates to the blog subpage, performs multiple search operations with different values, and captures the results.

1. **Open the website**: 

- Launch the website under test and accept the cookie policy by clicking the "Accept Cookies" button

2. **Navigate to the blog subpage**: 
- Click on the blog subpage link to access the blog section of the website

3. **Perform search operations**: 

For each value provided in the test data : 

- Enter the value in the search input field
- Click the search button
- Wait for the results to load

4. **Capture results**:
 
- Check if an alert element is displayed on the page. 
- IFF TRUE: add the searched value to the list of wrong values ELSE: add it to the list of right values

5 **Print test results**: 

- After all search operations are completed, print the captured wrong values and right values for further analysis.

### Test Diagram

![blogSearchValues](uploads/df7d454751cb49126536f410ce1dedfc/blogSearchValues.png)
