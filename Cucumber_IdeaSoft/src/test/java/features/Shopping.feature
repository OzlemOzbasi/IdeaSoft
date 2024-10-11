
Feature: Shopping Functionality

  Scenario: Shopping Function

    Given Navigate to Fexx
    When  Search for "ürün" in the search bar
    And   Click to "searchButton"
    And   Select "Teknoloji" from the Kategoriler
    And   Click to "Ara"
    And   Go to the details of the selected product
    And   Add 5 product to cart
    And   Click to "Sepete Ekle"
    And   Should be able to "SEPETİNİZE EKLENMİŞTİR" confirm message
    When  Click to "Sepet"
    Then  Confirm that there are 5 product in the cart

