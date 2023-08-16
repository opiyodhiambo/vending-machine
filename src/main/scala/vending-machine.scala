// Creating my VendingMachine
class VendingMachine {
  var chocolateBar = 0
  var granolaBar   = 0
  var proteinBar   = 0
  var totalMoney   = 0.0

  // Creating a function for buying the product
  def buy(product: String, money: Double): String = {
    if (!isProductAvailable(product))
      s"Sorry, $product is out of stock" // If the product is not available, tell them we are out of stock
    else if (!isMoneyEnough(product, money))
      s"Please top up and try again!" // If they put in less money, tell them to top up
    else
      completeRequest(
        product,
        money
      ) // of there is a product and the money is enough, complete the transaction
  }
  // Creating a function to verify if the product is in stock
  def isProductAvailable(product: String): Boolean = {
    val productQuantity = {
      if (product == "Chocolate")
        chocolateBar // if they request for a Chocolate, give them a chocolateBar
      else if (product == "Granola")
        granolaBar // If they request for a Granola, give them a granolaBar
      else if (product == "Protein")
        proteinBar // If they request for a protein bar, give them a proteinBar
      else 0       // Don't give them anything if they do not as for it
    }
    productQuantity > 0 // it only returns true if the product quantity is more than 0 (meaning that is is actually available)
  }
  def isMoneyEnough(product: String, money: Double): Boolean = {
    val cost = {
      if (product == "Chocolate") 250.0
      else if (product == "Granola") 100.0
      else 75.0
    }
    money > cost
  }
  def completeRequest(product: String, money: Double) = {
    collectMoney(money)
    releaseProduct(product)
    s"Enjoy your $product"
  }
  def collectMoney(money: Double): Double = {
    totalMoney += money
    totalMoney
  }

  def releaseProduct(product: String) = {
    if (product == "Chocolate") chocolateBar -= 1
    else if (product == "Granola") granolaBar -= 1
    else proteinBar -= 1
  }

} 
